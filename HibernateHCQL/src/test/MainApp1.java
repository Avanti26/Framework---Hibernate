package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import domain.vehicle;

public class MainApp1
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
		
		//display all objects from database table
		Criteria crt1=ses.createCriteria(vehicle.class);
		List<vehicle> vehicles=crt1.list();
		
		System.out.println("ID\tNAME\tPRICE\tBRAND");
		System.out.println("*****************************************");
		for(vehicle v:vehicles)
		{
			System.out.println(v.getVehicleId()+"\t"+v.getVehicleName()+"\t"+v.getVehiclePrice()+"\t"+v.getVehicleBrand());
		}
		
		System.out.println("*****************************************");

		//display data from specific column
		Criteria crt2=ses.createCriteria(vehicle.class);
		crt2.setProjection(Projections.property("vehicleName"));
		
		List<String> vehiclenames=crt2.list();
		System.out.println("VEHICLE NAMES");
		System.out.println("--------------");
		for(String s: vehiclenames)
		{
			System.out.println(s);
		}
		
		System.out.println("******************************************");
		
		//display data from two or more columns
		Criteria crt3=ses.createCriteria(vehicle.class);
		ProjectionList p1=Projections.projectionList();
		p1.add(Projections.property("vehicleName"));
		p1.add(Projections.property("vehiclePrice"));
		
		crt3.setProjection(p1);
		
		List vehicledata=crt3.list();
		
		Iterator itr=vehicledata.iterator();
		System.out.println("NAME\tPRICE");
		System.out.println("-----------------");
		
		while(itr.hasNext())
		{
			Object[] arr1=(Object[]) itr.next();
			
			System.out.println(arr1[0]+"\t"+arr1[1]);
		}
	}
}
