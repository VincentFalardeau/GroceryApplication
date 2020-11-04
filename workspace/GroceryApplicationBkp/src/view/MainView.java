package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.account.ClientController;
import controller.account.GrocerController;
import controller.account.ClientController.Filter;
import controller.product.ProductController;
import controller.product.ProductController.Delete;
import model.account.Client;
import model.account.Clients;
import model.account.Director;
import model.account.Directors;
import model.account.Employee;
import model.account.Grocers;
import model.product.Products;
import view.component.AddFoodComponent;
import view.component.ClientListComponent;
import view.component.DirectorListComponent;
import view.component.GrocerListComponent;
import view.component.MoneyComponent;
import view.component.ProductListComponent;
import model.product.Food;
import model.product.Furniture;
import model.product.Product;

public class MainView extends JFrame{
	
	JPanel content;

	public static void main(String[] args) {
		
		//Create directors model
		Director d1 = new Director("Mario", "Bros", new Date(1970, 12, 1));
		Director d2 = new Director("Jean", "Coutu", new Date(1960, 11, 1));
		Directors directors = new Directors();
		directors.add(d1);
		directors.add(d2);
		
		//Create grocers model
		Employee e1 = new Employee("Jackie", "Chan", new Date(1970, 12, 1));
		Employee e2 = new Employee("Terry", "DeMonte", new Date(1975, 5, 9));
		Grocers grocers = new Grocers();
		grocers.add(d1);
		grocers.add(d2);
		grocers.add(e1);
		grocers.add(e2);
		GrocerController grocerController = new GrocerController(grocers);
		
		//Create available products model
		Product p1 = new Food(d1.getName(), "Pomme", "Rouge", 10);
		Product p2 = new Furniture(d2.getName(), "Sofa", 500, 40);
		Products products = new Products();
		products.add(p1);
		products.add(p2);
		ProductController productController = new ProductController(products, directors);
		
		//Create clients models
		Client c1 = new Client("Maria", "Pacane", new Date(1970, 12, 10));
		c1.addFavoriteProduct(p1);
		c1.addFavoriteProduct(p2);
		c1.addMoney(500);
		Client c2 = new Client("Pierre", "Trudeau", new Date(1990, 2, 18));
		c2.addFavoriteProduct(p1);
		Client c3 = new Client("Joe", "Dassin", new Date(1946, 1, 15));
		c3.addFavoriteProduct(p2);
		c3.addMoney(100.25f);
		Client c4 = new Client("Marc", "Marco", new Date(1988, 1, 15));
		c4.addMoney(900);
		Clients clients = new Clients();
		clients.add(c1);
		clients.add(c2);
		clients.add(c3);
		clients.add(c4);
		ClientController clientController = new ClientController(clients, products, grocers);
		
		MainView mv = new MainView(clients, products, directors, grocers, clientController, productController, grocerController);
	}
	
	public MainView(Clients clients, Products products, Directors directors, Grocers grocers, 
			ClientController clientController, ProductController productController, GrocerController grocerController) {
		
		
		ProductManagementView pmv = new ProductManagementView(directors, products, productController);
		
		//ClientManagementView cmv = new ClientManagementView(clients, grocers, clientController, grocerController);
		
		this.setSize(800, 800);
		this.setTitle("Information");
		
		//The content panel
		content = (JPanel)this.getContentPane();
		content.setLayout(new FlowLayout());
		
		JLabel info = new JLabel("*Double click on list item to view details");
		
		GrocerListComponent elc = new GrocerListComponent(grocers, grocerController);
		
		ProductListComponent plc = new ProductListComponent(products, productController);
		MoneyComponent mp = new MoneyComponent(clientController);
		ClientListComponent clc = new ClientListComponent(clients, clientController);
		
		
		JButton addToFavorites = new JButton("Add to favorites");
		addToFavorites.addActionListener(clientController.new AddFavoriteProduct());
		
		content.add(info);
		content.add(elc);
		content.add(clc);
		content.add(mp);
		content.add(plc);
		content.add(addToFavorites);

		//Display the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
