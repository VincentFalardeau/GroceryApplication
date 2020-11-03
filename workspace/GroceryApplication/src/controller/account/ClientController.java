package controller.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.account.Account;
import model.account.Client;
import model.account.Clients;
import model.account.Directors;
import model.account.Grocers;
import model.product.Product;
import model.product.Products;

public class ClientController {
	//Models
	private Clients clients;
	private Products products;
	private Grocers grocers;
		
	public ClientController(Clients clients, Products products, Grocers grocers) {
		this.clients = clients;
		this.products = products;
		this.grocers = grocers;
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
	
	public class Details extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
		    	
			if (e.getClickCount() == 2) {
		        	
				Client c = clients.getSelectedClient();
		        	
		        	if(c != null) {
		        		//Show a message dialog containing the selected product's information
						JOptionPane.showMessageDialog(null, c.getDetails(), "Details", 1);
		        	}		        	
		        }
		    }	
		
	}
	
	public class Select implements ListSelectionListener{
		
		JList list;
		
		public Select(JList list) {
			this.list = list;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			clients.setSelectedIndex(list.getSelectedIndex());
		}
	}
	
	public class AddFavoriteProduct implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Client c = clients.getSelectedClient();
			Product p = products.getSelectedProduct();
			if(p != null && c != null) {
				c.addFavoriteProduct(p);
				JOptionPane.showMessageDialog(null,"**" + p.toString() + "** successfully added to " + 
						c.getName() + "'s favorites by " + grocers.getSelectedGrocer().getName() , "Success", 1);
			}
			
		}
	}
	
	public class AddMoney implements ActionListener{
		
		JTextField money;
		
		public AddMoney(JTextField money) {
			this.money = money;
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			Client c = clients.getSelectedClient();
			if(c != null) {
				try {
					float money = Float.parseFloat(this.money.getText());
					c.addMoney(money);
					JOptionPane.showMessageDialog(null, money + "$ successfully added to " + 
							c.getName() + "'s balance by " + grocers.getSelectedGrocer().getName() , "Success", 1);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "The amount must be a valid number" , "Error", 0);
				}
			}
			
			
		}
	}
	
	public class RemoveMoney implements ActionListener{
		
		JTextField money;
		
		public RemoveMoney(JTextField money) {
			this.money = money;
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			Client c = clients.getSelectedClient();
			if(c != null) {
				try {
					float money = Float.parseFloat(this.money.getText());
					c.addMoney(-1.0f * money);
					JOptionPane.showMessageDialog(null, money + "$ successfully removed from " + 
							c.getName() + "'s balance by " + grocers.getSelectedGrocer().getName() , "Success", 1);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "The amount must be a valid number" , "Error", 0);
				}
			}
			
			
		}
	}
}
