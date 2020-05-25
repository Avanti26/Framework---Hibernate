package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import domain.vehicle;

public class MainApp2
{
	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(vehicle.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//write a criteria to fetch first 3 records
		Criteria crt1=ses.createCriteria(vehicle.class);
		
		crt1.setMaxResults(3);
		
		List<vehicle> vehicles1=crt1.list();
		
		
		
		for(vehicle v:vehicles1)
		{
			System.out.println(v);
		}
		
		System.out.println("**************************************");
		
		
		//write criteria to exclude first 2 records
		Criteria crt2=ses.createCriteria(vehicle.class);
		
		crt2.setFirstResult(2);
		
		List<vehicle> vehicles2=crt2.list();
		
		
		for(vehicle v:vehicles2)
		{
			System.out.println(v);
		}	
		
		System.out.println("**************************************");
		

		//write a criteria to fetch all the vehicles having price >70000
		Criteria crt3=ses.createCriteria(vehicle.class);
		
		crt3.add(Restrictions.gt("vehiclePrice", 70000.00));
		
		List<vehicle> vehicles3=crt3.list();
		
		for(vehicle v:vehicles3)
		{
			System.out.println(v);
		}
		
		System.out.println("**************************************");
		
		//write a criteria to display all the vehicles whose brand name is honda
		Criteria crt4=ses.createCriteria(vehicle.class);
		crt4.add(Restrictions.like("vehicleBrand", "HONDA"));
		
		List<vehicle> vehicles4=crt4.list();
		for(vehicle v:vehicles4)
		{
			System.out.println(v);
		}
		
		System.out.println( "***************************************");
		
		//write a criteria to display all vehicles in ascending order according to price
		Criteria crt5=ses.createCriteria(vehicle.class);
		
		crt5.addOrder(Order.asc("vehiclePrice"));
		
		List<vehicle> vehicles5=crt5.list();
		for(vehicle v:vehicles5)
		{
			System.out.println(v);
		}
		System.out.println("*******************************************");
		
		//write a criteria to display all vehicles in descending order according to price
		Criteria crt6=ses.createCriteria(vehicle.class);
		
		crt6.addOrder(Order.desc("vehiclePrice"));
		
		List<vehicle> vehicles6=crt6.list();
		
		for(vehicle v:vehicles6)
		{
			System.out.println(v);
		}
		System.out.println("********************************************");
	}

}
