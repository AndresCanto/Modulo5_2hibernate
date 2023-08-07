package juguete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Juguete;
import beans.Proveedor;

public class ModeloJuguete 
{
	Connection con;
	List<Juguete> toyList;
	List<Proveedor> supplierList;
	private void conectConn() 
	{
		String server = "jdbc:mysql://localhost/jugueteriajc";
		String user = "andres";
		String password = "qwerty123456";
		
		try {
			con = DriverManager.getConnection(server,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con==null)
		{
			System.out.println("Erro en la conexion!!");
		}
	}
	
	//imprime los datos de cada juguete de la lista
	public void showToys()
	{
		readToys();		
		System.out.println("\nId_Toy\tNom\tPre\tMarc\tCat\tStock\tId_Prov");
		for (Juguete jug : toyList) 
		{
			System.out.println(jug.toString());
		}
	}
	
	//lee registros bd y los guarda en una lista
	private void readToys() 
	{
		conectConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT * FROM juguetes;";
		
		toyList = new ArrayList<>();
		try 
		{
			pstm = con.prepareStatement(query);
			rs=pstm.executeQuery();
			
			while(rs.next())
			{
				toyList.add(new Juguete(
						rs.getInt("id_jug"),
						rs.getString("nom_jug"),
						rs.getDouble("pre_jug"),
						rs.getString("marc_jug"),
						rs.getInt("cat_jug"),
						rs.getInt("stock_jug"),
						rs.getInt("prov_jug")
						));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		closeConn();
	}
	
	private void closeConn() 
	{
		try {
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

