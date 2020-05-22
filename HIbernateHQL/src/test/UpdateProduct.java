package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class UpdateProduct {

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		factory=cfg.buildSessionFactory();
		ses=factory.openSession();
		
		//update price of all products
		
		//query q="update product_master set product_price=25000.25"
		
		tx=ses.beginTransaction();
		
		Query q1=ses.createQuery("update Product p set p.productPrice=25000.25");
		
		int count=q1.executeUpdate();
		
		tx.commit();
		
		System.out.println(count+ " PRODUCTS ARE UPDATED SUCCESSFULLY");
		
		System.out.println("****************************************");
		
		//delete last two records
		//query q="delete from product_master where product_id>3"
		
		tx=ses.beginTransaction();
		
		Query q2=ses.createQuery("delete from Product p where p.productId>3");
		
		int count1=q2.executeUpdate();
		
		tx.commit();
		
		System.out.println(count1+ " PRODUCTS ARE DELETED SUCCESSFULLY");
	}

}
