package proveedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Proveedor;

public class ModeloProveedor
{
	Connection con;
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
	
	//imprime los datos de cada proveedor de la lista
	public void showSuppliers() 
	{
		readSuppliers();
		System.out.println("\nId_Prov\tNom\tTel\tMail");
		for (Proveedor prov : supplierList) 
		{
			System.out.println(prov.toString());
		}
	}
	
	//lee registros bd y los guarda en una lista
	private void readSuppliers() 
	{
		conectConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT * FROM proveedores;";
		
		supplierList = new ArrayList<>();
		try 
		{
			pstm = con.prepareStatement(query);
			rs=pstm.executeQuery();
			
			while(rs.next())
			{
				supplierList.add(new Proveedor(
						rs.getInt("id_prov"),
						rs.getString("nom_prov"),
						rs.getString("tel_prov"),
						rs.getString("mail_prov")
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
