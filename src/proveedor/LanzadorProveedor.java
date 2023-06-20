package proveedor;

public class LanzadorProveedor 
{
	public void LlamarProveedor()
	{
		ModeloProveedor mod = new ModeloProveedor();
		VistaProveedor vis = new VistaProveedor();
		ControladorProveedor cont =  new ControladorProveedor(vis,mod);
	}	
}
