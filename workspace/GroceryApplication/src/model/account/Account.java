package model.account;

import java.util.ArrayList;
import java.util.Date;

import model.data.IData;
import model.product.Product;

public abstract class Account implements IData{
	
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	private float balance;
	private ArrayList<Product> favoriteProducts;
	
	public Account(String firstName, String lastName, Date birthDate) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthDate(birthDate);
		this.setEmail(lastName + firstName + "@magasin.ca");
		this.balance = 0.0f;
		this.favoriteProducts = new ArrayList<Product>();
	}
	
	public void addFavoriteProduct(Product product) {
		if(!favoriteProducts.contains(product)) {
			this.favoriteProducts.add(product);
		}
	}
	
	public void addMoney(float amount) {
		balance += amount;
		if(balance < 0.0f) {//to prevent negative balance
			balance = 0.0f;
		}
	}
	
	public void removeFavoriteProduct(Product product) {
		this.favoriteProducts.remove(product);
	}

	public float getBalance() {
		return balance;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	@Override
	public String toString() {
		return "name: " + getName() + ", birth date: " + birthDate.toString() + ", email: " + email;
	}
	
	public String getDetails() {
		String details = toString() + "\n";
		
		details += "Balance: " + balance + "$" + "\n";
		
		details += "Favorite products: " + "\n";
		
		for(Product p : favoriteProducts) {
			details += "-" + p.toString() + "\n";
		}
		
		return details;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
