package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.ContractEmployee;
import domain.Employee;
import domain.PermanentEmployee;

public class SaveEmployeeDetails 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Employee.class);
		cfg=cfg.addAnnotatedClass(PermanentEmployee.class);
		cfg=cfg.addAnnotatedClass(ContractEmployee.class);
		
		factory=cfg.buildSessionFactory(); // BUILD THE CONNECTION WITH DATABASE VENDOR
		
		ses=factory.openSession(); //START THE SESSION
		
		ContractEmployee c1=new ContractEmployee();
		c1.setEmployeeName("ROHIT");
		c1.setEmployeeAge(24);
		c1.setWorkingDays(250);
		
		PermanentEmployee p1=new PermanentEmployee();
		p1.setEmployeeName("KARTIK");
		p1.setEmployeeAge(27);
		p1.setDesignation("DEVELOPER");
		
		tx=ses.beginTransaction();
		
		ses.save(c1);
		ses.save(p1);
		
		tx.commit();
		
		System.out.println("EMPLOYEE DETAILS INSERTED SUCCESSFULLY");
}

}
