package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import exception.InputException;
import model.account.Account;
import model.account.Client;
import model.account.Director;
import model.account.Employee;
import model.data.IData;
import model.data.ModelData;
import model.product.Food;
import model.product.Product;

public class AccountController extends ModelDataController {
	
		//Models
		private ModelData accounts;
		private ModelData products;
		
		public AccountController(ModelData accounts, ModelData products) {
			super(accounts);
			this.products = products;
			this.accounts = super.modelData;
		}
		
		public class Add implements ActionListener{
			
			private JTextField firstName;
			private JTextField lastName;
			private JTextField birthDate;
			private JRadioButton[] rbs;
			
			public Add(JTextField firstName, JTextField lastName, JTextField birthDate, JRadioButton[] rbs) {
				this.firstName = firstName;
				this.lastName = lastName;
				this.birthDate = birthDate;
				this.rbs = rbs;
			}
			
			@Override
			public void actionPerformed(ActionEvent e){			
				
				try {
					
					String firstName = this.firstName.getText();
					if(firstName.isEmpty()) {
						throw new InputException("Please specify a firstName");
					}
					
					String lastName = this.lastName.getText();
					if(lastName.isEmpty()) {
						throw new InputException("Please specify a lastName");
					}
					Date birthDate = new Date(this.birthDate.getText());
					
					if(rbs[0].isSelected()) {
						accounts.add(new Client(firstName, lastName, birthDate));
					}
					else if(rbs[1].isSelected()) {
						accounts.add(new Employee(firstName, lastName, birthDate));
					}
					else if(rbs[2].isSelected()) {
						accounts.add(new Director(firstName, lastName, birthDate));
					}

				} catch(IllegalArgumentException iae) {
					
					//Show a message dialog if weight is not a valid number
					JOptionPane.showMessageDialog(null, "Please enter a valid date", "Error", 0);
					
				} catch(InputException ie) {
					
					//Show a message dialog if any input exception is thrown
					JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
				}
			}
		}
		
		public class AddFavorite implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				Account a = (Account) accounts.getSelected();
				Product p = (Product) products.getSelected();
				if(p != null && a != null) {
					a.addFavoriteProduct(p);
					JOptionPane.showMessageDialog(null,p.getName() + " successfully added to " + a.getName() + "'s favorites" , "Success", 1);
				}
				else if(a == null) {
					JOptionPane.showMessageDialog(null, "Please select an account", "Error", 0);
				}
				else if(p == null) {
					JOptionPane.showMessageDialog(null, "Please select a product", "Error", 0);
				}
				
			}
			

		}
		
		public class RemoveFavorite implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				Account a = (Account) accounts.getSelected();
				Product p = (Product) products.getSelected();
				if(p != null && a != null) {
					a.removeFavoriteProduct(p);
					JOptionPane.showMessageDialog(null,p.getName() + " successfully removed from " + a.getName() + "'s favorites" , "Success", 1);
				}
				else if(a == null) {
					JOptionPane.showMessageDialog(null, "Please select an account", "Error", 0);
				}
				else if(p == null) {
					JOptionPane.showMessageDialog(null, "Please select a product", "Error", 0);
				}
				
			}
			

		}
		
		public class AddMoney implements ActionListener{
			
			private JTextField money;
			
			public AddMoney( JTextField money) {
				this.money = money;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Get the selected account
					Account a = (Account) accounts.getSelected();
					if(a == null) {
						throw new InputException("Please select an account");
					}
					
					float money =  Float.parseFloat(this.money.getText());
					
					if(money < 0) {
						throw new InputException("Money must be above 0");
					}
					
					a.addMoney(money);
					
					JOptionPane.showMessageDialog(null, money + "$ successfully added to " + a.getName() + "'s balance" , "Success", 1);

				} catch(NumberFormatException nfe) {
					
					//Show a message dialog if money is not a valid number
					JOptionPane.showMessageDialog(null, "Money must be a valid number", "Error", 0);
					
				} catch(InputException ie) {
					
					//Show a message dialog if any input exception is thrown
					JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
				}
			}
			

		}
		
		public class RemoveMoney implements ActionListener{

			private JTextField money;
			
			public RemoveMoney( JTextField money) {
				this.money = money;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Get the selected account
					Account a = (Account) accounts.getSelected();
					if(a == null) {
						throw new InputException("Please select an account");
					}
					if(a instanceof Client) {
						throw new InputException("Clients cannot remove money");
					}
					
					float money =  Float.parseFloat(this.money.getText());
					
					if(money < 0) {
						throw new InputException("Money must be above 0");
					}
					
					a.addMoney(-1.0f * money);
					
					JOptionPane.showMessageDialog(null, money + "$ successfully removed from " + a.getName() + "'s balance" , "Success", 1);


				} catch(NumberFormatException nfe) {
					
					//Show a message dialog if money is not a valid number
					JOptionPane.showMessageDialog(null, "Money must be a valid number", "Error", 0);
					
				} catch(InputException ie) {
					
					//Show a message dialog if any input exception is thrown
					JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
				}
			}
			

		}
}