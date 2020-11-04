package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ModelDataController;
import model.data.ModelData;


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
		ModelDataController productsController = new ModelDataController(products);
		ModelDataEditView productsView = new ModelDataEditView(products, productsController, directors);
		content.add(productsView);
		
//		//Create a delete button for the food list
//		JButton deleteBtn = new JButton("Delete");
//		deleteBtn.addActionListener(productController.new Delete());
	

		this.setVisible(true);
	}
}
