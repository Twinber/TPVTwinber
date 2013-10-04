package tpv;

import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton{
	BufferedImage img = null;
	private String nombreBoton;
	public Boton(String label){
		//try {
		//	img = ImageIO.read(getClass().getResource( label + ".jpg"));
		//} catch (IOException e) {}
		//catch (IllegalArgumentException e) {}
		
		URL imageurl = tpv.TPVTwinber.class.getResource("Imagenes/" + label + ".jpg");
		if (imageurl!=null){
			ImageIcon icon = new ImageIcon(imageurl);
			this.setIcon(icon);
		}
		//String imagen = System.getProperty("user.dir") + "\\Imagenes\\" + label + ".jpg";
		//System.out.println(imagen);
		//if (new File(imagen).exists()){
		//	this.setIcon(new ImageIcon((imagen)));
		//}
		setText("<html><p align=\"center\">"+label+"</p></html>");
		setMargin(new Insets(1,1,1,1));
		nombreBoton = label;
	}
	public Boton(){
		setText("");
		setMargin(new Insets(1,1,1,1));
		nombreBoton="";
	}
	
	public String getNombre(){
		return nombreBoton;
	}
	public void setNombre(String nombre){
		nombreBoton=nombre;
		nombre.replaceAll(" ", "&nbsp;");
		setText("<html><p align=\"center\">"+nombre+"</p></html>");
	}

}

