package domain;

import javax.persistence.*;

@Entity
@Table(name="employee_master")
@DiscriminatorValue("C")
public class ContractEmployee extends Employee
{
	@Column(name="working_days")
	private int workingDays;

	public int getWorkingDays() 
	{
		return workingDays;
	}

	public void setWorkingDays(int workingDays) 
	{
		this.workingDays = workingDays;
	}
	
}
