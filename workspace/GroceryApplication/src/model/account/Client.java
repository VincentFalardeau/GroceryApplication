package model.account;

import java.util.Date;

import model.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;

//Vincent Falardeau
//20170932

public class Client extends Account{
	
	public Client(String firstName, String lastName, LocalDate localDate) {
		super(firstName, lastName, localDate);
	}
	
	@Override
	public String toString() {
		return "Client: " + super.toString();
	}
}
