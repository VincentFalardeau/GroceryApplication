import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.AccountController;
import controller.ModelDataController;
import controller.ProductController;
import model.account.Client;

import model.account.Director;

import model.account.Employee;
import model.data.ModelData;
import model.product.Food;
import model.product.Furniture;
import model.product.Product;
import view.AccountManagementPage;
import view.InformationPage;
import view.ModelDataListView;
import view.ProductManagementPage;


public class Main {
	
	public static void main(String [] args) {

		//Create directors model
		Director d1 = new Director("Mario", "Bros", new Date(1970, 12, 1));
		Director d2 = new Director("Jean", "Coutu", new Date(1960, 11, 1));
		ModelData directors = new ModelData();
		directors.add(d1);
		directors.add(d2);
		
		//Create employee model
		Employee e1 = new Employee("Jackie", "Chan", new Date(1970, 12, 1));
		e1.addMoney(500);
		Employee e2 = new Employee("Terry", "DeMonte", new Date(1975, 5, 9));
		ModelData employees = new ModelData();
		employees.add(e1);
		employees.add(e2);
		
		//Create products model
		Product p1 = new Food(d1.getName(), "Pomme", "Rouge", 10);
		Product p2 = new Furniture(d2.getName(), "Sofa", 500, 40);
		ModelData products = new ModelData();
		products.add(p1);
		products.add(p2);
		
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
		ModelData clients = new ModelData();
		clients.add(c1);
		clients.add(c2);
		clients.add(c3);
		clients.add(c4);
		
		//Create account model
		ModelData accounts = new ModelData();
		accounts.add(d1);
		accounts.add(d2);
		accounts.add(e1);
		accounts.add(e2);
		accounts.add(c1);
		accounts.add(c2);
		accounts.add(c3);
		accounts.add(c4);
		accounts.addLinkedModelData(directors);
		
		AccountController accountController = new AccountController(accounts, products);
		ProductController productController = new ProductController(products, accounts);
		ModelDataController directorController = new ModelDataController(directors);
		
		ProductManagementPage pmp = new ProductManagementPage(products, productController, directors, directorController);
		
		AccountManagementPage cmp = new AccountManagementPage(accounts, accountController);
		
		InformationPage ip = new InformationPage(accounts, accountController, products, productController);
		
		
		
//		JFrame frame = new JFrame();
//		frame.setSize(1200, 800);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JPanel content = (JPanel)frame.getContentPane();
//		content.setLayout(new FlowLayout());
//		
//		ModelDataController directorsController = new ModelDataController(directors);
//		ModelDataListView directorsView = new ModelDataListView(directors, directorsController);
//		
//		ModelDataController employeesController = new ModelDataController(employees);
//		ModelDataListView employeesView = new ModelDataListView(employees, employeesController);
//		
//		content.add(directorsView);
//		content.add(employeesView);
//		
//		frame.setVisible(true);
		
//		JFrame frame2 = new JFrame();
//		frame2.setSize(1200, 800);
//		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JPanel content2 = (JPanel)frame2.getContentPane();
//		content2.setLayout(new FlowLayout());
//		
//		ModelDataController directorsController2 = new ModelDataController(directors);
//		ModelDataListView directorsView2 = new ModelDataListView(directors, directorsController);
//
//		
//		content2.add(directorsView2);
//		
//		frame2.setVisible(true);
	}
}
