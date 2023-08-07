package menu;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;

public class VistaMenu extends JFrame 
{
	boolean termino = false;
	private JPanel contentPane;

	JButton btnJuguetes;
	JButton btnProveedores;

	public void lanzarGUI() 
	{
		try {
		    UIManager.setLookAndFeel( new FlatDarkLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		crearGUI();
		setLocationRelativeTo(null);
		setVisible(true);
		termino = true;
	}
	public void ocultarGUI() {
		setVisible(false);
	}
	public void mostrarGUI() {
		setVisible(true);
	}

	public void crearGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Jugueteria Con Hibernate");
//		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBounds(450,250,300,300);
		contentPane.add(panel);
		panel.setLayout(null);
		 
		JLabel nombre = new JLabel("Jugueteria JC");
		nombre.setBounds(650, 100, 300, 200);
		contentPane.add(nombre);
		
		btnJuguetes = new JButton("Juguetes");
		btnJuguetes.setBounds(170, 100, 130, 40);
		panel.add(btnJuguetes);
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setBounds(170, 150, 130, 40);
		panel.add(btnProveedores);
	}

	
}
