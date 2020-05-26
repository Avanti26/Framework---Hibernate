package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student3;

public class MainApp3 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student3.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Student3 s3=new Student3();
		s3.setStudentName("RINA");
		s3.setStudentPercentage(96.12);
		
		tx=ses.beginTransaction();
		
		ses.save(s3);
		
		tx.commit();
		
		System.out.println("STUDENT INSERTED SUCCESSFULLY");
	}

}
