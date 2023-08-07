package juguete;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarkLaf;

//import com.formdev.flatlaf.FlatDarkLaf;

public class VistaJuguete extends JFrame 
{
	private JPanel contentPane;
	JTable tabla;
	JButton btnMostrarAlumnos;
	JButton btnMostrarTablaProveedores;
	boolean termino = false;
	
//	public static void main(String[] args) 
//	{
//		Vista v = new Vista();
//		v.lanzarGUI();
//	}

	public void lanzarGUI() 
	{
		try {
		    UIManager.setLookAndFeel( new FlatDarkLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		crearGUI();
		setVisible(true);
		setLocationRelativeTo(null);
		termino = true;
	}
	
	public void ocultarGUI() {
		setVisible(false);
	}
	public void mostrarGUI() {
		setVisible(true);
	}
	
	private void crearGUI() 
	{	
		setResizable(false);
		setTitle("Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnMostrarAlumnos = new JButton("Mostrar Alumnos");
		btnMostrarAlumnos.setBounds(218, 251, 125, 33);
		contentPane.add(btnMostrarAlumnos);
		
		btnMostrarTablaProveedores = new JButton("Mostrar Tabla Proveedores");
		btnMostrarTablaProveedores.setBounds(450, 251, 200, 33);
		contentPane.add(btnMostrarTablaProveedores);
		
		Object[][] datos = {
				{"","","",""},
		};
		String[] Encabezados = {"Matricula","Nombre","Diagnostico","Modulo"};
		DefaultTableModel modelo = new DefaultTableModel(datos, Encabezados);
		tabla = new JTable(modelo);
		JScrollPane scrollpane = new JScrollPane(tabla);
		scrollpane.setBounds(56, 34, 450, 192);
		contentPane.add(scrollpane);
	}
}
