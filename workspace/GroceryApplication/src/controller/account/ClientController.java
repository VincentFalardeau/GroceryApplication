package controller.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.account.Account;
import model.account.Client;
import model.account.Clients;
import model.account.Directors;
import model.product.Products;

public class ClientController {
	//Models
	private Clients clients;
		
	public ClientController(Clients clients) {
		this.clients = clients;
	}
	
	public class Filter implements ActionListener{
		
		private JTextField filter;
		
		public Filter(JTextField filter) {
			this.filter = filter;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			clients.setFilter(filter.getText());
		}
	}
}
