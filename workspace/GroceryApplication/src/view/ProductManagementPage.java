package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ModelDataController;
import controller.ProductController;
import model.data.ModelData;
import view.product.ProductEditView;


public class ProductManagementPage extends JFrame {

	public ProductManagementPage(ModelData products, ModelData directors) {
		
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Product Management");
		
		//The content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new FlowLayout());
		
		//Director selector
		ModelDataController directorsController = new ModelDataController(directors);
		ModelDataListView directorsView = new ModelDataListView(directors, directorsController, "Choose director");
		content.add(directorsView);
		
		//Product list
		ProductController productsController = new ProductController(products, directors);
		ProductEditView productsView = new ProductEditView(products, productsController);
		content.add(productsView);	

		this.setVisible(true);
	}
}
