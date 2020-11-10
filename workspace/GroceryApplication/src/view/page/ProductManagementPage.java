package view.page;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ModelDataController;
import controller.ProductController;
import model.account.Directors;
import model.data.Model;
import model.product.Products;
import view.data.ModelListView;
import view.product.EditProductComponent;

//Vincent Falardeau
//20170932

public class ProductManagementPage extends JFrame {

	public ProductManagementPage(Products products, ProductController productController, 
			Directors directors, ModelDataController directorsController) {
		
		//Frame settings
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Product Management");
		
		//The content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new FlowLayout());
		
		//Director selector
		ModelListView directorsView = new ModelListView(directors, directorsController, "Choose director");
		content.add(directorsView);
		
		//Product list
		EditProductComponent productsView = new EditProductComponent(products, productController);
		content.add(productsView);	

		this.setVisible(true);
	}
}
