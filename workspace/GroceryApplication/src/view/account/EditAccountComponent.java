package view.account;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ProductController;
import model.account.Accounts;
import model.data.Model;
import controller.AccountController;
import controller.ModelDataController;
import controller.ModelDataController.Delete;
import view.data.ModelListView;
import view.product.AddFoodComponent;
import view.product.AddFurnitureComponent;

//Vincent Falardeau
//20170932

public class EditAccountComponent extends JPanel{
	
	public EditAccountComponent(Accounts accounts, AccountController accountsController) {
		
		//Panel settings
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//Vertical flow layout
		
		//The list
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		
		//List view
		ModelListView mdlv = new ModelListView(accounts, accountsController, "Edit accounts");
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












