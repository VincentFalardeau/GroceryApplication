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
import controller.product.ProductController;
import controller.product.ProductController.Delete;
import model.account.Client;
import model.account.Clients;
import model.account.Director;
import model.account.Directors;
import model.product.Products;
import view.component.AddFoodComponent;
import view.component.ClientListComponent;
import view.component.ClientSearchComponent;
import view.component.DirectorListComponent;
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
		
		//Create available products model
		Product p1 = new Food(d1.getName(), "Pomme", "Rouge", 10);
		Product p2 = new Furniture(d2.getName(), "Sofa", 500, 40);
		Products products = new Products();
		products.add(p1);
		products.add(p2);
		ProductController productController = new ProductController(products, directors);
		
		//Create clients models
		Client c1 = new Client("Maria", "Pacane", new Date(1970, 12, 10));
		Client c2 = new Client("Pierre", "Trudeau", new Date(1990, 2, 18));
		Client c3 = new Client("Joe", "Dassin", new Date(1946, 1, 15));
		Client c4 = new Client("Marc", "Marco", new Date(1988, 1, 15));
		Clients clients = new Clients();
		clients.add(c1);
		clients.add(c2);
		clients.add(c3);
		clients.add(c4);
		ClientController clientController = new ClientController(clients);
		
		MainView mv = new MainView(clients, products, directors, clientController, productController);
	}
	
	public MainView(Clients clients, Products products, Directors directors, ClientController clientController, ProductController productController) {
		
		ProductManagementView pmv = new ProductManagementView(directors, products, productController);
		
		this.setSize(1200, 800);
		this.setTitle("Information");
		
		//The content panel
		content = (JPanel)this.getContentPane();
		content.setLayout(new FlowLayout());
		
		ClientListComponent clc = new ClientListComponent(clients, clientController);
		
		content.add(clc);
		
		//Display the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
