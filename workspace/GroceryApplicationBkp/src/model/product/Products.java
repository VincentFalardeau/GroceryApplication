package model.product;

import java.util.ArrayList;

import model.account.Director;
import view.ProductManagementView;
import view.component.ProductListComponent;

public class Products {
	
	private ArrayList<Product> products;
	//The views displaying the products
	private ArrayList<ProductListComponent> plcs;
	private int selectedIndex;
	
	public Products() {
		products = new ArrayList<Product>();
		plcs = new ArrayList<ProductListComponent>();
	}

	public void add(Product product) {
		products.add(product);
		update();
	}

	//Delete the current selectedIndex if not null
	public void deleteSelected() {
		if(this.selectedIndex >= 0) {
			products.remove(this.selectedIndex);
			update();
		}
	}
	
	//Update the view displaying the model
	private void update() {
		for(ProductListComponent plc : plcs) {
			plc.update();
		}
		
	}
	
	//Converts the product list in a String array ready for 
	//information displaying
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

	public void addProductListComponent(ProductListComponent plc) {
		this.plcs.add(plc);
	}

	public int getSelectedIndex() {
		if(selectedIndex < 0) {
			return 0;//return 0 by default
		}
		return selectedIndex;
	}
	
	//Gives the selected product object
	public Product getSelectedProduct() {
		if(selectedIndex < 0) {
			return null;
		}
		return products.get(selectedIndex);
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}
}
