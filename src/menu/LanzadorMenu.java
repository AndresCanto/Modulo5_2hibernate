package menu;

public class LanzadorMenu 
{
	public static void main(String[] args) 
	{
		VistaMenu visM = new VistaMenu();
		ModeloMenu modM = new ModeloMenu();
		ControladorMenu con = new ControladorMenu(visM, modM);
	}
}
