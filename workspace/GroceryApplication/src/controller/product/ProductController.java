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

import model.data.AvailableProducts;
import model.data.Directors;
import model.product.Food;
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
	
	public class Delete implements ActionListener{
		
		private JList productList;
		
		public Delete(JList productList) {
			this.productList = productList;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Delete the selected element from the model
			int index = productList.getSelectedIndex();
			products.remove(index);
			
			refresh(productList);
		}
	}
	
	public class Add implements ActionListener{
		
		private JList productList;
		private JList directorList;
		private Directors directors;
		private JTextField foodName;
		private JTextField foodColor;
		private JTextField foodWeight;
		
		public Add(JList productList, JList directorList, Directors directors, JTextField foodName, JTextField foodColor, JTextField foodWeight) {
			this.productList = productList;
			this.directorList = directorList;
			this.directors = directors;
			this.foodName = foodName;
			this.foodColor = foodColor;
			this.foodWeight = foodWeight;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e){
			int directorIndex = directorList.getSelectedIndex();
			String directorName = directors.getDirectors().get(directorIndex).getName();
			try {
				products.add(new Food(directorName, foodName.getText(), foodColor.getText(), Float.parseFloat(foodWeight.getText())));
				
				refresh(productList);
			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Weight must be a valid number");
			}
			
			
			
		}
	}
	
	private void refresh(JList productList) {
		//Update the product list
		DefaultListModel dlm = new DefaultListModel();
		int i = 0;
		for(String str : products.toStringArray()) {
			dlm.add(i,str);
			i++;
		}
		productList.setModel(dlm);
	}
}
