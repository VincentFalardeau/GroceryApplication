package controller.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import model.data.AvailableProducts;
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
		private JTextField foodName;
		
		public Add(JList productList, JTextField foodName) {
			this.productList = productList;
			this.foodName = foodName;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			products.add(new Food("Jean", foodName.getText(), "red", 10));
			
			refresh(productList);
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
