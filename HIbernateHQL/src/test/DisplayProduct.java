package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class DisplayProduct {

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		factory=cfg.buildSessionFactory();
		ses=factory.openSession();
		
		/*display single record
		  Product p1=ses.load(Product.class, 1);
		  System.out.println(p1.getProductId()+"\t"+p1.getProductName()+"\t"+p1.getProductQty()+"\t"+p1.getProductPrice()+"\t"+p1.getProductCategory());*/
		
		//display multiple record by using HQL
		//String query="select * from product_master"=====>SQL Query
		
		Query q=ses.createQuery("select p from Product p");
		
		List<Product> products=q.list();
		
		for(Product p:products)
		{
			System.out.println(p.getProductId()+"\t"+p.getProductName()+"\t"+p.getProductQty()+"\t"+p.getProductPrice()+"\t"+p.getProductCategory());
		}
		
	}

}
