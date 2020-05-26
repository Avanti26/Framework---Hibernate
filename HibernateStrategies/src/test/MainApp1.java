package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student1;

public class MainApp1 {

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student1.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Student1 s1=new Student1();
		s1.setStudentName("ROHIT");
		s1.setStudentPercentage(87.59);
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		
		tx.commit();
		
		System.out.println("STUDENT INSERTED SUCCESSFULLY");
	}

}
