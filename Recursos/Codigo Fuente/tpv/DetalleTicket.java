package tpv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

public class DetalleTicket extends Boton{
	public int cantidad;
	public String nombreArticulo;
	public int idArticuloFK;
	public int precio;
	public int importedetalle;
	public int idTicketFK;
	private Statement stmt;
	private ResultSet rs;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	Font mono = new Font("Monospaced", Font.PLAIN, 14);
	/**
	 * CONSTRUCTOR DE NUEVO DETALLE EN BASE DE DATOS
	 * @param nombre
	 * @param stmt
	 * @param idTicket
	 */
	public DetalleTicket(String nombre, Statement stmt, int idTicket){
		cantidad = 1;
		nombreArticulo = nombre;
		idTicketFK = idTicket;
		this.stmt = stmt;
		try {
			// Adquirimos precio y idArticulo Articulo
			ResultSet rs = stmt.executeQuery("SELECT precioArticulo,idArticulo FROM Articulos WHERE nombreArticulo = '" + nombre + "'");
			while ( rs.next()){
				precio = (int)(rs.getDouble("precioArticulo")*100);
				idArticuloFK = rs.getInt("idArticulo");
			}
			// Insertamos Detalle en Base de Datos
			stmt.executeUpdate("INSERT INTO restaurante.DetalleTicket (idTicketFK,idArticuloFK,cantidadArticulo,precioArticulo) " +
					"VALUES ("+idTicketFK+","+idArticuloFK+","+cantidad+","+precio+")");
			
		} catch (SQLException e) {
			System.out.println("ERROR SQL " + e.toString());
		}
		importedetalle = cantidad * precio;
		this.setText(this.toHtml());
		this.setBackground(Color.white);
		this.setHorizontalAlignment(JButton.RIGHT);
		this.setFont(mono);
		this.setPreferredSize(new Dimension(395,22));
	}
	/**
	 * CONSTRUCTOR DE OBJETO DETALLE EXISTENTE EN BASE DE DATOS
	 * @param cantidad
	 * @param nombre
	 * @param precio
	 */
	public DetalleTicket(int cantidad, String nombre, int precio, int idTicket, int idArticulo, Statement stmt){
		this.cantidad = cantidad;
		this.nombreArticulo = nombre;
		this.precio = precio;
		importedetalle = cantidad * precio;
		this.idArticuloFK = idArticulo;
		this.idTicketFK = idTicket;
		this.stmt = stmt;
		this.setText(this.toHtml());
		this.setBackground(Color.white);
		this.setHorizontalAlignment(JButton.RIGHT);
		this.setFont(mono);
		this.setPreferredSize(new Dimension(395,22));
	}
	public void cantidadmas(){
		cantidad++;
		importedetalle = cantidad * precio;
		//Actualizamos Base de datos
		try {
			stmt.executeUpdate("UPDATE restaurante.DetalleTicket SET cantidadArticulo="+cantidad+
					" WHERE idTicketFK="+this.idTicketFK+" AND idArticuloFK="+this.idArticuloFK);
		} catch (SQLException e) {
			System.out.println("ERROR SQL " + e.toString());
		}
		this.setText(this.toHtml());
	}
	public boolean cantidadmenos(){
		if (cantidad>1){
			cantidad--;
			try {
				stmt.executeUpdate("UPDATE restaurante.DetalleTicket SET cantidadArticulo="+cantidad+
						" WHERE idTicketFK="+this.idTicketFK+" AND idArticuloFK="+this.idArticuloFK);
			} catch (SQLException e) {
				System.out.println("ERROR SQL " + e.toString());
			}
			importedetalle = cantidad * precio;
			this.setText(this.toHtml());
			return false;
		} else {
			try {
				stmt.executeUpdate("DELETE FROM restaurante.DetalleTicket WHERE idArticuloFK="+idArticuloFK+
						" AND idTicketFK=" + idTicketFK);
			} catch (SQLException e) {
				System.out.println("ERROR SQL " + e.toString());
			}
			return true;
		}
				
	}
	public String toString(){
		baos.reset();
		double auxprecio = (double)precio/100;
		double auximporte = (double)importedetalle/100;
		ps.format("%-5d %20.20s %10.2f %10.2f\n", cantidad, nombreArticulo, auxprecio, auximporte);
		return baos.toString();
	}
	public String toHtml(){
		baos.reset();
		double auxprecio = (double)precio/100;
		double auximporte = (double)importedetalle/100;
		ps.format("%-5d %18.18s %10.2f %10.2f\n", cantidad, nombreArticulo, auxprecio, auximporte);
		return "<html>" + baos.toString().replaceAll(" ", "&nbsp;") + "</html>";
	}
	public String getNombre(){
		return nombreArticulo;
	}
}
