package jtable_jugueteriaHibernate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorJuguete implements ActionListener 
{
	ModeloJuguete mod;
	VistaJuguete vis;
	public ControladorJuguete(ModeloJuguete mod, VistaJuguete vis) 
	{
		this.mod = mod;
		this.vis = vis;
		ejecutar();
	}
	
	private void ejecutar() 
	{
		vis.lanzarGUI();
		while(!vis.termino)
		{
			System.out.println("cargando.. ");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		vis.btnMostrarAlumnos.addActionListener(this);
		vis.btnMostrarTablaProveedores.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
