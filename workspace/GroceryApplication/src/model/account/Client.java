package model.account;

import java.util.Date;

import model.product.Product;

import java.util.ArrayList;

public class Client extends Account{
	
	private float balance;
	private ArrayList<Product> favoriteProducts;
	
	public Client(String firstName, String lastName, Date birthDate) {
		super(firstName, lastName, birthDate);
		
		setBalance(0.0f);
		setFavoriteProducts(new ArrayList<Product>());
	}
	
	public void addFavoriteProduct(Product product) {
		if(!favoriteProducts.contains(product)) {
			this.favoriteProducts.add(product);
		}
		
	}
	
	public void addMoney(float amount) {
		balance += amount;
		if(balance < 0.0f) {
			balance = 0.0f;
		}
	}
	
	public void removeFavoriteProduct(Product product) {
		this.favoriteProducts.remove(product);
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public ArrayList<Product> getFavoriteProducts() {
		return favoriteProducts;
	}

	public void setFavoriteProducts(ArrayList<Product> favoriteProducts) {
		this.favoriteProducts = favoriteProducts;
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
	
	@Override
	public String toString() {
		return "Client: " + super.toString();
	}
}
