package view.product;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.AccountController;
import controller.ModelDataController;
import controller.ModelDataController.Delete;
import controller.ProductController;
import model.data.ModelData;
import view.ModelDataListView;

public class FavoriteProductView extends JPanel{
	
	public FavoriteProductView(ModelData products, ProductController productController, AccountController accountController) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//Vertical flow layout
		
		//The list
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		
		//List view
		ModelDataListView mdlv = new ModelDataListView(products, productController, "Edit favorites");
		listPanel.add(mdlv, BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		
		//Add button
		JButton addBtn = new JButton("Add to favorites");
		addBtn.addActionListener(accountController.new AddFavorite());
		btnPanel.add(addBtn, BorderLayout.SOUTH);
		
		//Remove button
		JButton removeBtn = new JButton("Remove from favorites");
		removeBtn.addActionListener(accountController.new RemoveFavorite());
		btnPanel.add(removeBtn, BorderLayout.SOUTH);
		
		listPanel.add(btnPanel, BorderLayout.SOUTH);
		
		this.add(listPanel);
	}
}
