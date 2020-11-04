package model.account;

import java.util.Date;

public class Employee extends Account implements Grocer{
	
	public Employee(String firstName, String lastName, Date birthDate) {
		super(firstName, lastName, birthDate);
	}
	
	@Override
	public String toString() {
		return "Employee, " + super.toString();
	}
}
