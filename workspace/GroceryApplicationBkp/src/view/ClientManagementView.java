package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.account.ClientController;
import controller.account.GrocerController;
import model.account.Clients;
import model.account.Grocers;
import view.component.ClientListComponent;
import view.component.DirectorListComponent;
import view.component.GrocerListComponent;
import view.component.ProductListComponent;

public class ClientManagementView extends JFrame{
	
	JPanel content;
	
	public ClientManagementView(Clients clients, Grocers grocers, ClientController clientController, GrocerController grocerController) {
		this.setSize(1200, 500);
		this.setTitle("Client Management");
		this.setLayout(new FlowLayout());
		
		GrocerListComponent glc = new GrocerListComponent(grocers, grocerController);
		
		ClientListComponent clc = new ClientListComponent(clients, clientController);
		
		//The content panel
		content = (JPanel)this.getContentPane();
		
		content.add(glc);
		content.add(clc);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
