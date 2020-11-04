package model.account;

import java.util.Date;

public class Employee extends Account{
	
	public Employee(String firstName, String lastName, Date birthDate) {
		super(firstName, lastName, birthDate);
	}
	
	@Override
	public String toString() {
		return "Employee, " + super.toString();
	}
	
	@Override
	public String getDetails() {
		return this.toString();
	}
}
