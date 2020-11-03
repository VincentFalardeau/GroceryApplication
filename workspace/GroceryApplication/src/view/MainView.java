package view;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.product.ProductController;
import model.account.Director;
import model.account.Directors;
import model.product.Products;
import model.product.Food;
import model.product.Furniture;
import model.product.Product;

public class MainView {

	public static void main(String[] args) {
		
		//Create directors model
		Director d1 = new Director("Mario", "Bros", new Date(1970, 12, 1), "mario.bros@gmail.com");
		Director d2 = new Director("Jean", "Coutu", new Date(1960, 11, 1), "jean.coutu@gmail.com");
		Directors directors = new Directors();
		directors.add(d1);
		directors.add(d2);
		
		//Create available products model
		Product p1 = new Food(d1.getName(), "Pomme", "Rouge", 10);
		Product p2 = new Furniture(d2.getName(), "Sofa", 500, 40);
		Products products = new Products();
		products.add(p1);
		products.add(p2);
		ProductController productController = new ProductController(products, directors);
		
		//Open the product management view
		ProductManagementView pmv = new ProductManagementView(directors, products, productController);
		
	}

}
