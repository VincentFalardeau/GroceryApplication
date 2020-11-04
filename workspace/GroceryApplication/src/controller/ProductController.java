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
import model.account.Director;
import model.data.IData;
import model.data.ModelData;
import model.product.Food;
import model.product.Furniture;
import model.product.Product;

public class ProductController extends ModelDataController {
	
	//Models
	private ModelData products;
	private ModelData directors;
	
	public ProductController(ModelData products, ModelData directors) {
		super(products);
		this.products = super.modelData;
		this.directors = directors;	
	}
	
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
				
				//Get the selected director
				IData d = directors.getSelected();
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
				
				//Get the selected director
				IData d = directors.getSelected();
				if(d == null) {
					throw new InputException("Please select a director");
				}
				
				//The specified type
				String type = this.type.getText();
				if(type.isEmpty()) {
					throw new InputException("Please specify a type");
				}

				products.add(new Furniture(d.getName(), type, Float.parseFloat(this.price.getText()), Float.parseFloat(this.height.getText())));

			} catch(NumberFormatException nfe) {
				
				//Show a message dialog if weight is not a valid number
				JOptionPane.showMessageDialog(null, "Price/Height must be a valid number", "Error", 0);
				
			} catch(InputException ie) {
				
				//Show a message dialog if any input exception is thrown
				JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
			}
		}
	}
}
