package proveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import juguete.LanzadorJuguete;

public class ControladorProveedor implements ActionListener
{
	VistaProveedor visM;
	ModeloProveedor modM;
	public ControladorProveedor(VistaProveedor visM, ModeloProveedor modM) 
	{
		this.visM = visM;
		this.modM = modM;
		ejecutar();
	}
	
	private void ejecutar() 
	{
		visM.lanzarGUI();
		while(!visM.termino)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		visM.btnMostrarProveedores.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==visM.btnMostrarProveedores)
		{
			System.out.println("great");
			LanzadorJuguete l = new LanzadorJuguete();
			l.LlamarJuguete();
			visM.dispose();
			
		}
	}
}
