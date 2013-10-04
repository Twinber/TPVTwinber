package tpv;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PageAttributes;
import java.awt.PageAttributes.MediaType;
import java.awt.PrintJob;

public class Impresor extends Frame{
	Graphics pg;
	PrintJob pjob;
	public Impresor(Ticket t){
		try {
		Double totalTicket = 0.00;
		PageAttributes pa= new PageAttributes();
		pa.setMedia(MediaType.A6);
		pjob = this.getToolkit().getPrintJob(this, "Ticket", null, pa );
		pg = pjob.getGraphics();
		Font mono = new Font("Monospaced",Font.PLAIN,8); 
		pg.setFont(mono);
		FontMetrics metrica = pg.getFontMetrics();
		int saltodelinea = metrica.getHeight(); 
		int linea = 25;
		pg.drawString (String.format("%-10s %-8d %15s\n", "Ticket nº",t.idTicket,t.fecha),25,linea);
		linea += saltodelinea;
		for (DetalleTicket detalle: t.listaDetalle) {
			linea += saltodelinea;
			pg.drawString(detalle.toString(),25,linea);
			totalTicket += detalle.importedetalle;
		}
		linea += saltodelinea*2;
		pg.drawString(String.format("%37s %10.2f\n", "TOTAL",totalTicket/100),25,linea);
		
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			pg.dispose();
			pjob.end();
		}
		
	}
	
}
