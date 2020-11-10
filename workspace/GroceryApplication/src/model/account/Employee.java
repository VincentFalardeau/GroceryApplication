package model.account;

import java.time.LocalDate;

//Vincent Falardeau
//20170932

public class Employee extends Account{
	
	public Employee(String firstName, String lastName, LocalDate birthDate) {
		super(firstName, lastName, birthDate);
	}
	
	@Override
	public String toString() {
		return "Employee, " + super.toString();
	}
}
