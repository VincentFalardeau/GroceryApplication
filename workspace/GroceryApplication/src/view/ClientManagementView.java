package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.account.ClientController;
import model.account.Clients;
import view.component.ClientListComponent;
import view.component.DirectorListComponent;
import view.component.ProductListComponent;

public class ClientManagementView extends JFrame{
	
	JPanel content;
	
	public ClientManagementView(Clients clients, ClientController clientController) {
		this.setSize(1200, 300);
		this.setTitle("Client Management");
		this.setLayout(new FlowLayout());
		
		ClientListComponent clc = new ClientListComponent(clients, clientController);
		
		//The content panel
		content = (JPanel)this.getContentPane();
		
		content.add(clc);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
