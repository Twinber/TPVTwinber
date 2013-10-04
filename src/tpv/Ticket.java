package tpv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Ticket extends Boton{
	public int idTicket;
	public String nombreTicket;
	public String fecha;
	public String nombreMesa;
	private static final String DATE_FORMAT_AHORA = "yyyy-MM-dd HH:mm:ss";
	public List<DetalleTicket> listaDetalle = new ArrayList<DetalleTicket>();
	private Statement stmt;
	private ResultSet rs;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	boolean cobrado = false;
	double importe;
	/**
	 * CONSTRUCTOR NUEVOS TICKETS
	 * @param nombre
	 * @param stmt
	 */
	public Ticket(String nombre, Statement stmt){
		nombreTicket = nombre;
		this.stmt = stmt;
		fecha = ahora();
		this.setText(nombreTicket);
		this.setPreferredSize(new Dimension(90,50));
		this.setBackground(Color.white);
		nombreMesa = nombre;
		if (nombreMesa.indexOf("Barra")>=0){
			nombreMesa = "Barra";
		} else if (nombreMesa.indexOf("Llevar")>=0){
			nombreMesa = "Llevar";
		}
		
		try {
			stmt.executeUpdate("INSERT INTO restaurante.Tickets (idMesaFK,cobrado,fecha)" +
					" VALUES ((SELECT idMesa FROM restaurante.Mesas WHERE nombreMesa='"+nombreMesa+"')" +
							", FALSE, '"+fecha+"')");
			ResultSet rs = stmt.executeQuery("SELECT MAX(idTicket) FROM restaurante.Tickets");
			while (rs.next()){
				idTicket = rs.getInt("MAX(idTicket)");
			}
		} catch (SQLException e) {
			System.out.println("Error SQL" + e.toString());
		}  
	}
	
	/**
	 * CONSTRUCTOR DE TICKECT EXISTENTE EN BASE DE DATOS NO COBRADO
	 * @param idTicket
	 * @param nombreTicket
	 */
	public Ticket(int idTicket, String nombreTicket){
		this.idTicket = idTicket;
		this.nombreTicket = nombreTicket;
		this.setText(nombreTicket);
		this.setPreferredSize(new Dimension(90,50));
		this.setBackground(Color.white);
		//Cargamos detalles del ticket
		try {
			//Al estar realizandose la creacion del ticket con un ResultSet Abierto necesitamos una nueva conexion
			//String dsn = new String("jdbc:mysql://localhost/restaurante");
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection conexion = DriverManager.getConnection(dsn, "admin", "a2b3C4");
			String dsn = new String("jdbc:odbc:ODBCRestaurante"); //Conector JDBC:ODBC
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			Connection conexion = DriverManager.getConnection(dsn);
			
			
			stmt= conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cantidadArticulo,nombreArticulo,DetalleTicket.precioArticulo," +
					"idArticuloFK,cobrado,fecha FROM DetalleTicket,Articulos,Tickets " +
					"WHERE idTicketFK="+ idTicket+ " AND idArticuloFK=idArticulo AND idTicket=" + idTicket);
			while (rs.next()){
				int cantidad = rs.getInt("cantidadArticulo");
				String nombre = rs.getString("nombreArticulo");
				int precio = rs.getInt("precioArticulo");
				int idArticulo = rs.getInt("idArticuloFk");
				listaDetalle.add(new DetalleTicket(cantidad, nombre, precio, idTicket, idArticulo, stmt));
				cobrado = rs.getBoolean("cobrado");
				this.fecha = rs.getString("fecha");
			}
			
			
		} catch (Exception e) {
			System.out.println("Error SQL" + e.toString());
		}
	}
	/**
	 * CONSTRUCTOR DE TICKET EXISTENTE EN BASE DE DATOS YA COBRADO 
	 * @param idTicket
	 * @param nombreTicket
	 * @param cobrado
	 */
	public Ticket(int idTicket, String nombreTicket, boolean cobrado){
		this.idTicket = idTicket;
		this.nombreTicket = nombreTicket;
		this.setText(nombreTicket);
		this.setPreferredSize(new Dimension(90,50));
		this.setBackground(Color.white);
		this.cobrado = cobrado;
		//Cargamos detalles del ticket
		try {
			//Al estar realizandose la creacion del ticket con un ResultSet Abierto necesitamos una nueva conexion
			String dsn = new String("jdbc:odbc:ODBCRestaurante");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conexion = DriverManager.getConnection(dsn);
			stmt= conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cantidadArticulo,nombreArticulo,DetalleTicket.precioArticulo," +
					"idArticuloFK,importeIngreso,fecha FROM DetalleTicket,Articulos,Tickets,Caja " +
					"WHERE idTicketFK="+ idTicket+ " AND idArticuloFK=idArticulo AND idTicket=" + idTicket +
					" AND idTicketCobradoFK=" + idTicket);
			while (rs.next()){
				int cantidad = rs.getInt("cantidadArticulo");
				String nombre = rs.getString("nombreArticulo");
				int precio = rs.getInt("precioArticulo");
				int idArticulo = rs.getInt("idArticuloFk");
				listaDetalle.add(new DetalleTicket(cantidad, nombre, precio, idTicket, idArticulo, stmt));
				this.importe = rs.getDouble("importeIngreso");
				this.fecha = rs.getString("fecha");
			}
			
		} catch (Exception e) {
			System.out.println("Error SQL" + e.toString());
		}
	}
	
	public void añadeDetalle(String nombre, Statement stmt){
		boolean existe = false;
		for (DetalleTicket detalle : listaDetalle) {
			if (detalle.nombreArticulo.equals(nombre)){
				detalle.cantidadmas();
				existe = true;
			}
		}
		if (!existe){
			DetalleTicket nuevoDetalle = new DetalleTicket(nombre,stmt,idTicket);
			listaDetalle.add(nuevoDetalle);
		}
	}
	
	public static String ahora(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_AHORA);
		return sdf.format(cal.getTime());
	}
	
	public int totalTicket(){
		int suma=0;
		for (DetalleTicket detalle : listaDetalle) {
			suma += detalle.importedetalle;
		}
		return suma;
	}
	public String toString(){
		Double totalTicket = 0.00;
		ps.format("%-10s %-8d %15s\n", "Ticket nº",idTicket,fecha);
		ps.println();
		for (DetalleTicket detalle: listaDetalle) {
			ps.append(detalle.toString());
			ps.println();
			totalTicket += detalle.importedetalle;
		}
		ps.println();
		ps.format("%37s %10.2f\n", "TOTAL",totalTicket/100);
		return baos.toString();
	}
	public void cobrado(){
		try {
			ResultSet rs = stmt.executeQuery("SELECT cobrado FROM Tickets WHERE idTicket=" + this.idTicket);
			rs.next();
			if (!rs.getBoolean("cobrado")){
				// COBRADO NUEVO TICKET
				stmt.executeUpdate("UPDATE restaurante.Tickets SET cobrado=TRUE" +
						" WHERE idTicket="+this.idTicket);
				stmt.executeUpdate("INSERT INTO restaurante.Caja (idTicketCobradoFK,importeIngreso) " +
						"VALUES (" + this.idTicket + "," + (double)this.totalTicket()/100 + ")");
				cobrado = true;

			} else { 
				// MODIFICADO TICKET YA COBRADO
				stmt.executeUpdate("UPDATE Caja SET importeIngreso=" + (double)this.totalTicket()/100 + 
						" WHERE idTicketCobradoFK=" + this.idTicket);
			}
			
		} catch (SQLException e) {
			System.out.println("Error SQL" + e.toString());
		}
	}
	public String getNombre(){
		return nombreTicket;
	}
	
	public void imprimir() {
		try{
		new Impresor(this);
		} catch (Exception e){
			System.out.println("Error de impresion");
		}
		//ALTERNATIVAMENTE GUARDAMOS UN FICHERO
		try
		{
			PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("Ticket.txt")));
			salida.print(this.toString());
			salida.close();
			
						
		} catch(IOException i){
			System.out.println("Se produjo un error de Archivo");
		}       
	}
	
}



