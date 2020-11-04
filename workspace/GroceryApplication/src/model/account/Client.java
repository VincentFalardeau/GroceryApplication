package model.account;

import java.util.Date;

import model.product.Product;

import java.util.ArrayList;

public class Client extends Account{
	
	public Client(String firstName, String lastName, Date birthDate) {
		super(firstName, lastName, birthDate);
	}
	
	@Override
	public String toString() {
		return "Client: " + super.toString();
	}
}
