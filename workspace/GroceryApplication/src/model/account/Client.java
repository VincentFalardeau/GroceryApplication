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
		this.favoriteProducts.add(product);
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
	
	@Override
	public String toString() {
		return "Client: " + super.toString();
	}
}
