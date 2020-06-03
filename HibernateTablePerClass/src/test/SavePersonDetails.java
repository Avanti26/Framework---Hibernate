package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Person;
import domain.Student;
import domain.Trainer;

public class SavePersonDetails 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Person.class);
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Trainer.class);
		
		factory=cfg.buildSessionFactory(); //BUILD CONNECTION WITH DATABASE VENDOR
		
		ses=factory.openSession(); //START THE SESSION
		
		Student s1=new Student();
		s1.setPersonName("AVANTI");
		s1.setPersonEmail("avanti@it.com");
		s1.setCourseName("HIBERNATE");
		
		Trainer t1=new Trainer();
		t1.setPersonName("DURGASOFT");
		t1.setPersonEmail("durgasoft@it.com");
		t1.setSalary(85000.75);
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		ses.save(t1);
		
		tx.commit();
		
		System.out.println("PERSON DETAILS INSERTED SUCCESSFULLY");
	}

}
