package view.product;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AccountController;
import controller.ProductController;
import controller.ProductController.AddFood;

public class MoneyComponent extends JPanel{
	
	public MoneyComponent(AccountController accountController) {
		
		this.setLayout(new FlowLayout());
		
		//Label
		this.add(new JLabel("Money"));

		//Money field
		JTextField money = new JTextField();
		money.setPreferredSize(new Dimension(100,20));
		this.add(money);

		//Add button
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(accountController.new AddMoney(money));
		this.add(addBtn);
		
		//Remove button
		JButton removeBtn = new JButton("Remove");
		removeBtn.addActionListener(accountController.new RemoveMoney(money));
		this.add(removeBtn);

	}
}
