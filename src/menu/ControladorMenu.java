package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import juguete.LanzadorJuguete;
import proveedor.LanzadorProveedor;

public class ControladorMenu implements ActionListener
{
	VistaMenu visM;
	ModeloMenu modM;
	public ControladorMenu(VistaMenu visM, ModeloMenu modM) 
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
		visM.btnJuguetes.addActionListener(this);
		visM.btnProveedores.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==visM.btnJuguetes)
		{
			System.out.println("great");
			LanzadorJuguete l = new LanzadorJuguete();
			l.LlamarJuguete();
//			visM.ocultarGUI();
		}
		
		if(e.getSource()==visM.btnProveedores)
		{
			System.out.println("great");
			LanzadorProveedor l = new LanzadorProveedor();
			l.LlamarProveedor();
			visM.ocultarGUI();			
		}
	}
}
