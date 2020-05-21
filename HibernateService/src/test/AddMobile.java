package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Mobile;

public class AddMobile {

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		ses=factory.openSession();
		
		Mobile m1=new Mobile();
		
		m1.setMobileId(1);
		m1.setMobileName("ONEPLUS 6T");
		m1.setMobileQty(6);
		m1.setMobilePrice(46000.75);
		m1.setMobileCategory("ANDROID");
		
		tx=ses.beginTransaction();
		ses.save(m1);
		tx.commit();
		System.out.println("MOBILE ADDED SUCCESSFULLY");
	}

}
