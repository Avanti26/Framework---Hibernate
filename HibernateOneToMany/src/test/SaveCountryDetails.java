package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.City;
import domain.Country;

public class SaveCountryDetails 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(City.class);
		cfg=cfg.addAnnotatedClass(Country.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//load the country from database table
		Country c1=ses.load(Country.class, 2);
		
		//create objects of city class
		City ct1=new City();
		ct1.setCityName("NEW YORK");
		
		City ct2=new City();
		ct2.setCityName("WASHINGTON DC");
		
		//add cities into the country
		c1.addCities(ct1);
		c1.addCities(ct2);
		
		tx=ses.beginTransaction();
		
		ses.save(ct1);
		ses.save(ct2);
		
		tx.commit();
		
		System.out.println("DETAILS STORED SUCCESSFULLY");
	}

}
