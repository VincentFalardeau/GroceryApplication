package controller.product;

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
import model.account.Director;
import model.account.Directors;
import model.product.Products;
import model.product.Food;
import model.product.Product;

public class ProductController {
	
	//Models
	private Products products;
	private Directors directors;
	
	public ProductController(Products products, Directors directors) {
		this.products = products;
		this.directors = directors;	
	}
	
	public class Delete implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			products.deleteSelected();
		}
	}
	
	public class Add implements ActionListener{
		
		private JTextField name;
		private JTextField color;
		private JTextField weight;
		
		public Add(JTextField name, JTextField color, JTextField weight) {
			this.name = name;
			this.color = color;
			this.weight = weight;
		}
		
		@Override
		public void actionPerformed(ActionEvent e){			
			
			try {
				
				//Get the selected director
				Director d = directors.getSelectedDirector();
				if(d == null) {
					throw new InputException("Please select a director");
				}
				
				//The specified name
				String name = this.name.getText();
				if(name.isEmpty()) {
					throw new InputException("Please specify a name");
				}
				
				//The specified color
				String color = this.color.getText();
				if(color.isEmpty()) {
					throw new InputException("Please specify a color");
				}
				
				products.add(new Food(d.getName(), name, color, Float.parseFloat(weight.getText())));

			} catch(NumberFormatException nfe) {
				
				//Show a message dialog if weight is not a valid number
				JOptionPane.showMessageDialog(null, "Weight must be a valid number", "Error", 0);
				
			} catch(InputException ie) {
				
				//Show a message dialog if any input exception is thrown
				JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
			}
		}
	}
}
