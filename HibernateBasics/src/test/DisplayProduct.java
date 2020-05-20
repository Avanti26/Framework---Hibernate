package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class DisplayProduct {

	public static void main(String[] args) 
	{
		//STEP-1 DECLARE HIBERNATE RESOURCES
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Product p1=ses.load(Product.class, 1);
		
		System.out.println(p1.getProductId());
		System.out.println(p1.getProductName());
		System.out.println(p1.getProductQty());
		System.out.println(p1.getProductPrice());
		System.out.println(p1.getProductCategory());
	}

}
