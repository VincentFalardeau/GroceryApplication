package model.product;

import java.util.ArrayList;

import view.ProductManagementView;

public class Products {
	
	private ArrayList<Product> products;
	//The view displaying the products
	private ProductManagementView pmv;
	private int selectedIndex;
	
	public Products() {
		products = new ArrayList<Product>();
	}
	
	public Products(ArrayList<Product> products) {

		this.setProducts(products);
	}

	public void add(Product product) {
		products.add(product);
		updatePmv();
	}

	public void deleteSelected() {
		if(this.selectedIndex >= 0) {
			products.remove(this.selectedIndex);
			updatePmv();
		}
	}
	
	//Update the view displaying the model
	private void updatePmv() {
		if(this.pmv != null) {
			pmv.updateProducts();
		}
		
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

	public void setProductManagementView(ProductManagementView pmv) {
		this.pmv = pmv;
	}

	public int getSelectedIndex() {
		if(selectedIndex < 0) {
			return 0;
		}
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}
}
