package tpv;
// SOLO GERENTE PUEDE CAMBIAR NOMBRES ARTICULOS, CAMBIAR PRECIOS, LISTAR INFOMES
// SOLO GERENTE Y ENCARGADO PUEDEN OPERACIONES DE CAJA, CREAR ARTICULOS HUERFANOS, REABRIR TICKETS
//TODO BARRAS SCROLL EN PANEL ARTICULOS Y TICKETACTIVO
//TODO CREACION DE USUARIOS Y CAMBIO DE PASSWORD POR PARTE DEL GERENTE / ENCARGADO

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.DocumentException;

/**
 * TPV para Restaurante-Bar
 * @author twinber
 *
 */
public class TPVTwinber extends Frame implements ActionListener,FocusListener{

	// ******** COMPONENTES DE VENTANA PRINCIPAL ********
	Panel panelizquierdo = new Panel();
	Panel ticketActivo = new Panel();
	Panel ticketActivoSuperior = new Panel();
	Boton botonUsuario = new Boton("Usuario");
	Label numeroTicket = new Label("Ticket nº 000000");
	Panel ticketActivoCentral = new Panel();
	List<Label> detalleTicket = new ArrayList<Label>();
	Panel ticketActivoInferior = new Panel();
	Boton botonNuevoTicket = new Boton("Nuevo Ticket");
	Label sumaTicket = new Label("Total... 0,00");
	Panel menus = new Panel();
	Boton botonMas = new Boton("Más");
	Boton botonMenos = new Boton("Menos");
	Boton botonImprimir = new Boton ("Imprimir");
	Boton botonCobrar = new Boton ("Cobrar");
	Boton botonCaja = new Boton ("Caja");
	Panel panelderecho = new Panel();
	Panel categorias = new Panel();
	Boton botonBebidas = new Boton("BEBIDAS");
	Boton botonEnsaldas = new Boton("ENSALADAS");
	Boton botonEntrantes = new Boton("ENTRANTES");
	Boton botonVinos = new Boton("VINOS");
	Boton botonCarnes = new Boton("CARNES");
	Boton botonPescados = new Boton("PESCADOS");
	Boton botonPostres = new Boton("POSTRES");
	Boton botonHelados = new Boton("HELADOS");
	Boton botonCafes = new Boton("CAFES");
	Boton botonMenu = new Boton("MENU");
	Panel articulos = new Panel();
	Boton botonNuevoArticulo = new Boton("Nuevo...");
	Panel ticketsAbiertos = new Panel();

	// ******** COMPONENTES DE DIALOGO ALTA DE ARTICULOS ********
	Dialog altas = new Dialog(this,"Artículo no registrado",true);
	Label descripcionLabel = new Label("descripción");
	Boton descripcionArticulo = new Boton("- - -");
	Label cantidadLabel = new Label("cantidad");
	TextField cantidadArticulo = new TextField("",40);
	Label precioLabel = new Label("precio");
	TextField precioArticulo = new TextField("",40);
	Boton n7altas = new Boton("7");
	Boton n8altas = new Boton("8");
	Boton n9altas = new Boton("9");
	Boton n4altas = new Boton("4");
	Boton n5altas = new Boton("5");
	Boton n6altas = new Boton("6");
	Boton n1altas = new Boton("1");
	Boton n2altas = new Boton("2");
	Boton n3altas = new Boton("3");
	Boton n0altas = new Boton("0");
	Boton comaaltas = new Boton(",");
	Boton delaltas = new Boton("del");
	Boton okaltas = new Boton("OK");
	Boton escaltas = new Boton("ESC");
	Boton nuevoaltas = new Boton ("nuevo artículo");

	// ******** COMPONENTES DE DIALOGO COBRAR/ADEVOLVER ********
	Dialog cobrar = new Dialog(this,"¿Cuanto nos da el cliente?",true);
	Boton importeEntregado = new Boton("0");
	Boton n7cobrar = new Boton("7");
	Boton n8cobrar = new Boton("8");
	Boton n9cobrar = new Boton("9");
	Boton n4cobrar = new Boton("4");
	Boton n5cobrar = new Boton("5");
	Boton n6cobrar = new Boton("6");
	Boton n1cobrar = new Boton("1");
	Boton n2cobrar = new Boton("2");
	Boton n3cobrar = new Boton("3");
	Boton n0cobrar = new Boton("0");
	Boton comacobrar = new Boton(",");
	Boton delcobrar = new Boton("del");
	Boton okcobrar = new Boton("OK");
	Boton esccobrar = new Boton("ESC");	

	// ******** COMPONENTES DE DIALOGO MENSAJES EMERGENTES ********
	Dialog mensajesEmergentes = new Dialog(cobrar,"A Devolver",true);
	Boton mensaje = new Boton("");

	// ******** COMPONENTES DE DIALOGO NUEVO TICKET ********
	Dialog nuevoTicket = new Dialog(this,"Crear Ticket Nuevo",true);
	Boton mesa1 = new Boton("Mesa 1");
	Boton mesa2 = new Boton("Mesa 2");
	Boton mesa3 = new Boton("Mesa 3");
	Boton mesa4 = new Boton("Mesa 4");
	Boton mesa5 = new Boton("Mesa 5");
	Boton mesa6 = new Boton("Mesa 6");
	Boton mesa7 = new Boton("Mesa 7");
	Boton mesa8 = new Boton("Mesa 8");
	Boton mesa9 = new Boton("Mesa 9");
	Boton mesa10 = new Boton("Mesa 10");
	Boton barra = new Boton("Barra");
	Boton llevar = new Boton("Llevar");

	// ******** COMPONENTES DEL DIALOGO TECLADO ********
	Dialog teclado = new Dialog(altas,"teclado",true);
	Boton tecladoDescripcion = new Boton();
	Boton[] tecladoLetras = new Boton[40];
	Boton tecladoCancelar = new Boton("Cancelar");
	Boton tecladoEspacio = new Boton("Espacio");
	Boton tecladoBorrar = new Boton("Borrar");
	Boton tecladoMayus = new Boton("Minus");
	Boton tecladoValidar = new Boton("Validar");
	ArrayList<String> listaTeclas =new ArrayList<String> (Arrays.asList("0","1","2","3","4",
			"5","6","7","8","9","Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G",
			"H","J","K","L","Ñ","Z","X","C","V","B","N","M",",",".","-"));

	// ******** COMPONENTES DEL DIALOGO CAJA ********
	//Reutilizamos el dialogo cobrar
	Boton saldoCaja = new Boton();
	
	// ******** COMPONENTES DEL DIALOGO LOGIN ********
	Dialog login = new Dialog (this,"Seleccione Usuario");
	Label usuarioLabel = new Label("Usuario");
	java.awt.List usuarioList = new java.awt.List(4,false);
	Label passwordLabel = new Label("Contraseña");
	TextField passwordText = new TextField ("",22);
	Boton n1Login = new Boton("1");
	Boton n2Login = new Boton("2");
	Boton n3Login = new Boton("3");
	Boton n4Login = new Boton("4");
	Boton n5Login = new Boton("5");
	Boton n6Login = new Boton("6");
	Boton n7Login = new Boton("7");
	Boton n8Login = new Boton("8");
	Boton n9Login = new Boton("9");
	Boton ConfirmarLogin = new Boton("Confirmar");
		
	//******** POPUPSMENU PARA ENCARGADO Y GERENTE/ADMINISTRADOR ********
	// RESCATAR TICKET (Boton derecho sobre Nuevo ticket)
	PopupMenu rescataTicket = new PopupMenu("Recuperar Ticket");
	List<MenuItem>ticketsdelDia = new ArrayList<MenuItem>();
	
	// MODIFICAR PRECIO Y/O NOMBRE DE ARTICULOS
	PopupMenu modificaArticulo = new PopupMenu("Modificar Articulo");
	MenuItem modificaPrecio = new MenuItem("Modificar Precio");
	MenuItem modificaNombre = new MenuItem("Modificar Nombre");
	MenuItem retirarArticulo = new MenuItem("Retirar Articulo");
	
