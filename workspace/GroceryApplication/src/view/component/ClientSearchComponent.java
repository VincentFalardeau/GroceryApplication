package view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.account.ClientController;
import model.account.Clients;

public class ClientSearchComponent extends JPanel{
	
	Clients clients;

	public ClientSearchComponent(Clients clients, ClientController clientController) {
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel("Search"), BorderLayout.NORTH);
		
		//Filter input
		JTextField filter = new JTextField();
		filter.setPreferredSize(new Dimension(100,20));
		this.add(filter, BorderLayout.CENTER);
		
//		//Search button
//		JButton searchBtn = new JButton("Search");
//		searchBtn.addActionListener(clientController.new Search(filter.getText()));
//		this.add(searchBtn, BorderLayout.SOUTH);
////		
//		JList resultList = new JList(clients.toStringArray());
//		list.setSelectedIndex(clients.getSelectedIndex());
	}
	
	
}
