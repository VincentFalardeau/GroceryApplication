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
		
		private JList productList;
		private JList directorList;
		private JTextField foodName;
		private JTextField foodColor;
		private JTextField foodWeight;
		
		public Add(JList directorList, JTextField foodName, JTextField foodColor, JTextField foodWeight) {
			this.productList = productList;
			this.directorList = directorList;
			this.foodName = foodName;
			this.foodColor = foodColor;
			this.foodWeight = foodWeight;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e){
			int directorIndex = directorList.getSelectedIndex();
			String directorName = "-";
			if(directorIndex > 0) {
				directorName = directors.getDirectors().get(directorIndex).getName();
			}
			try {
				products.add(new Food(directorName, foodName.getText(), foodColor.getText(), Float.parseFloat(foodWeight.getText())));

			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Weight must be a valid number");
			}
		}
	}
}
