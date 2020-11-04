package view;

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
import model.data.ModelData;

public class ModelDataEditView extends JPanel{

	public ModelDataEditView(ModelData products, ModelDataController productsController, ModelData directors) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//Vertical flow layout
		
		//The list
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		
		//List view
		ModelDataListView mdlv = new ModelDataListView(products, productsController, "Edit products");
		listPanel.add(mdlv, BorderLayout.CENTER);
		
		//Delete button
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(productsController.new Delete());
		listPanel.add(deleteBtn, BorderLayout.SOUTH);
		
		this.add(listPanel);

		
		//Add food and furniture panels
		ProductController productController = new ProductController(products, directors);
		AddFoodComponent apc = new AddFoodComponent(productController);
		AddFurnitureComponent afc = new AddFurnitureComponent(productController);
		
		this.add(apc);
		this.add(afc);
	}

}
