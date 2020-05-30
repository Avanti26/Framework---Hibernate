package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.City;
import domain.Country;

public class DisplayCityDetails 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Country.class);
		cfg=cfg.addAnnotatedClass(City.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//LOAD COUNTRY OBJECT FROM DATABASE TABLE
		Country c1=ses.load(Country.class, 2);
		
		System.out.println("COUNTRY NAME IS :"+c1.getCountryName());
		
		List<City> citynames=c1.getCityRef();
		
		System.out.println("---------------------------------");
		
		System.out.println("LIST OF CITIES");
		for(City c:citynames)
		{
			System.out.println(c.getCityName());
		}
	}

}
