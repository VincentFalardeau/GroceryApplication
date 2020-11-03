package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.product.ProductController;
import model.account.Director;
import model.account.Directors;
import model.product.Products;
import view.component.DirectorListComponent;
import view.component.ProductListComponent;
import model.product.Product;

public class ProductManagementView extends JFrame{
	
	private Products products;
	private DirectorListComponent dlc;
	private ProductListComponent plc;
	
	
	public ProductManagementView(Directors directors, Products products, ProductController productController) {
		
		this.setSize(1200, 800);
		
		//The model
		this.products = products;
		products.setProductManagementView(this);
		
		//Retreive the content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new FlowLayout());
		
		//Create components and add them
		dlc = new DirectorListComponent(directors);
		plc = new ProductListComponent(products);
		content.add(dlc);
		content.add(plc);
		
		//Create a delete button for the product list
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(productController.new Delete());
		content.add(deleteBtn);
		
	
		//Display the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	

//	
//	private void addFoodPanel(ProductController productController, JPanel panel) {
//		
//		//Add food panel
//		addFoodPanel = new JPanel();
//		addFoodPanel.setLayout(new BorderLayout());
//		
//		//Label
//		JLabel label3 = new JLabel("Add food");
//		addFoodPanel.add(label3, BorderLayout.NORTH);
//		
//		//Food field panel
//		addFoodPanelFields = new JPanel();
//		addFoodPanelFields.setLayout(new FlowLayout());
//				
//		//Name field
//		foodName = new JTextField();
//		addTextInputField("Name", foodName, addFoodPanelFields);
//		
//		//Color field
//		foodColor = new JTextField();
//		addTextInputField("Color", foodColor, addFoodPanelFields);
//				
//		//Weight field
//		foodWeight = new JTextField();
//		addTextInputField("Weight", foodWeight, addFoodPanelFields);
//				
//		//Add fields to fields panel
//		addFoodPanel.add(addFoodPanelFields, BorderLayout.CENTER);
//		
//		//Add button
//		addFoodButton = new JButton("Add");
//		addFoodButton.addActionListener(productController.new Add(productList, directorList, foodName, foodColor, foodWeight));
//		addFoodPanel.add(addFoodButton, BorderLayout.SOUTH);
//		
//		//Add food panel to panel
//		panel.add(addFoodPanel);
//	}
//	
//	private void addTextInputField(String name, JTextField field, JPanel panel) {
//		JLabel label = new JLabel(name);
//		panel.add(label);
//		field.setPreferredSize(new Dimension(100, 20));
//		panel.add(field);
//	}

	public void updateProducts() {
		plc.update();
	}
}
