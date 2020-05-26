package domain;

import javax.persistence.*;

@Entity
@Table(name="student_master1")
public class Student1 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_percentage")
	private double studentPercentage;
	
	public int getStudentId() 
	{
		return studentId;
	}
	public void setStudentId(int studentId) 
	{
		this.studentId = studentId;
	}
	public String getStudentName() 
	{
		return studentName;
	}
	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}
	public double getStudentPercentage() 
	{
		return studentPercentage;
	}
	public void setStudentPercentage(double studentPercentage) 
	{
		this.studentPercentage = studentPercentage;
	}
}
