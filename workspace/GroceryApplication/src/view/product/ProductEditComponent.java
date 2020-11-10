package view.product;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ModelDataController;
import controller.ModelDataController.Details;
import controller.ModelDataController.Filter;
import controller.ModelDataController.Select;
import controller.ProductController;
import model.data.Model;
import view.data.ModelListView;

public class ProductEditComponent extends JPanel{

	public ProductEditComponent(Model products, ProductController productController) {
		
		//Panel settings
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//Vertical flow layout
		
		//The list panel
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		
		//Product list
		ModelListView mdlv = new ModelListView(products, productController, "Edit products");
		listPanel.add(mdlv, BorderLayout.CENTER);
		
		//Delete button
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(productController.new Delete());
		listPanel.add(deleteBtn, BorderLayout.SOUTH);
		
		this.add(listPanel);

		
		//Add food and furniture panels
		AddFoodComponent apc = new AddFoodComponent(productController);
		AddFurnitureComponent afc = new AddFurnitureComponent(productController);
		
		this.add(apc);
		this.add(afc);
	}

}
