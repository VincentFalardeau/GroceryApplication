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
import view.component.AddFoodComponent;
import view.component.DirectorListComponent;
import view.component.ProductListComponent;
import model.product.Product;

public class ProductManagementView extends JFrame{
	
	private Products products;
	private ProductListComponent plc;
	
	
	public ProductManagementView(Directors directors, Products products, ProductController productController) {
		
		this.setSize(1200, 800);
		
		//The model
		this.products = products;
		products.setProductManagementView(this);
		
		//Retreive the content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new FlowLayout());
		
		//Create components
		DirectorListComponent dlc = new DirectorListComponent(directors);
		plc = new ProductListComponent(products);
		AddFoodComponent apc = new AddFoodComponent(productController);
		
		//Create a delete button for the product list
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(productController.new Delete());
		
		content.add(dlc);
		content.add(plc);
		content.add(deleteBtn);
		content.add(apc);
	
		//Display the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void updateProducts() {
		plc.update();
	}
}