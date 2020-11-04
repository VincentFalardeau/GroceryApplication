package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exception.InputException;
import model.account.Client;
import model.data.IData;
import model.data.ModelData;
import model.product.Food;

public class AccountController extends ModelDataController {
	
		//Models
		private ModelData accounts;
		
		public AccountController(ModelData accounts) {
			super(accounts);
			this.accounts = super.modelData;
		}
		
		public class Add implements ActionListener{
			
			private JTextField firstName;
			private JTextField lastName;
			private JTextField birthDate;
			
			public Add(JTextField firstName, JTextField lastName, JTextField birthDate) {
				this.firstName = firstName;
				this.lastName = lastName;
				this.birthDate = birthDate;
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
					
					accounts.add(new Client(firstName, lastName, birthDate));

				} catch(IllegalArgumentException iae) {
					
					//Show a message dialog if weight is not a valid number
					JOptionPane.showMessageDialog(null, "Please enter a valid date", "Error", 0);
					
				} catch(InputException ie) {
					
					//Show a message dialog if any input exception is thrown
					JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", 0);
				}
			}
		}
}
