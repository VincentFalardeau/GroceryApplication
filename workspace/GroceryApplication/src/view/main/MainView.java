package view.main;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.account.DirectorController;
import controller.product.ProductController;
import model.account.Director;
import model.data.Directors;
import model.data.AvailableProducts;
import model.product.Food;
import model.product.Furniture;
import model.product.Product;

public class MainView {

	public static void main(String[] args) {
		
		//Creating directors
		Director d1 = new Director("Mario", "Bros", new Date(1970, 12, 1), "mario.bros@gmail.com");
		Director d2 = new Director("Jean", "Coutu", new Date(1960, 11, 1), "jean.coutu@gmail.com");
		Directors directors = new Directors();
		directors.add(d1);
		directors.add(d2);
		DirectorController directorController = new DirectorController(directors);
		
		//Creating initial available products
		Product p1 = new Food(d1.getName(), "Pomme", "Rouge", 10);
		Product p2 = new Furniture(d2.getName(), "Sofa", 500, 40);
		AvailableProducts products = new AvailableProducts();
		products.add(p1);
		products.add(p2);
		ProductController productController = new ProductController(products);
		
		//Opening the product management view
		ProductManagementView pmv = new ProductManagementView(directors, directorController, products, productController);
	}

}
