package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.City;
import domain.Country;

/* Write a program to delete country details along with
 * related cities*/

public class DeleteCountryDetails 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Country.class);
		cfg=cfg.addAnnotatedClass(City.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Country c1=ses.load(Country.class, 2);
		
		tx=ses.beginTransaction();
		
		List<City> citynames=c1.getCityRef();
		
		for(City c:citynames)
		{
			ses.delete(c1);
		}
		
		tx.commit();
		
		System.out.println("COUNTRY AND RESPECTIVE CITIES DELETED");
	}

}