	// SACAR INFORMES
	PopupMenu imprimeInformes = new PopupMenu("Informes");
	MenuItem imprimeArticulos = new MenuItem("Listado de Precios");
	MenuItem imprimeHuerfanos = new MenuItem("Listado de Articulos Huerfanos");
	MenuItem imprimeCaja = new MenuItem("Listado de Caja");
	MenuItem imprimeMasVendidos = new MenuItem("Articulos más Vendidos");
	
	// ******** VARIABLES GENERALES y JBC ********
	List<Boton> listaActiva = new ArrayList<Boton>(); // Almacena lista de productos de categoria activa
	List<Ticket> listaTicketsAbiertos = new ArrayList<Ticket>(); //Almacena lista de tickets sin cobrar
	Ticket activo;
	DetalleTicket detalleActivo;
	String categoriaActiva="BEBIDAS";
	static Connection conexion=null;
	// static String dsn = new String("jdbc:mysql://localhost/restaurante"); //Conector Nativo JAVA
	static String dsn = new String("jdbc:odbc:ODBCRestaurante"); //Conector JDBC:ODBC
	ResultSet rs=null;
	Statement stmt=null;
	int contBarra;
	int contLlevar;
	Boolean cobrado=false;
	String saldoActual;
	String descripcion="";
	String cantidad="";
	String precio="";
	String importe="";
	DecimalFormat df = new DecimalFormat("0.00");
	String articuloenEdicion;
	String usuario="";
	String password="";
	
	// Tamaños predefinidos
	Dimension botonnumero = new Dimension(75,75);
	Dimension botongrande = new Dimension(130,60);
	Dimension botonmediano = new Dimension(107,60);
	Dimension botonpequeño = new Dimension(100,50);
	Dimension tecladocuadrada = new Dimension(60,60);
	Dimension tecladorectangular = new Dimension(120,60);
	//Colores
	Color Azul = new Color(161, 214, 249);
	Color Verde = new Color(134,248,169);
	Color Rojo = new Color (255,106,95);
	Color Amarillo = new Color (246,189,69);
	Color Morado = new Color (241,193,255);
	Color Papel = new Color (255,255,204);
	//Fuentes
	Font fuenteGrande = new Font("Dialog",Font.BOLD,30);

