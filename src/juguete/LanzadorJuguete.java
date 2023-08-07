package juguete;

public class LanzadorJuguete 
{
	public void LlamarJuguete()
	{
		ModeloJuguete mod = new ModeloJuguete();
		VistaJuguete vis = new VistaJuguete();
		ControladorJuguete cont =  new ControladorJuguete(mod,vis);
	}	
}
