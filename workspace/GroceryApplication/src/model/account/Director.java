package model.account;

import java.util.Date;

public class Director extends Account{
	
	public Director(String firstName, String lastName, Date birthDate, String email) {
		super(firstName, lastName, birthDate, email);
	}
	
	@Override
	public String toString() {
		return "Director, " + super.toString();
	}
}