	// ****************************************************************************	
	// ************************** CONSTRUCTOR DEL FRAME ***************************
	// **************************************************************************** 
	public TPVTwinber() {

		//******** VENTANA PRINCIPAL ********

		//******** PANEL IZQUIERDO ********
		// Panel ticketActivoSuperior
		ticketActivoSuperior.setPreferredSize(new Dimension(400, 55));
		botonUsuario.setPreferredSize(botonpequeño);
		botonUsuario.setBackground(Morado);
		botonUsuario.setFocusable(false);
		ticketActivoSuperior.add(botonUsuario);
		numeroTicket.setPreferredSize(botonpequeño);
		numeroTicket.setFocusable(false);
		ticketActivoSuperior.add(numeroTicket);

		//Panel ticketActivoCentral
		ticketActivoCentral.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
		ticketActivoCentral.setPreferredSize(new Dimension(400, 500));
		ticketActivoCentral.setBackground(Color.WHITE);

		//Panel ticketActivoInferior
		ticketActivoInferior.setPreferredSize(new Dimension(400, 55));
		ticketActivoInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
		botonNuevoTicket.setPreferredSize(botonpequeño);
		botonNuevoTicket.setBackground(Morado);
		botonNuevoTicket.setFocusable(false);
		ticketActivoInferior.add(botonNuevoTicket);
		ticketActivoInferior.add(sumaTicket);

		// Panel ticketActivo
		ticketActivo.setPreferredSize(new Dimension(400, 610));
		ticketActivo.setLayout(new BorderLayout());
		ticketActivo.add("North",ticketActivoSuperior);
		ticketActivo.add("Center", ticketActivoCentral);
		ticketActivo.add("South",ticketActivoInferior);

		//Panel Menus
		menus.setPreferredSize(new Dimension(400,60));
		menus.setLayout(new GridLayout (1,5,3,3));
		menus.add(botonMas);
		botonMas.setBackground(Azul);
		botonMas.setFocusable(false);
		menus.add(botonMenos);
		botonMenos.setBackground(Azul);
		botonMenos.setFocusable(false);
		menus.add(botonCobrar);
		botonCobrar.setBackground(Amarillo);
		botonCobrar.setFocusable(false);
		menus.add(botonCaja);
		botonCaja.setBackground(Verde);
		botonCaja.setFocusable(false);
		menus.add(botonImprimir);
		botonImprimir.setBackground(Rojo);
		botonImprimir.setFocusable(false);
		//Ensamble de panelizquierdo
		panelizquierdo.setPreferredSize(new Dimension(410, 680));
		panelizquierdo.add(ticketActivo);
		panelizquierdo.add(menus);
		panelizquierdo.setBackground(Papel);

		// ******** PANEL DERECHO ********
		// Panel categorias
		categorias.setLayout(new FlowLayout(FlowLayout.LEFT));
		categorias.setPreferredSize(new Dimension(675, 130));
		botonBebidas.setPreferredSize(botongrande);
		botonBebidas.setBackground(Verde);
		botonEnsaldas.setPreferredSize(botongrande);
		botonEnsaldas.setBackground(Verde);
		botonEntrantes.setPreferredSize(botongrande);
		botonEntrantes.setBackground(Verde);
		botonVinos.setPreferredSize(botongrande);
		botonVinos.setBackground(Verde);
		botonCarnes.setPreferredSize(botongrande);
		botonCarnes.setBackground(Verde);
		botonPescados.setPreferredSize(botongrande);
		botonPescados.setBackground(Verde);
		botonPostres.setPreferredSize(botongrande);
		botonPostres.setBackground(Verde);
		botonHelados.setPreferredSize(botongrande);
		botonHelados.setBackground(Verde);
		botonCafes.setPreferredSize(botongrande);
		botonCafes.setBackground(Verde);
		botonMenu.setPreferredSize(botongrande);
		botonMenu.setBackground(Verde);
		categorias.add(botonBebidas);
		categorias.add(botonEnsaldas);
		categorias.add(botonEntrantes);
		categorias.add(botonVinos);
		categorias.add(botonCarnes);
		categorias.add(botonPescados);
		categorias.add(botonPostres);
		categorias.add(botonHelados);
		categorias.add(botonCafes);
		categorias.add(botonMenu);

		//Panel articulos
		articulos.setLayout(new FlowLayout(FlowLayout.LEFT));
		articulos.setPreferredSize(new Dimension(675,330));
		botonNuevoArticulo.setPreferredSize(botonmediano);		
		botonNuevoArticulo.setBackground(Amarillo);
		botonNuevoArticulo.setFocusable(false);
		articulos.add(botonNuevoArticulo);	

		// Panel ticketsAbiertos
		ticketsAbiertos.setLayout(new FlowLayout(FlowLayout.LEFT));
		ticketsAbiertos.setPreferredSize(new Dimension (675,220));

		//Ensamble de panelderecho
		panelderecho.setLayout(new FlowLayout(FlowLayout.LEFT ));
		panelderecho.setPreferredSize(new Dimension(685, 680));
		panelderecho.add(categorias);
		panelderecho.add(articulos);
		panelderecho.add(ticketsAbiertos);
		panelderecho.setBackground(Papel);

		//Añadimos Listeners a VentanaPrincipal
		addWindowListener( new WindowAdapter (){
			public void windowClosing(WindowEvent we){
				try
				{
					conexion.close();
					if (stmt!=null) stmt.close();
					
				}
				catch(SQLException e)
				{
					System.out.println("error al cerrar "+e.toString());
				}
				System.exit(0);
			}
		});
		botonNuevoArticulo.addActionListener(this);
		botonBebidas.addActionListener(this);
		botonEnsaldas.addActionListener(this);
		botonEntrantes.addActionListener(this);
		botonVinos.addActionListener(this);
		botonCarnes.addActionListener(this);
		botonPescados.addActionListener(this);
		botonPostres.addActionListener(this);
		botonHelados.addActionListener(this);
		botonCafes.addActionListener(this);
		botonMenu.addActionListener(this);
		botonUsuario.addActionListener(this);
		botonNuevoTicket.addActionListener(this);
		botonMas.addActionListener(this);
		botonMenos.addActionListener(this);
		botonImprimir.addActionListener(this);
		botonCobrar.addActionListener(this);
		botonCaja.addActionListener(this);

		//***************** Botones con PopupMenu ***************
		//RECUPERAR TICKETS DEL DIA
		ticketActivoInferior.add(rescataTicket);
		botonNuevoTicket.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if (e.isMetaDown() && 
						(usuario.equals("ENCARGADO") || usuario.equals("GERENTE"))){
					rescataTicket.removeAll();
					rellenaListaTicketsdelDia();
					for (MenuItem menu : ticketsdelDia) {
						rescataTicket.add(menu);
						addActionListenerToMenuItemintoaMouseAdapter(menu);
					}
					
					rescataTicket.show(botonNuevoTicket, 10, 10);
					
				}
				
			}
		});
		// INFORMES
		menus.add(imprimeInformes);
		botonImprimir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if (e.isMetaDown() && usuario.equals("GERENTE")){
					imprimeInformes.show(botonImprimir, 10, 10);
				}
			}
		});
		
		
		//TODO LIMPIAR CODIGO MEDIANTE FOREACH COMPONTENES...
		//Ensamble de VentanaPrincipal
		setLayout(new FlowLayout(FlowLayout.CENTER ));
		add (panelizquierdo);
		add (panelderecho);
		setTitle ("Twinber TPV");
		setSize (1120,730);
		setVisible(true);
		setResizable(false);

		 
		// ******** CARGA DE DATOS INICIAL ********
				cargaTicketsNoCobrados();
				rellenaListaActiva(categoriaActiva);
				calculaSaldoActual();
		
		// ******** DIALOGO LOGIN ********
		login.setLayout(new FlowLayout(FlowLayout.CENTER));
		login.setSize(210, 470);
		login.add(usuarioLabel);
		login.add(usuarioList);
		login.add(passwordLabel);
		login.add(passwordText);
		login.add(n1Login);
		login.add(n2Login);
		login.add(n3Login);
		login.add(n4Login);
		login.add(n5Login);
		login.add(n6Login);
		login.add(n7Login);
		login.add(n8Login);
		login.add(n9Login);
		login.add(ConfirmarLogin);
		for (Component boton : login.getComponents()) {
			if(boton.getClass().getName()=="tpv.Boton"){
				((Boton)boton).setBackground(Azul);
				((Boton)boton).addActionListener(this);
				((Boton)boton).setFocusable(false);
				((Boton)boton).setFont(fuenteGrande);
				((Boton)boton).setPreferredSize(tecladocuadrada);
			}
		}
		passwordText.setEditable(false);
		ConfirmarLogin.setBackground(Verde);
		ConfirmarLogin.setPreferredSize(new Dimension (190,60));
		usuarioLabel.setPreferredSize(new Dimension (190,30));
		passwordLabel.setPreferredSize(new Dimension(190,30));
		//Obetenmos nombres de Usuario
		try {
			ResultSet rs = stmt.executeQuery("SELECT nombreUsuario FROM Usuarios");
			while (rs.next()){
				usuarioList.add(rs.getString("nombreUsuario"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		login.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
			
		});
		usuarioList.select(0);
		login.setResizable(false);
		login.setVisible(true);
		
		
		//********  DIALOGO NUEVO ARTICULO ********
		//Ensamble de Dialogo Nuevo Articulo
		altas.setLayout(new GridBagLayout());
		altas.setSize(360,640);
		GridBagConstraints gbcAltas = new GridBagConstraints();
		gbcAltas.fill = GridBagConstraints.BOTH;
		Insets separaciones = new Insets(2,2,2,2);
		gbcAltas.insets = separaciones;
		gbcAltas.gridx = 0;
		gbcAltas.gridy = 0;
		gbcAltas.gridwidth = 4;
		gbcAltas.gridheight = 1;
		altas.add(descripcionLabel, gbcAltas);
		gbcAltas.gridy = 1;
		altas.add(descripcionArticulo,gbcAltas);
		gbcAltas.gridy = 2;
		altas.add(cantidadLabel, gbcAltas);
		gbcAltas.gridy = 3;
		altas.add(cantidadArticulo,gbcAltas);
		gbcAltas.gridy = 4;
		altas.add(precioLabel,gbcAltas);
		gbcAltas.gridy = 5;
		altas.add(precioArticulo,gbcAltas);
		gbcAltas.gridy = 6;
		gbcAltas.gridwidth = 1;
		altas.add(n7altas,gbcAltas);
		gbcAltas.gridx = 1;
		altas.add(n8altas,gbcAltas);
		gbcAltas.gridx = 2;
		altas.add(n9altas,gbcAltas);
		gbcAltas.gridx = 3;
		gbcAltas.gridheight = 2;
		altas.add(okaltas,gbcAltas);
		gbcAltas.gridx = 0;
		gbcAltas.gridy = 7;
		gbcAltas.gridheight = 1;
		altas.add(n4altas , gbcAltas);
		gbcAltas.gridx = 1;
		altas.add(n5altas,gbcAltas);
		gbcAltas.gridx = 2;
		altas.add(n6altas,gbcAltas);
		gbcAltas.gridx = 0;
		gbcAltas.gridy = 8;
		altas.add(n1altas,gbcAltas);
		gbcAltas.gridx = 1;
		altas.add(n2altas,gbcAltas);
		gbcAltas.gridx = 2;
		altas.add(n3altas,gbcAltas);
		gbcAltas.gridx = 3;
		gbcAltas.gridheight = 2;
		altas.add(escaltas,gbcAltas);
		gbcAltas.gridheight = 1;
		gbcAltas.gridx = 0;
		gbcAltas.gridy = 9;
		altas.add(n0altas,gbcAltas);
		gbcAltas.gridx = 1;
		altas.add(comaaltas,gbcAltas);
		gbcAltas.gridx = 2;
		altas.add(delaltas,gbcAltas);
		gbcAltas.gridx = 0;
		gbcAltas.gridwidth = 4;
		gbcAltas.gridy = 10;
		altas.add(nuevoaltas,gbcAltas);
		//Listener del Dialogo Alta Articulo
		altas.addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				altas.setVisible(false);
				cantidad="";
				cantidadArticulo.setText(cantidad);
				precio="";
				precioArticulo.setText(precio);
			}
		});

		// Configuramos Componentes
		for (Component componente : altas.getComponents()) {
			if (componente.getClass().getName().equals("tpv.Boton")){
				((Boton)componente).setBackground(Azul);
				((Boton)componente).setPreferredSize(botonnumero);
				((Boton)componente).setFocusable(false);
				((Boton)componente).addActionListener(this);
				((Boton)componente).setFont(fuenteGrande);
			}
		}
		descripcionArticulo.setFont(this.getFont());
		descripcionArticulo.setPreferredSize(new Dimension(320,30));
		cantidadArticulo.addFocusListener(this);
		precioArticulo.addFocusListener(this);
		okaltas.setBackground(Verde);
		escaltas.setBackground(Rojo);
		nuevoaltas.setBackground(Amarillo);
		nuevoaltas.setPreferredSize(new Dimension ( 320,75));
		cantidadArticulo.setEditable(false);
		precioArticulo.setEditable(false);
		descripcionArticulo.setBackground(Color.white);
		cantidadArticulo.setBackground(Color.white);
		precioArticulo.setBackground(Color.white);

		altas.setVisible(false);		
		altas.setResizable(false);

		// ******** DIALOGO COBRAR ********
		//Ensamble dialogo cobrar
		cobrar.setLayout(new GridBagLayout());
		cobrar.setSize(340,450);
		GridBagConstraints gbcCobrar = new GridBagConstraints();
		gbcCobrar.fill = GridBagConstraints.BOTH;
		Insets separaciones2 = new Insets(2,2,2,2);
		gbcCobrar.insets = separaciones2;
		gbcCobrar.gridx = 0;
		gbcCobrar.gridy = 0;
		gbcCobrar.gridwidth = 4;
		gbcCobrar.gridheight = 1;
		cobrar.add(importeEntregado, gbcCobrar);
		gbcCobrar.gridy = 1;
		gbcCobrar.gridwidth = 1;
		cobrar.add(n7cobrar,gbcCobrar);
		gbcCobrar.gridx = 1;
		cobrar.add(n8cobrar,gbcCobrar);
		gbcCobrar.gridx = 2;
		cobrar.add(n9cobrar,gbcCobrar);
		gbcCobrar.gridx = 3;
		gbcCobrar.gridheight = 2;
		cobrar.add(okcobrar,gbcCobrar);
		gbcCobrar.gridx = 0;
		gbcCobrar.gridy = 2;
		gbcCobrar.gridheight = 1;
		cobrar.add(n4cobrar , gbcCobrar);
		gbcCobrar.gridx = 1;
		cobrar.add(n5cobrar,gbcCobrar);
		gbcCobrar.gridx = 2;
		cobrar.add(n6cobrar,gbcCobrar);
		gbcCobrar.gridx = 0;
		gbcCobrar.gridy = 3;
		cobrar.add(n1cobrar,gbcCobrar);
		gbcCobrar.gridx = 1;
		cobrar.add(n2cobrar,gbcCobrar);
		gbcCobrar.gridx = 2;
		cobrar.add(n3cobrar,gbcCobrar);
		gbcCobrar.gridx = 3;
		gbcCobrar.gridheight = 2;
		cobrar.add(esccobrar,gbcCobrar);
		gbcCobrar.gridheight = 1;
		gbcCobrar.gridx = 0;
		gbcCobrar.gridy = 4;
		cobrar.add(n0cobrar,gbcCobrar);
		gbcCobrar.gridx = 1;
		cobrar.add(comacobrar,gbcCobrar);
		gbcCobrar.gridx = 2;
		cobrar.add(delcobrar,gbcCobrar);
		//Listener del Dialogo Cobrar
		cobrar.addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				okcobrar.setNombre("OK");
				esccobrar.setNombre("ESC");
				importe="";
				importeEntregado.setNombre(importe);	
				cobrar.setVisible(false);
				cobrar.remove(saldoCaja);
				cobrar.setSize(340,450);
				cobrar.setTitle("¿Cuanto nos da el cliente?");
			}
		});

		// Configuramos Componentes
		for (Component componente : cobrar.getComponents()) {
			if (componente.getClass().getName().equals("tpv.Boton")){
				((Boton)componente).setBackground(Azul);
				((Boton)componente).setPreferredSize(botonnumero);
				((Boton)componente).setFocusable(false);
				((Boton)componente).addActionListener(this);
				((Boton)componente).setFont(fuenteGrande);
			}
		}
		importeEntregado.setBackground(Papel);
		importeEntregado.setPreferredSize(new Dimension(330,50));
		importeEntregado.setFont(fuenteGrande);
		okcobrar.setBackground(Verde);
		esccobrar.setBackground(Rojo);
		cobrar.setVisible(false);		
		cobrar.setResizable(false);

		// ******** DIALOGO A DEVOLVER ********
		mensajesEmergentes.setLayout(new GridLayout());
		mensajesEmergentes.add(mensaje);
		mensajesEmergentes.setSize(400,300);
		mensaje.setBackground(Color.white);

		mensaje.setFont(fuenteGrande);
		mensaje.addActionListener(this);
		mensajesEmergentes.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				mensajesEmergentes.setVisible(false);
				cobrar.setVisible(false);
				importe="";
				importeEntregado.setNombre(importe);
			}
		});

		// ******** DIALOGO NUEVO TICKET ********
		nuevoTicket.setLayout(new FlowLayout(FlowLayout.CENTER));
		nuevoTicket.setSize(360,320);

		nuevoTicket.add(mesa1);
		nuevoTicket.add(mesa2);
		nuevoTicket.add(mesa3);
		nuevoTicket.add(mesa4);
		nuevoTicket.add(mesa5);
		nuevoTicket.add(mesa6);
		nuevoTicket.add(mesa7);
		nuevoTicket.add(mesa8);
		nuevoTicket.add(mesa9);
		nuevoTicket.add(mesa10);
		nuevoTicket.add(barra);
		nuevoTicket.add(llevar);

		nuevoTicket.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				nuevoTicket.setVisible(false);
			}
		});
		// Configuramos componentes
		for (Component componente : nuevoTicket.getComponents()) {
			if (componente.getClass().getName().equals("tpv.Boton")){
				((Boton)componente).setBackground(Amarillo);
				((Boton)componente).setPreferredSize(botonmediano);
				((Boton)componente).setFocusable(false);
				((Boton)componente).addActionListener(this);
			}
		}
		nuevoTicket.setVisible(false);
		nuevoTicket.setResizable(false);

		// ******** DIALAGO TECLADO ********
		teclado.setLayout(new FlowLayout());
		teclado.setSize(670,430);
		teclado.add(tecladoDescripcion);
		tecladoDescripcion.setBackground(Color.white);
		tecladoDescripcion.setPreferredSize(new Dimension(650,60));
		tecladoDescripcion.setFont(fuenteGrande);
		for (int i = 0; i < 40 ; i++) {
			tecladoLetras[i] = new Boton(listaTeclas.get(i));
			tecladoLetras[i].setFont(fuenteGrande);
			tecladoLetras[i].setBackground(Azul);
			tecladoLetras[i].setPreferredSize(tecladocuadrada);
			teclado.add(tecladoLetras[i]);
		}
		teclado.add(tecladoCancelar);
		tecladoCancelar.setBackground(Rojo);
		tecladoCancelar.setPreferredSize(tecladorectangular);
		teclado.add(tecladoEspacio);
		tecladoEspacio.setBackground(Amarillo);
		tecladoEspacio.setPreferredSize(new Dimension(265,60));
		teclado.add(tecladoBorrar);
		tecladoBorrar.setBackground(Morado);
		tecladoBorrar.setPreferredSize(tecladocuadrada);
		teclado.add(tecladoMayus);
		tecladoMayus.setBackground(Azul);
		tecladoMayus.setPreferredSize(tecladocuadrada);
		teclado.add(tecladoValidar);
		tecladoValidar.setBackground(Verde);
		tecladoValidar.setPreferredSize(tecladorectangular);
		for (Component boton : teclado.getComponents()) {
			((Boton)boton).addActionListener(this);
			((Boton)boton).setFocusable(false);
		}
		teclado.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				teclado.setVisible(false);
			}
		});
		teclado.setResizable(false);
		teclado.setVisible(false);
		
		// ******** DIALOGO CAJA ********
		cobrar.add(saldoCaja);
		saldoCaja.setNombre(saldoActual);
		saldoCaja.setBackground(Morado);
		saldoCaja.addActionListener(this);
		saldoCaja.setFont(fuenteGrande);
		
		// ******** POPUP MODIFICAARTICULO ********
		modificaArticulo.add(modificaNombre);
		modificaArticulo.add(modificaPrecio);
		modificaArticulo.add(retirarArticulo);
		modificaPrecio.addActionListener(this);
		modificaNombre.addActionListener(this);
		retirarArticulo.addActionListener(this);
		add(modificaArticulo);
		
		// ******** POPUP MODIFICAARTICULO ********
		imprimeInformes.add(imprimeArticulos);
		imprimeInformes.add(imprimeHuerfanos);
		imprimeInformes.add(imprimeCaja);
		imprimeInformes.add(imprimeMasVendidos);
		imprimeArticulos.addActionListener(this);
		imprimeHuerfanos.addActionListener(this);
		imprimeCaja.addActionListener(this);
		imprimeMasVendidos.addActionListener(this);
		
	}

	private void calculaSaldoActual() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT SUM(importeIngreso) FROM Caja");
			rs.next();
			double saldo = rs.getDouble("SUM(importeIngreso)");
			saldoActual = df.format(saldo) + " EUROS";
			saldoCaja.setNombre(saldoActual);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// ****************************************************************************	
	// ******************** METODOS EVENTOS ACTIONPERFORMED ***********************
	// **************************************************************************** 
	public void actionPerformed(ActionEvent ae) {

		// LOGIN
		
		if (ae.getSource().getClass().getName()!="java.awt.MenuItem" && 
				((Component)ae.getSource()).getParent()==login){
			Boton boton = (Boton)ae.getSource();
			if (boton.getNombre().matches("\\d")){
				password += boton.getNombre();
				passwordText.setText(passwordText.getText() + "*");
			}
			if (boton==ConfirmarLogin){
				passwordText.setText("");
				usuario = usuarioList.getSelectedItem();
				try {
					ResultSet rs = stmt.executeQuery("SELECT nombreUsuario,passwordUsuario FROM Usuarios" +
							" WHERE nombreUsuario='" + usuario +"'");
					rs.next();
					if (Integer.parseInt(password)==rs.getInt("passwordUsuario")){
						password = "";
						login.setVisible(false);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NumberFormatException e){
					password = "";
				}
				
			}
		}
		
		// CAMBIAR USUARIO
		if (ae.getSource()==botonUsuario){
			login.setVisible(true);
			
		}
		// EVENTOS POPUPMENU 
		
		if (ae.getSource().getClass().getName().equals("java.awt.MenuItem")){
			// RESCATAR TICKETS DEL DIA
			if (((MenuItem)ae.getSource()).getParent()==rescataTicket){
				String aux = ((MenuItem)ae.getSource()).getLabel();
				int idTicket = Integer.parseInt(aux.substring(10, aux.indexOf("-")-1));
				Boolean existe = false;
				for (Ticket ticket : listaTicketsAbiertos) {
					if (ticket.idTicket==idTicket){
						existe = true;
					}
				}
				if (!existe){
					try {
						ResultSet rs = stmt.executeQuery("SELECT nombreMesa FROM Mesas,Tickets " +
								"WHERE idTicket=" + idTicket + " AND idMesaFK=idMesa ");
						rs.next();
						String nombreTicket = rs.getString("nombreMesa");
						Ticket rescatado = new Ticket(idTicket, nombreTicket, true);
						rescatado.addActionListener(this);
						if (activo!=null){
							activo.setBackground(Color.white);
						}
						activo = rescatado;
						activo.setBackground(Rojo);
						ticketsAbiertos.add(rescatado);
						ticketsAbiertos.revalidate();
						ticketsAbiertos.repaint();
						muestraTicketActivo();
						
						listaTicketsAbiertos.add(rescatado);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				// MODIFICAR ARTICULOS SOLO POSIBLE SI NO HAY TICKETS ABIERTOS
			} else if (((MenuItem)ae.getSource()).getParent()==modificaArticulo && listaTicketsAbiertos.isEmpty()){
				
				if (ae.getSource()==modificaNombre){
					teclado.setVisible(true);
				} else if (ae.getSource()==modificaPrecio) {
					nuevoaltas.setEnabled(false);
					descripcionArticulo.setEnabled(false);
					descripcionArticulo.setNombre(articuloenEdicion);
					altas.setVisible(true);
					precioArticulo.setText("");
					descripcionArticulo.setNombre(" - - - ");
					nuevoaltas.setEnabled(true);
					descripcionArticulo.setEnabled(true);
				} else if (ae.getSource() == retirarArticulo){
					try {
						stmt.executeUpdate("UPDATE Articulos SET categoriaArticulo='RETIRADO' " +
								"WHERE nombreArticulo = '"+ articuloenEdicion + "'");
						rellenaListaActiva(categoriaActiva);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}  
		
		// IMPRIMIR TICKET
		if (ae.getSource()==botonImprimir && activo!=null){
			activo.imprimir();
		}
		// DIALOGO COBRAR/CAJA:
		if (ae.getSource()==botonCobrar && activo!=null && activo.totalTicket()!=0){ 
			cobrar.remove(saldoCaja);
			importeEntregado.setNombre("0");
			cobrar.setSize(340,450);
			cobrar.revalidate();
			cobrar.setVisible(true);
		} 
			
		if (ae.getSource()==okcobrar){
			//COBRAMOS 
			if (okcobrar.getNombre().equals("OK")){
				if(activo!=null && importeEntregado.getNombre()!="."){
					try {
						importe=importeEntregado.getNombre();
						//TODO Borrar todas las referencias anteriores a importe(son inutiles)
						double cambio = Double.parseDouble(importe) - ((double)activo.totalTicket())/100;
						cambio = Math.round(cambio*100);
						if (!activo.cobrado){
							if (cambio<0){
								mensaje.setText("<html><p align=\"center\"> Importe Inferior al Total del Ticket</p><br>" +
										"<p align=\"center\">Pulsar para volver</p></html>");
								cobrado = false;
								mensajesEmergentes.setVisible(true);
							} else {
								mensaje.setText("<html><p align=\"center\">Devuelve</p>" +
										"<p align=\"center\">" + df.format(cambio/100) +" EUROS </p>" +
										"<p align=\"center\">Pulsar para volver</p></html>");
								cobrado = true;
								mensajesEmergentes.setVisible(true);
							}	
						} else {
							cambio = activo.importe - ((double)activo.totalTicket())/100;
							cambio = Math.round(cambio*100);
							if (cambio>0){  // Tenemos que devolverle dinero 
								mensaje.setText("<html><p align=\"center\">Devuelve cambio corregido</p>" +
										"<p align=\"center\">" + df.format(cambio/100) +" EUROS </p>" +
										"<p align=\"center\">Pulsar para volver</p></html>");
								cobrado = true;
								mensajesEmergentes.setVisible(true);
								
							} else if (cambio<0){ //Nos debe pagar dinero
								cambio = -cambio;
								mensaje.setText("<html><p align=\"center\">El cliente debe entregarnos</p>" +
										"<p align=\"center\">" + df.format(cambio/100) +" EUROS </p>" +
										"<p align=\"center\">Pulsar para volver</p></html>");
								cobrado = true;
								mensajesEmergentes.setVisible(true);
								
							} else {
								mensaje.setText("<html><p align=\"center\">No ha habido cambios</p>" +
										"<p align=\"center\">Pulsar para volver</p></html>");
								cobrado = true;
								mensajesEmergentes.setVisible(true);
							}
							
						}
						
					} catch (NumberFormatException e) {e.printStackTrace();}
				}
			}
			//AÑADIMOS SALDO A CAJA
			if (okcobrar.getNombre().equals("+") && importeEntregado.getNombre()!=""){
				try {
					stmt.executeUpdate("INSERT INTO restaurante.Caja (importeIngreso)" +
							" VALUES (" + Double.parseDouble(importe) + ")");
					cobrar.setVisible(false);
					importe="";
					importeEntregado.setNombre(importe);
					calculaSaldoActual();
				} 
				catch (NumberFormatException e) {}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}  
		// ¿COMPLETAMOS COBRO?
		if (ae.getSource()==mensaje){
			if (cobrado){
				mensajesEmergentes.setVisible(false);
				cobrar.setVisible(false);
				importe="";
				importeEntregado.setNombre(importe);
				activo.cobrado();
				listaTicketsAbiertos.remove(activo);
				ticketsAbiertos.remove(activo);
				ticketsAbiertos.revalidate();
				ticketsAbiertos.repaint();
				activo = null;
				detalleActivo = null;
				calculaSaldoActual();
				muestraTicketActivo();
								
			} else {
				mensajesEmergentes.setVisible(false);
				importe="";
				importeEntregado.setNombre(importe);
			}
		}
		// RETIRAMOS DINERO DE CAJA ( INGRESO NEGATIVO)
		if (ae.getSource().getClass().getName()!="java.awt.MenuItem" && 
				((Boton)ae.getSource()).getNombre().equals("-") && importeEntregado.getNombre()!=""){
			System.out.println();
			try {
				stmt.executeUpdate("INSERT INTO restaurante.Caja (importeIngreso)" +
						" VALUES (" + -(Double.parseDouble(importe)) + ")");
				cobrar.setVisible(false);
				importe="";
				importeEntregado.setNombre(importe);
				calculaSaldoActual();
				
			} 
			catch (NumberFormatException e) {e.printStackTrace();}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//ABRIR DIALOGO NUEVO TICKET
		if (ae.getSource()==botonNuevoTicket ){
			if (activo==null) {
				nuevoTicket.setVisible(true);
			} else if (activo!=null && !activo.cobrado){
				nuevoTicket.setVisible(true);
			} else {}
							
		}

		// AÑADIR TICKECT NUEVO MESAS (SOLO UN TICKET POR MESA PUEDE ESTAR ACTIVO)
		if (ae.getSource().getClass().getName()!="java.awt.MenuItem"
				&& ((Boton)ae.getSource()).getNombre().matches("Mesa \\d*")){
			Boton boton = (Boton)ae.getSource();
			boolean existe = false;
			for (Component abiertos : ticketsAbiertos.getComponents()) {
				if (((Boton)abiertos).getNombre().equals(boton.getNombre())){
					existe = true;
				}
			}
			if (!existe){
				listaTicketsAbiertos.add(new Ticket(boton.getNombre(), stmt));
				Ticket ultimoTicket = listaTicketsAbiertos.get(listaTicketsAbiertos.size()-1);
				ticketsAbiertos.add(ultimoTicket);
				ultimoTicket.addActionListener(this);
				if (activo!=null){
					activo.setBackground(Color.white);
				}
				activo=ultimoTicket;
				activo.setBackground(Rojo);
				if(detalleActivo!=null){
					detalleActivo.setBackground(Color.white);
				}
				detalleActivo=null;
				muestraTicketActivo();
				ticketsAbiertos.revalidate();
				ticketsAbiertos.repaint();
				nuevoTicket.setVisible(false);
			}
		}

		// AÑADIR TICKECTS BARRA
		if (ae.getSource()==barra){  
			contBarra++;
			listaTicketsAbiertos.add(new Ticket("Barra "+contBarra, stmt));
			Ticket ultimoTicket = listaTicketsAbiertos.get(listaTicketsAbiertos.size()-1);
			ticketsAbiertos.add(ultimoTicket);
			ultimoTicket.addActionListener(this);
			if (activo!=null){
				activo.setBackground(Color.white);
			}
			activo=ultimoTicket;
			activo.setBackground(Rojo);
			if (detalleActivo!=null){
				detalleActivo.setBackground(Color.white);
			}
			detalleActivo=null;
			muestraTicketActivo();
			ticketsAbiertos.revalidate();
			ticketsAbiertos.repaint();
			nuevoTicket.setVisible(false);

		}

		// AÑADIR TICKECTS LLEVAR
		if (ae.getSource()==llevar){
			contLlevar++;
			listaTicketsAbiertos.add(new Ticket("Llevar "+contLlevar, stmt));
			Ticket ultimoTicket = listaTicketsAbiertos.get(listaTicketsAbiertos.size()-1);
			ticketsAbiertos.add(ultimoTicket);
			ultimoTicket.addActionListener(this);
			if (activo!=null){
				activo.setBackground(Color.white);
			}
			activo=ultimoTicket;
			activo.setBackground(Rojo);
			detalleActivo=null;
			muestraTicketActivo();
			ticketsAbiertos.revalidate();
			ticketsAbiertos.repaint();
			nuevoTicket.setVisible(false);
		} 

		// AÑADIR DETALLE A TICKET
		if (listaActiva.contains(ae.getSource())){
			if(activo!=null){
				String nombre = ((Boton)ae.getSource()).getNombre();
				activo.añadeDetalle(nombre, stmt);
				if (detalleActivo!=null){
					detalleActivo.setBackground(Color.white);
				}
				for (DetalleTicket detalle : activo.listaDetalle) {
					if (detalle.getNombre().equals(nombre)){
						detalle.setBackground(Azul);
						detalleActivo = detalle;
					}
				}
				muestraTicketActivo();
			}
		}
		// CAMBIAR LINEA DE DETALLE SELECCIONADA
		if (activo!=null && activo.listaDetalle.contains(ae.getSource())){
			if ( detalleActivo!=null){
				detalleActivo.setBackground(Color.white);
			}
			((DetalleTicket)ae.getSource()).setBackground(Azul);
			detalleActivo = (DetalleTicket)ae.getSource();

		} 
		//AÑADIR CANTIDAD A DETALLE SELECCIONADO
		if (ae.getSource()==botonMas){
			if(detalleActivo!=null){
				detalleActivo.cantidadmas();
				muestraTicketActivo();
			}
		} 

		// QUITAR CANTIDAD A DETALLE TICKET
		if (ae.getSource()==botonMenos){

			if (detalleActivo!=null){
				if(detalleActivo.cantidadmenos()){
					activo.listaDetalle.remove(detalleActivo);
					if (activo.listaDetalle .isEmpty() && !activo.cobrado){
						
						listaTicketsAbiertos.remove(activo);
						ticketsAbiertos.remove(activo);
						ticketsAbiertos.revalidate();
						ticketsAbiertos.repaint();

						//Eliminamos ticket de Base de Datos
						try {
							stmt.executeUpdate("DELETE FROM restaurante.Tickets" +
									" WHERE idTicket="+ activo.idTicket);
						} catch (SQLException e) {
							System.out.println("Error SQL" + e.toString());
						}
						activo = null;
					} else if(activo.listaDetalle.isEmpty() && activo.cobrado){
						listaTicketsAbiertos.remove(activo);
						ticketsAbiertos.remove(activo);
						ticketsAbiertos.revalidate();
						ticketsAbiertos.repaint();
						rellenaListaTicketsdelDia();
						calculaSaldoActual();
						//Eliminamos ticket e ingreso de Caja Base de Datos
						try {
							stmt.executeUpdate("DELETE FROM Caja" +
									" WHERE idTicketCobradoFK="+ activo.idTicket);
							stmt.executeUpdate("DELETE FROM restaurante.Tickets" +
									" WHERE idTicket="+ activo.idTicket);
						} catch (SQLException e) {
							System.out.println("Error SQL" + e.toString());
						}
						activo = null;

					} else {
						detalleActivo = activo.listaDetalle.get(0);
						detalleActivo.setBackground(Azul);
					}
				}
			}
			muestraTicketActivo();
		} 

		// SELECCIONAR TICKET , MARCA TICKET ACTIVO Y MUESTRA SUS LINEAS DE DETALLE
		if (listaTicketsAbiertos.contains(ae.getSource())){
			if (activo!=null && !activo.cobrado){
				activo.setBackground(Color.white);
				activo = (Ticket)ae.getSource();
				activo.setBackground(Rojo);
				muestraTicketActivo();	
			} else if (activo==null){
				activo = (Ticket)ae.getSource();
				activo.setBackground(Rojo);
				muestraTicketActivo();
			}
						
		} 

		// CAMBIA LISTA DE PRODUCTOS SEGUN CATEGORIA SELECCIONADA
		if (ae.getSource().getClass().getName()!="java.awt.MenuItem" &&
				((Component)ae.getSource()).getParent()==categorias){ 
			categoriaActiva=((Boton)ae.getSource()).getNombre();
			rellenaListaActiva(categoriaActiva);
		} 

		// **** EVENTOS BOTONES NUMERICOS ****
		if (ae.getSource().getClass().getName()!="java.awt.MenuItem" &&
				((Boton)ae.getSource()).getNombre().matches("\\d")){
			if (cantidadArticulo.hasFocus()){
				cantidad +=((Boton)ae.getSource()).getNombre();
				cantidadArticulo.setText(cantidad);

			} else if (precioArticulo.hasFocus()){
				precio +=((Boton)ae.getSource()).getNombre();
				precioArticulo.setText(precio);

			} else if (cobrar.isVisible()){
				importe +=((Boton)ae.getSource()).getNombre();
				importeEntregado.setNombre(importe);
			}
		} 
			
		// **** EVENTOS BOTON "," ****
		if (ae.getSource().getClass().getName()!="java.awt.MenuItem" && 
				((Boton)ae.getSource()).getNombre().equals(",")){
			if (cantidadArticulo.hasFocus() && cantidad.indexOf('.')<0){
				cantidad += ".";
				cantidadArticulo.setText(cantidad);

			} else if (precioArticulo.hasFocus() && precio.indexOf('.')<0){
				precio += ".";
				precioArticulo.setText(precio);

			} else if (cobrar.isVisible()){
				if (importe.indexOf('.')<0){
					importe += "."; 
					importeEntregado.setNombre(importe);
				}

			}
		} 
		// **** EVENTOS BOTON "del" ****
		if (ae.getSource().getClass().getName()!="java.awt.MenuItem" && 
				((Boton)ae.getSource()).getNombre().equals("del")){
			if (cantidadArticulo.hasFocus() && cantidad!=""){
				cantidad = cantidad.substring(0, cantidad.length()-1);
				cantidadArticulo.setText(cantidad);
			} else if (precioArticulo.hasFocus() && precio!=""){
				precio = precio.substring(0, precio.length()-1);
				precioArticulo.setText(precio);

			} else if (cobrar.isVisible()){
				if (importe!=""){
					importe = importe.substring(0, importe.length()-1); 
					importeEntregado.setNombre(importe);
				}

			}
		} 
			
		// **** EVENTOS BOTON "ESC" ****
		if (ae.getSource().getClass().getName()!="java.awt.MenuItem" && 
				((Boton)ae.getSource()).getNombre().equals("ESC")){
			if (altas.isVisible()){
				altas.setVisible(false);
				cantidad="";
				cantidadArticulo.setText(cantidad);
				precio="";
				precioArticulo.setText(precio);
			} else if (cobrar.isVisible()){
				cobrar.setVisible(false);
				importe="";
				importeEntregado.setNombre(importe);
			}
		} 

		// ABRIR DIALOGO ALTAS
		if (ae.getSource()==botonNuevoArticulo && 
				(usuario.equals("ENCARGADO") || usuario.equals("GERENTE"))){ 
			altas.setTitle("Artículo no registrado " + categoriaActiva); 
			if (usuario.equals("ENCARGADO")){
				nuevoaltas.setEnabled(false);
			}
			altas.setVisible(true);
			nuevoaltas.setEnabled(true);
		} 

		// ABRIR TECLADO DESDE DIALOGO ALTAS
		if (ae.getSource()==descripcionArticulo){
			descripcion="";
			teclado.setVisible(true);
		}

		// BOTONES DE DIALOGO TECLADO
		if (ae.getSource().getClass().getName()!="java.awt.MenuItem" && 
				((Boton)ae.getSource()).getParent()==teclado ){
			String nombreTecla = ((Boton)ae.getSource()).getNombre();
			String nombreTeclaup = nombreTecla.toUpperCase();

			if (listaTeclas.contains(nombreTeclaup)){
				descripcion += nombreTecla;
				tecladoDescripcion.setNombre(descripcion);
			}
			if (nombreTecla.equals("Cancelar")){
				descripcion = "";
				teclado.setVisible(false);
			}
			if (nombreTecla.equals("Espacio")){
				descripcion += " ";
				tecladoDescripcion.setNombre(descripcion);
			}
			if (nombreTecla.equals("Borrar")){
				descripcion = descripcion.substring(0, descripcion.length()-1);
				tecladoDescripcion.setNombre(descripcion);
			}
			if (nombreTecla.equals("Minus")){
				tecladoMayus.setNombre("Mayus");
				for ( int i = 0; i < 40; i++){
					tecladoLetras[i].setNombre(listaTeclas.get(i).toLowerCase());
				}
			}
			if (nombreTecla.equals("Mayus")){
				tecladoMayus.setNombre("Minus");
				for ( int i = 0; i < 40; i++){
					tecladoLetras[i].setNombre(listaTeclas.get(i).toUpperCase());
				}
			}
			if (nombreTecla.equals("Validar") && altas.isVisible()){
				descripcionArticulo.setNombre(descripcion);
				teclado.setVisible(false);
			} 
			if (nombreTecla.equals("Validar") && !altas.isVisible()){ // Si altas no es visible es que el teclado lo abrio ModificarNombre

				try {
					stmt.executeUpdate("UPDATE Articulos SET nombreArticulo='" + descripcion + "'" +
							" WHERE nombreArticulo='" + articuloenEdicion + "'");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				teclado.setVisible(false);
				rellenaListaActiva(categoriaActiva);

			}

		} 
		// AÑADIR NUEVO ARTICULO A BASE DE DATOS
		if (ae.getSource()==nuevoaltas){
			String nombreArticulo = descripcionArticulo.getNombre();
			if (nombreArticulo!="" && precio!=""){
				try {
					if (!CompruebaSiExiste(nombreArticulo)){
						stmt.executeUpdate("INSERT restaurante.Articulos (categoriaArticulo,nombreArticulo,precioArticulo) " +
								"VALUES ('" + categoriaActiva + "','" + nombreArticulo + "'," + Double.parseDouble(precio)+ ")");
						altas.setVisible(false);
						cantidad="";
						cantidadArticulo.setText(cantidad);
						precio="";
						precioArticulo.setText(precio);
						descripcionArticulo.setText("");
						rellenaListaActiva(categoriaActiva);
					} else {
						mensaje.setText("Ya existe el articulo " + nombreArticulo);
						mensajesEmergentes.setVisible(true);
					}
				} catch (Exception e) {
					System.out.println("Error SQL" + e.toString());
				}
			}
		} 
			
		// AÑADIR ARTICULO HUERFANO
		if (ae.getSource()==okaltas  && 
				(usuario.equals("ENCARGADO") || usuario.equals("GERENTE"))){
			String nombreArticulo = descripcionArticulo.getNombre();
			if (nombreArticulo!="" && precio!="" && activo!=null){
				try {

					//Insertamos Articulo Huerfano en base de datos
					stmt.executeUpdate("INSERT restaurante.Articulos (categoriaArticulo,nombreArticulo,precioArticulo) " +
							"VALUES ('" + categoriaActiva +"HUERFANO','" + nombreArticulo + "'," + Double.parseDouble(precio)+ ")");
					altas.setVisible(false);
					cantidad="";
					cantidadArticulo.setText(cantidad);
					precio="";
					precioArticulo.setText(precio);
					descripcionArticulo.setText("");
					// Añadimos detalle a ticket activo
					activo.añadeDetalle(nombreArticulo, stmt);
					if (detalleActivo!=null){
						detalleActivo.setBackground(Color.white);
					}
					for (DetalleTicket detalle : activo.listaDetalle) {
						if (detalle.getNombre().equals(nombreArticulo)){
							detalle.setBackground(Azul);
							detalleActivo = detalle;
						}
					}
					muestraTicketActivo();
				} catch (Exception e) {
					System.out.println("Error SQL" + e.toString());
				}
			}
		} 
		// MODIFICA PRECIO DE ARTICULO
		if (ae.getSource()== okaltas && !descripcionArticulo.isEnabled()){
			if (precio!="" && precio!="."){
				try {
					stmt.executeUpdate("UPDATE Articulos SET precioArticulo=" + Double.parseDouble(precio) + 
							" WHERE nombreArticulo='" +articuloenEdicion + "'");
					altas.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// MUESTRA CAJA
		if (ae.getSource()==botonCaja && 
				(usuario.equals("ENCARGADO") || usuario.equals("GERENTE"))){
			calculaSaldoActual();
			okcobrar.setNombre("+");
			esccobrar.setNombre("-");
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			Insets separaciones = new Insets(2,2,2,2);
			gbc.insets = separaciones;
			gbc.gridy=5;
			gbc.gridx=0;
			gbc.gridwidth=GridBagConstraints.REMAINDER;
			cobrar.add(saldoCaja,gbc);
			cobrar.setSize(340,500);
			cobrar.setTitle("SALDO EN CAJA");
			cobrar.revalidate();
			cobrar.setVisible(true);
		}
		// INFORMES
		// LISTADO DE PRECIOS
		if (ae.getSource()==imprimeArticulos){
			try {
				ResultSet rs = stmt.executeQuery("SELECT categoriaArticulo,nombreArticulo,precioArticulo " +
						"FROM Articulos WHERE categoriaArticulo NOT LIKE '%HUERFANO' ORDER BY categoriaArticulo");
				new CrearPdf("listadoArticulos.pdf", rs ,"articulos","");
			} catch (SQLException | IOException | DocumentException e) {
				e.printStackTrace();
			}
		}
		// LISTADO DE HUERFANOS
		if (ae.getSource()==imprimeHuerfanos){
			try {
				ResultSet rs = stmt.executeQuery("SELECT categoriaArticulo,nombreArticulo,precioArticulo " +
						"FROM Articulos WHERE categoriaArticulo LIKE '%HUERFANO' ORDER BY categoriaArticulo");
				new CrearPdf("listadoHuerfanos.pdf", rs ,"huerfanos","");
			} catch (SQLException | IOException | DocumentException e) {
				e.printStackTrace();
			}
		}
		// LISTADO DE CAJA
		if (ae.getSource()==imprimeCaja){
			try {
				ResultSet rsaux = stmt.executeQuery("SELECT SUM(importeIngreso) FROM Caja");
				rsaux.next();
				Double Saldo = rsaux.getDouble("SUM(importeIngreso)");
				ResultSet rs = stmt.executeQuery("SELECT idMovimiento,idTicketCobradoFK,importeIngreso" +
						" FROM Caja");
								
				new CrearPdf("listadoCaja.pdf", rs ,"caja", Saldo.toString());
			} catch (SQLException | IOException | DocumentException e) {
				e.printStackTrace();
			}
		}
		// LISTADO DE MAS VENDIDODS
		if (ae.getSource()==imprimeMasVendidos){
			try {
				ResultSet rs =  stmt.executeQuery("SELECT nombreArticulo,COUNT(*) as total FROM Articulos,detalleTicket " +
						"WHERE idArticulo=idArticuloFK GROUP BY nombreArticulo ORDER BY total DESC;");
				new CrearPdf("listadoMasVendidos.pdf" , rs , "masVendidos" , "");
			} catch (SQLException | IOException | DocumentException e) {
				e.printStackTrace();
			}
		}
	}

	// ******************** METODOS EVENTOS FOCUSGAINED ***********************
	public void focusGained(FocusEvent fe) {
		if (fe.getSource()==cantidadArticulo){
			cantidadArticulo.setBackground(Papel);
		}
		if (fe.getSource()==precioArticulo){
			precioArticulo.setBackground(Papel);
		}
	}

	// ******************** METODOS EVENTOS FOCUSLOST ***********************
	public void focusLost(FocusEvent fe) {
		if (fe.getSource()==descripcionArticulo){
			descripcionArticulo.setBackground(Color.white);
		}
		if (fe.getSource()==cantidadArticulo){
			cantidadArticulo.setBackground(Color.white);
		}
		if (fe.getSource()==precioArticulo){
			precioArticulo.setBackground(Color.white);
		}
	}
	
	private void muestraTicketActivo() {

		// Borramos botones del Panel
		ticketActivoCentral.removeAll();

		if (activo!=null){
			// Añadimos botones del ticket activo
			for (DetalleTicket detalle : activo.listaDetalle){
				ticketActivoCentral.add(detalle);
			}
			numeroTicket.setText("Ticket nº " + activo.idTicket);
			Double totalTicket = (double)activo.totalTicket()/100;

			sumaTicket.setText("Total... " + df.format(totalTicket) + " Euros.");
			// Damos formato a los botones
			for (DetalleTicket detalle: activo.listaDetalle){
				detalle.addActionListener(this);
			}
		} else {
			numeroTicket.setText("Ticket nº 000000");
			sumaTicket.setText("0,00");
		}
		ticketActivoCentral.revalidate();
		ticketActivoCentral.repaint();
		ticketActivoInferior.revalidate();
		ticketActivoInferior.repaint();
	}

	// *** MOSTRAR ARTICULOS DE CATEGORIA ACTIVA ***
		public void rellenaListaActiva(String nombreCategoria) {

			// Borramos botones de Panel Articulos Menos nuevo
			for (Component  boton: articulos.getComponents()) {
				if (listaActiva .contains(boton)){
					articulos.remove(boton);
				}
			}
			listaActiva.clear();

			try {
				ResultSet rs = stmt.executeQuery("SELECT nombreArticulo FROM Articulos WHERE categoriaArticulo='"+nombreCategoria+"'");
				while(rs.next()){
					listaActiva.add(new Boton(rs.getString("nombreArticulo")));
				}
			} catch (Exception e) {
				System.out.println("Error SQL" + e.toString());
			}

			for (Boton boton : listaActiva) {
				boton.setBackground(Azul);
				boton.setPreferredSize(botonmediano);
				boton.addActionListener(this);
				boton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e){
						if (e.isMetaDown() && usuario.equals("GERENTE")){
							modificaArticulo.show((Boton)e.getSource(), 60, 30);
							articuloenEdicion = ((Boton)e.getSource()).getNombre();
							tecladoDescripcion.setNombre(articuloenEdicion);
							descripcion = articuloenEdicion;
						}
						
					}
				});
				boton.setFocusable(false);
				articulos.add(boton);			
			}
			articulos.revalidate();
			articulos.repaint();
		}
	private void cargaTicketsNoCobrados() {
		try	{
			// INICIALIZAMOS LA CONEXION POR PRIMERA VEZ
			// Class.forName("com.mysql.jdbc.Driver"); //Conector nativo Java
			// conexion = DriverManager.getConnection(dsn, "admin", "a2b3C4");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //Conector ODBC:JDBC
			conexion = DriverManager.getConnection(dsn);
			stmt= conexion.createStatement();
			//Borramos Tickets sin detalles
			stmt.executeUpdate("DELETE FROM Tickets " +
					"WHERE idTicket NOT IN (SELECT DISTINCT idTicketFK FROM DetalleTicket)");
			//Seleccionamos tickets no cobrados
			ResultSet rs = stmt.executeQuery("SELECT idTicket,nombreMesa " +
					"FROM restaurante.Tickets,restaurante.Mesas " +
					"WHERE cobrado=FALSE AND idMesaFK=idMesa");
			while (rs.next()){
				int idTicket = rs.getInt("idTicket");
				String nombreTicket = rs.getString("nombreMesa");
				if (nombreTicket.equals("Barra")){
					contBarra++;
					nombreTicket = "Barra " + contBarra;
				}
				if (nombreTicket.equals("Llevar")){
					contLlevar++;
					nombreTicket = "Llevar " + contLlevar;
				}
				//TODO MEJORA: Hacer que se guarde en Base de Datos el contador Barra y Llevar
				// Para que cuando se vaya la luz, los tickets se llamen igual que estaban
				listaTicketsAbiertos.add(new Ticket(idTicket, nombreTicket));
			}
			for (Ticket ticket : listaTicketsAbiertos) {
				ticket.addActionListener(this);
				ticketsAbiertos.add(ticket);
			}
			ticketsAbiertos.revalidate();
			ticketsAbiertos.repaint();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean CompruebaSiExiste(String nombre){
		try {
			ResultSet rs = stmt.executeQuery("SELECT nombreArticulo FROM restaurante.Articulos " +
					"WHERE nombreArticulo='" + nombre + "' AND INSTR (categoriaArticulo,'HUERFANO')=0");
			while (rs.next()){
				if (rs.getString("nombreArticulo").equalsIgnoreCase(nombre)){
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			System.out.println("ERROR EN BASE DE DATOS" + e.toString());	
			return false; //Por si las moscas
		}
	}
	
	public void rellenaListaTicketsdelDia(){
		ticketsdelDia.clear();
		try {
			ResultSet rs = stmt.executeQuery("SELECT idTicket,nombreMesa,DAY(fecha) as 'Dia',importeIngreso FROM Tickets,Mesas,Caja" +
					" WHERE idTicket=idTicketCobradoFK AND idMesaFK=idMesa AND DATE(fecha)=DATE(NOW())" +
					"ORDER BY fecha");
			while (rs.next()){
				ticketsdelDia.add(new MenuItem("Ticket Nº " + rs.getInt("idTicket") + " - " + 
						rs.getString("nombreMesa") + " (" + rs.getDouble("importeIngreso") + ") - Día: " + rs.getString("Dia")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addActionListenerToMenuItemintoaMouseAdapter(MenuItem menu){
		menu.addActionListener(this);
	}
	
	// ******************** MAIN ***********************
	public static void main(String[] args) {
		new TPVTwinber();
	}


}
