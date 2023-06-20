package pruebas;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import beans.Juguete;

public class CRUDHibernate 
{
	public static void main(String[] args) 
	{
		CRUDHibernate hiber = new CRUDHibernate();
		hiber.leerJuguete();
		hiber.AltaJuguete();
	}
	public void leerJuguete()
	{
		Session session = null;
		
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			
			session = factoria.openSession();
			Query consulta = session.createQuery("from Juguete Juguete");
			List<Juguete> lista = consulta.list();
			for (Juguete j : lista) 
			{
				System.out.println(j.toString());
			}
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}finally {
			session.close();
		}
	}
	public void AltaJuguete()
	{
		Session session = null;
		Transaction transaccion = null;
		
		try 
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaccion = session.beginTransaction();
			Juguete j = new Juguete(3,"Pistola Nerf",400,"Nerf",1,13,1); 
			// no se pasa el la clave o id, porque es AI en la BD
			session.saveOrUpdate(j);
			transaccion.commit();
		}
		catch (SecurityException e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		catch (HibernateException e1) 
		{
			System.out.println(e1.getMessage());
			try
			{
				transaccion.rollback();
			}
			catch (IllegalStateException e2) 
			{
				System.out.println("Se ejecuto un rollback");
				e2.printStackTrace();
			}
		}
		finally 
		{
			session.close();
		}
		
	}
}
