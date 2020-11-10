package model.account;

import java.time.LocalDate;

//Vincent Falardeau
//20170932

public class Director extends Employee {
	
	public Director(String firstName, String lastName, LocalDate birthDate){
		super(firstName, lastName, birthDate);
	}
	
	@Override
	public String toString() {
		return "Director, " + super.toString();
	}

}
