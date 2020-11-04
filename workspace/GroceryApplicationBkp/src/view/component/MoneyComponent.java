package view.component;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.account.ClientController;
import controller.account.ClientController.AddMoney;
import controller.account.ClientController.RemoveMoney;

public class MoneyComponent extends JPanel{
	
	public MoneyComponent(ClientController clientController) {
				
		//Money field
		this.add(new JLabel("Add/Remove money"));
		JTextField money = new JTextField();
		money.setPreferredSize(new Dimension(100,20));
		this.add(money);
				
		//Add button
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(clientController.new AddMoney(money));
		
		//Remove button
		JButton removeBtn = new JButton("Remove");
		removeBtn.addActionListener(clientController.new RemoveMoney(money));
				
		this.add(addBtn);
		this.add(removeBtn);
	}

}
