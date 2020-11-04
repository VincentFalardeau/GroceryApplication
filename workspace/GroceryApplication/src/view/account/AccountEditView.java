package view.account;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ProductController;
import model.data.ModelData;
import controller.AccountController;
import controller.ModelDataController;
import controller.ModelDataController.Delete;
import view.ModelDataListView;
import view.product.AddFoodComponent;
import view.product.AddFurnitureComponent;

public class AccountEditView extends JPanel{
	
	public AccountEditView(ModelData accounts, AccountController accountsController) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//Vertical flow layout
		
		//The list
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		
		//List view
		ModelDataListView mdlv = new ModelDataListView(accounts, accountsController, "Edit accounts");
		listPanel.add(mdlv, BorderLayout.CENTER);
		
		//Delete button
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(accountsController.new Delete());
		listPanel.add(deleteBtn, BorderLayout.SOUTH);
		
		this.add(listPanel);
		
		//Add account
		AddAccountComponent aac = new AddAccountComponent(accountsController);

		this.add(aac);
	}

}












