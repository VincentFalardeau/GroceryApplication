package model.data;

import java.util.ArrayList;

import model.product.Product;

public class AvailableProducts {
	
	private ArrayList<Product> products;
	
	public AvailableProducts() {
		products = new ArrayList<Product>();
	}
	
	public AvailableProducts(ArrayList<Product> products) {
		
		this.setProducts(products);
	}

	public void add (Product product) {
		products.add(product);
	}
	
	public void remove(int index) {
		products.remove(index);
	}
	
	public String[] toStringArray() {
		
		String[] array = new String[products.size()];
		
		int i = 0;
		for(Product d : products) {
			array[i] = d.toString();
			i++;
		}
		
		return array;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
