package model.account;

import java.util.Date;

public class Director extends Account implements Grocer {
	
	public Director(String firstName, String lastName, Date birthDate){
		super(firstName, lastName, birthDate);
	}
	
	@Override
	public String toString() {
		return "Director, " + super.toString();
	}
}
