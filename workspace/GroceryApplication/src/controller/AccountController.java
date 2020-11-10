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
import model.data.Model;
import model.product.Food;
import model.product.Product;

public class AccountController extends ModelDataController {
	
		//Models
		private Model accounts;
		private Model products;
		
		public AccountController(Model accounts, Model products) {
			super(accounts);
			this.products = products;
			this.accounts = super.modelData;
		}
		
		//To add an account
		public class Add implements ActionListener{
			
			private JTextField firstName;
			private JTextField lastName;
			private JTextField birthDate;
			private JRadioButton[] accountType;
			
			public Add(JTextField firstName, JTextField lastName, JTextField birthDate, JRadioButton[] accountType) {
				this.firstName = firstName;
				this.lastName = lastName;
				this.birthDate = birthDate;
				this.accountType = accountType;
			}
			
			@Override
			public void actionPerformed(ActionEvent e){			
				
				try {
					
					//Get and validate the firstName
					String firstName = this.firstName.getText();
					if(firstName.isEmpty()) {
						throw new InputException("Please specify a firstName");
					}
					
					//Get and validate the lastName
					String lastName = this.lastName.getText();
					if(lastName.isEmpty()) {
						throw new InputException("Please specify a lastName");
					}
					
					//Get the birthDate
					Date birthDate = new Date(this.birthDate.getText());
					
					//Add an account according to the selected account type
					if(accountType[0].isSelected()) {
						accounts.add(new Client(firstName, lastName, birthDate));
					}
					else if(accountType[1].isSelected()) {
						accounts.add(new Employee(firstName, lastName, birthDate));
					}
					else if(accountType[2].isSelected()) {
						accounts.add(new Director(firstName, lastName, birthDate));
					}
					
				//In case the given birth date is invalid
				} catch(IllegalArgumentException iae) {
					
					JOptionPane.showMessageDialog(null, "Please enter a valid date", "Error", 0);
				
				//If any other input exception occurs
				} catch(InputException ie) {
					
					JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
				}
			}
		}
		
		//To add a favorite product to the selected account
		public class AddFavorite implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Get the selected account and product
					Account a = (Account) accounts.getSelected();
					Product p = (Product) products.getSelected();
					
					//Validate them
					if(a == null) {
						throw new InputException("Please select an account");
					}
					else if(p == null) {
						throw new InputException("Please select a product");
					}
					
					//Add the product to the account's favorites
					a.addFavoriteProduct(p);
					JOptionPane.showMessageDialog(null,p.getName() + " successfully added to " + a.getName() + "'s favorites" , "Success", 1);
					
				} catch(InputException ie) {
					
					JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
				}	
			}

		}
		
		//To remove a product from the selected account's favorites
		public class RemoveFavorite implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					//Get the selected account and product
					Account a = (Account) accounts.getSelected();
					Product p = (Product) products.getSelected();
					
					//Validate them
					if(a == null) {
						throw new InputException("Please select an account");
					}
					else if(p == null) {
						throw new InputException("Please select a product");
					}
					
					//Remove the product from the account's favorites
					a.removeFavoriteProduct(p);
					JOptionPane.showMessageDialog(null,p.getName() + " successfully removed from " + a.getName() + "'s favorites" , "Success", 1);
					
				} catch(InputException ie) {
					
					JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
				}	
			}
		}
		
		//To add money to the selected account
		public class AddMoney implements ActionListener{
			
			private JTextField money;
			
			public AddMoney( JTextField money) {
				this.money = money;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Get the selected account and validate it
					Account a = (Account) accounts.getSelected();
					if(a == null) {
						throw new InputException("Please select an account");
					}
					
					//Get the money and validate it
					float money =  Float.parseFloat(this.money.getText());
					if(money < 0) {
						throw new InputException("Money must be above 0");
					}
					
					//Add the money
					a.addMoney(money);
					JOptionPane.showMessageDialog(null, money + "$ successfully added to " + a.getName() + "'s balance" , "Success", 1);

				//If the amount is not a valid number
				} catch(NumberFormatException nfe) {
					
					JOptionPane.showMessageDialog(null, "Money must be a valid number", "Error", 0);
					
				} catch(InputException ie) {
					
					JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
				}
			}
		}
		
		//To remove money from the selected account
		public class RemoveMoney implements ActionListener{

			private JTextField money;
			
			public RemoveMoney( JTextField money) {
				this.money = money;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Get the selected account and validate it
					Account a = (Account) accounts.getSelected();
					if(a == null) {
						throw new InputException("Please select an account");
					}
					
					//Make sure it is not a client, we can't remove money from a client
					if(a instanceof Client) {
						throw new InputException("Cannot remove money from a client");
					}
					
					//Get the money and validate it
					float money =  Float.parseFloat(this.money.getText());
					if(money < 0) {
						throw new InputException("Money must be above 0");
					}
					
					//Add the money
					a.addMoney(-1.0f * money);
					JOptionPane.showMessageDialog(null, money + "$ successfully removed from " + a.getName() + "'s balance" , "Success", 1);

				//If the amount is not a valid number
				} catch(NumberFormatException nfe) {
					
					JOptionPane.showMessageDialog(null, "Money must be a valid number", "Error", 0);
					
				} catch(InputException ie) {
					
					JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
				}
			}
			

		}
}
