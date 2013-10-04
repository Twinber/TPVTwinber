package tpv;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;



public class CrearPdf {
	ResultSet rs = null;
	Document document  = new Document();
	String total; // Para listados que necesiten un total
	public CrearPdf(String filename, ResultSet rs,String listado, String total)	throws IOException, DocumentException, SQLException{
		this.rs = rs;
		this.total=total;
		PdfWriter.getInstance(document, new FileOutputStream(filename)).setInitialLeading(16);
		document.open();
		switch (listado){
		case "articulos": articulos();break;
		case "huerfanos": huerfanos();break;
		case "caja": caja();break;
		case "masVendidos": masVendidos();break;
		}
		try {
		     File path = new File (filename);
		     Desktop.getDesktop().open(path);
		}catch (IOException ex) {
		     ex.printStackTrace();
		}
		document.close();
		
	}
	public void articulos() throws SQLException, DocumentException{
		//TODO Imprimir lista de precios con maquetacion adecuada
		// Por ejemplo creando un String con Format
		document.add(new Chunk ("LISTADO DE PRECIOS ORDENADO POR CATEGORIAS"));
		document.add(Chunk.NEWLINE);
		while (rs.next()) {
			document.add(new Chunk(rs.getString("categoriaArticulo")));
			document.add(new Chunk(" - "));
			document.add(new Chunk(rs.getString("nombreArticulo")));
			document.add(new Chunk(" - "));
			String precio = "";
			precio += rs.getDouble("precioArticulo");
			document.add(new Chunk(precio));
			document.add(new Chunk(" Euros. "));
			document.add(Chunk.NEWLINE);
		}
	}
	public void huerfanos() throws SQLException, DocumentException{
		document.add(new Chunk ("LISTADO DE ARTICULOS HUERFANOS"));
		document.add(Chunk.NEWLINE);
		while (rs.next()) {
			document.add(new Chunk(rs.getString("categoriaArticulo")));
			document.add(new Chunk(" - "));
			document.add(new Chunk(rs.getString("nombreArticulo")));
			document.add(new Chunk(" - "));
			String precio = "";
			precio += rs.getDouble("precioArticulo");
			document.add(new Chunk(precio));
			document.add(new Chunk(" Euros. "));
			document.add(Chunk.NEWLINE);
		}
	}
	
	public void caja() throws SQLException, DocumentException{
		document.add(new Chunk ("LISTADO DE MOVIMIENTOS DE CAJA"));
		document.add(Chunk.NEWLINE);
		String importe = "";
		while (rs.next()) {
			document.add(new Chunk(rs.getString("idMovimiento")));
			document.add(new Chunk(" - "));
			String ticket = rs.getString("idTicketCobradoFK");
			if (ticket!=null){
				document.add(new Chunk("Ticket Nº "));
				document.add(new Chunk(ticket));
			} else {
				document.add(new Chunk("Ingreso/Retirada "));
			}
			document.add(new Chunk(" : "));
			importe = "" + rs.getDouble("importeIngreso");
			document.add(new Chunk(importe));
			document.add(new Chunk(" Euros. "));
			document.add(Chunk.NEWLINE);
						
		}
		document.add(new Chunk("SALDO EN CAJA :" + total + " EUROS. "));
	}
	
	public void masVendidos() throws SQLException, DocumentException{
		document.add(new Chunk ("LISTADO DE ARTICULOS MAS VENDIDOS"));
		document.add(Chunk.NEWLINE);
		while (rs.next()) {
			document.add(new Chunk(rs.getString("nombreArticulo")));
			document.add(new Chunk(" - "));
			int total = rs.getInt("total");
			document.add(new Chunk(""+total+ " Uds."));
			document.add(Chunk.NEWLINE);
						
		}
		
	}
}
