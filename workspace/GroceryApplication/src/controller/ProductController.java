package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import exception.InputException;
import model.account.Account;
import model.account.Accounts;
import model.account.Client;
import model.account.Director;
import model.account.Directors;
import model.data.IData;
import model.data.Model;
import model.product.Food;
import model.product.Furniture;
import model.product.Product;
import model.product.Products;

//Vincent Falardeau
//20170932

public class ProductController extends ModelDataController {
	
	//Models
	private Products products;
	private Directors directors;
	private Accounts accounts;
	
	public ProductController(Model products, Directors directors, Accounts accounts) {
		super(products);
		this.products = (Products)products;
		this.directors = directors;	
		this.accounts = accounts;	
	}
	
	//To add food
	public class AddFood implements ActionListener{
		
		private JTextField name;
		private JTextField color;
		private JTextField weight;
		
		public AddFood(JTextField name, JTextField color, JTextField weight) {
			this.name = name;
			this.color = color;
			this.weight = weight;
		}
		
		@Override
		public void actionPerformed(ActionEvent e){			
			
			try {
				
				//Get the selected director and validate it
				IData d = directors.getSelected();
				if(d == null) {
					throw new InputException("Please select a director");
				}
				
				//The specified name and validate it
				String name = this.name.getText();
				if(name.isEmpty()) {
					throw new InputException("Please specify a name");
				}
				
				//The specified color and validate it
				String color = this.color.getText();
				if(color.isEmpty()) {
					throw new InputException("Please specify a color");
				}
				
				//Add the food
				products.add(new Food(d.getName(), name, color, Float.parseFloat(weight.getText())));

			//If weight is not a valid number
			} catch(NumberFormatException nfe) {
				
				JOptionPane.showMessageDialog(null, "Weight must be a valid number", "Error", 0);
				
			} catch(InputException ie) {
				
				JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
			}
		}
	}
	
	//To add furniture
	public class AddFurniture implements ActionListener{
		
		private JTextField type;
		private JTextField price;
		private JTextField height;
		
		public AddFurniture(JTextField type, JTextField price, JTextField height) {
			this.type = type;
			this.price = price;
			this.height = height;
		}
		
		@Override
		public void actionPerformed(ActionEvent e){			
			
			try {
				
				//Get the selected director and validate it
				IData d = directors.getSelected();
				if(d == null) {
					throw new InputException("Please select a director");
				}
				
				//The specified type and validate it
				String type = this.type.getText();
				if(type.isEmpty()) {
					throw new InputException("Please specify a type");
				}

				//Add the furniture
				products.add(new Furniture(d.getName(), type, Float.parseFloat(this.price.getText()), Float.parseFloat(this.height.getText())));

			//In case price or height are not valid numbers
			} catch(NumberFormatException nfe) {
				
				JOptionPane.showMessageDialog(null, "Price/Height must be a valid number", "Error", 0);
				
			} catch(InputException ie) {
				
				JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
			}
		}
	}
	
	//To delete the selected product
	public class Delete implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Remove the selected product from the accounts' favorites
			Product p = (Product)products.getSelected();
			for(IData i: accounts) {
				Account a = (Account)i;
				a.removeFavoriteProduct(p);
			}
			
			//Remove the selected product from the model data
			modelData.deleteSelected();
			
		}
	}
}
