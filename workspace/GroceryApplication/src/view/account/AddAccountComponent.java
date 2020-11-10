package view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.AccountController;
import controller.ProductController.AddFood;

public class AddAccountComponent extends JPanel{

	public AddAccountComponent(AccountController accountController) {
		
		//Panel settings
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel("Add account"), BorderLayout.NORTH);
		
		//The inputs
		JPanel inputs = new JPanel();
		inputs.setLayout(new FlowLayout());
		
		//Account type selector
		JRadioButton client = new JRadioButton("Client");
		client.setSelected(true);
		JRadioButton employee = new JRadioButton("Employee");
		JRadioButton director = new JRadioButton("Director");
		ButtonGroup bg = new ButtonGroup();
		bg.add(client);
		bg.add(employee);
		bg.add(director);
		JRadioButton [] rbs = new JRadioButton[3];
		rbs[0] = client;
		rbs[1] = employee;
		rbs[2] = director;
		inputs.add(rbs[0]);
		inputs.add(rbs[1]);
		inputs.add(rbs[2]);
		
		//FirstName input
		inputs.add( new JLabel("FirstName"));
		JTextField firstName = new JTextField();
		firstName.setPreferredSize(new Dimension(100,20));
		inputs.add(firstName);
		
		//LastName input
		inputs.add( new JLabel("LastName"));
		JTextField lastName = new JTextField();
		lastName.setPreferredSize(new Dimension(100,20));
		inputs.add(lastName);
		
		//Birth date input
		inputs.add( new JLabel("Birth date (yyyy/mm/jj)"));
		JTextField birthDay = new JTextField();
		birthDay.setPreferredSize(new Dimension(100,20));
		inputs.add(birthDay);

		this.add(inputs, BorderLayout.CENTER);
		
		//Add button
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(accountController.new Add(firstName, lastName, birthDay, rbs));
		
		this.add(addBtn, BorderLayout.SOUTH);
	}

}
