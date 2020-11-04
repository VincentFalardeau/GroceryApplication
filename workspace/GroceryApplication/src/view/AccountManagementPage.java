package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.AccountController;
import controller.ModelDataController;
import model.data.ModelData;
import view.account.AccountEditView;

public class AccountManagementPage extends JFrame{
	
	public AccountManagementPage(ModelData accounts) {
		
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Client Management");

		//The content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new FlowLayout());
		
		//Account list
		AccountController accountsController = new AccountController(accounts);
		AccountEditView aev = new AccountEditView(accounts, accountsController);
		content.add(aev);

		//Employee selector
		//ModelDataController directorsController = new ModelDataController(directors);
		//ModelDataListView directorsView = new ModelDataListView(directors, directorsController, "Choose director");
		//content.add(directorsView);

		//Product list
		//ModelDataController productsController = new ModelDataController(products);
		//ProductEditView productsView = new ProductEditView(products, productsController, directors);
		//content.add(productsView);

		this.setVisible(true);
	}
}


