package view.page;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.AccountController;
import model.account.Accounts;
import model.data.Model;
import view.account.EditAccountComponent;

//Vincent Falardeau
//20170932

public class AccountManagementPage extends JFrame{
	
	public AccountManagementPage(Accounts accounts, AccountController accountController) {
		
		//Frame settings
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Account Management");

		//The content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new FlowLayout());
		
		//Account list
		EditAccountComponent aev = new EditAccountComponent(accounts, accountController);
		content.add(aev);

		this.setVisible(true);
	}
}


