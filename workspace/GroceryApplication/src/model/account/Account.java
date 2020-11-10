package model.account;

import java.time.LocalDate;
import java.util.ArrayList;

import model.data.IData;
import model.product.Product;

//Vincent Falardeau
//20170932

public abstract class Account implements IData{
	
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String email;
	private float balance;
	private ArrayList<Product> favoriteProducts;
	
	public Account(String firstName, String lastName, LocalDate birthDate) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthDate(birthDate);
		this.setEmail(this.lastName + this.firstName + "@magasin.ca");
		this.balance = 0.0f;
		this.favoriteProducts = new ArrayList<Product>();
	}
	
	//Add a favorite product, if not already in favorites
	public void addFavoriteProduct(Product product) {
		if(!favoriteProducts.contains(product)) {
			this.favoriteProducts.add(product);
		}
	}
	
	//Add money 
	public void addMoney(float amount) {
		balance += amount;
		if(balance < 0.0f) {//to prevent negative balance
			balance = 0.0f;
		}
		else if((int)balance > IData.MAX_NUMBER) {
			balance = IData.MAX_NUMBER;
		}
	}
	
	//Remove a favorite product
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
	
	//Gives more details about the account than the toString method
	public String getDetails() {
		String details = toString() + "\n";
		
		//The balance
		details += "Balance: " + balance + "$" + "\n";
		
		//The favorite products
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
		
		if(firstName.length() > IData.MAX_INPUT_LEN) {
			this.firstName = firstName.substring(0, IData.MAX_INPUT_LEN);
		}
		else {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		
		if(lastName.length() > IData.MAX_INPUT_LEN) {
			this.lastName = lastName.substring(0, IData.MAX_INPUT_LEN);
		}
		else {
			this.lastName = lastName;
		}
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}
}
