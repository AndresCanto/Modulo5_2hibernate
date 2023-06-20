package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //Entidad = Tabla
@Table(name="juguetes") // nombre de la tabla en la bd
public class Juguete
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) // PK AI
	int id_jug; //PK/ 122
	
	String nom_jug; // Carro Batman Lego
	double pre_jug; // 200.00
	String marc_jug; // Lego, Mattel
	int cat_jug; //FK/ 10
	int stock_jug; // 15
	@ManyToOne // Relacion con tabla proveedores
	@JoinColumn(name="prov_jug", insertable=false, updatable=false) //insertable=false, updatable=false IDENTIDAD REFERENCIAL	
	private Proveedor proveedor; // copia del registro enla
	int prov_jug; //FK/ 2
	
	public Juguete(int id_jug, String nom_jug, double pre_jug, String marc_jug, int cat_jug, int stock_jug,
			int prov_jug) 
	{
		this.id_jug = id_jug;
		this.nom_jug = nom_jug;
		this.pre_jug = pre_jug;
		this.marc_jug = marc_jug;
		this.cat_jug = cat_jug;
		this.stock_jug = stock_jug;
		this.prov_jug = prov_jug;
	}
	public Juguete()
	{
	}
	public Proveedor getProveedor()
	{
		return proveedor;
	}
	public int getId_jug()
	{
		return id_jug;
	}
	public String getNom_jug() 
	{
		return nom_jug;
	}
	public void setNom_jug(String nom_jug)
	{
		this.nom_jug = nom_jug;
	}
	public double getPre_jug()
	{
		return pre_jug;
	}
	public void setPre_jug(double pre_jug)
	{
		this.pre_jug = pre_jug;
	}
	public String getMarc_jug()
	{
		return marc_jug;
	}
	public void setMarc_jug(String marc_jug)
	{
		this.marc_jug = marc_jug;
	}
	public int getCat_jug() 
	{
		return cat_jug;
	}
	public void setCat_jug(int cat_jug) 
	{
		this.cat_jug = cat_jug;
	}
	public int getStock_jug() 
	{
		return stock_jug;
	}
	public void setStock_jug(int stock_jug) 
	{
		this.stock_jug = stock_jug;
	}
	public int getProv_jug() 
	{
		return prov_jug;
	}
	public void setProv_jug(int prov_jug) 
	{
		this.prov_jug = prov_jug;
	}
	@Override
	public String toString() {
		return getId_jug()+","+getNom_jug()+","+getPre_jug()+","+getMarc_jug()+","+getCat_jug()+","+getStock_jug()+","+getProv_jug();
	}
}
