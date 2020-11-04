package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.AccountController;
import controller.ModelDataController;
import model.data.ModelData;
import view.account.AccountEditView;

public class AccountManagementPage extends JFrame{
	
	public AccountManagementPage(ModelData accounts, AccountController accountController) {
		
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Account Management");

		//The content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new FlowLayout());
		
		//Account list
		AccountEditView aev = new AccountEditView(accounts, accountController);
		content.add(aev);

		this.setVisible(true);
	}
}


