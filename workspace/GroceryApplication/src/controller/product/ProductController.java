package controller.product;

import java.util.ArrayList;

import model.data.AvailableProducts;
import model.product.Product;

public class ProductController {
	
	private AvailableProducts products;
	
	public ProductController(AvailableProducts products) {
		this.setProducts(products);
	}

	public AvailableProducts getProducts() {
		return products;
	}

	public void setProducts(AvailableProducts products) {
		this.products = products;
	}
}
