package model.account;

import java.util.Date;

public class Employee extends Account{
	
	public Employee(String firstName, String lastName, Date birthDate, String email) {
		super(firstName, lastName, birthDate, email);
	}
}
