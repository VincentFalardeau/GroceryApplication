package view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.account.ClientController;
import model.account.Client;
import model.account.Clients;
import model.account.Directors;
import model.product.Product;

public class ClientListComponent extends JPanel{
	
	Clients clients;
	JList list;
	
	public ClientListComponent(Clients clients, ClientController clientController) {
		
		this.clients = clients;
		clients.setClientListComponent(this);
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel("Clients"), BorderLayout.NORTH);
		
		//Make the list from the model
		list = new JList(clients.toStringArray());
		list.setSelectedIndex(clients.getSelectedIndex());
		
		//To update the model on director selection
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				clients.setSelectedIndex(list.getSelectedIndex());
			}
					
		});
		
		//To view details on item double click
		list.addMouseListener(new MouseAdapter() {
			
		    public void mouseClicked(MouseEvent e) {
		    	
		        if (e.getClickCount() == 2) {
		        	
		        	Client c = clients.getSelectedClient();
		        	
		        	if(c != null) {
		        		//Show a message dialog containing the selected product's information
						JOptionPane.showMessageDialog(null, c.toString(), "Details", 1);
		        	}		        	
		        }
		    }
		});

		JScrollPane sp = new JScrollPane(list);
		this.add(sp, BorderLayout.CENTER);
		
		//Filter panel
		JPanel filterPanel = new JPanel();
		filterPanel.setLayout(new FlowLayout());
		
		//Filter field
		filterPanel.add(new JLabel("Filter"));
		JTextField filter = new JTextField();
		filter.setPreferredSize(new Dimension(100,20));
		filterPanel.add(filter);
		
		//Filter button
		JButton filterBtn = new JButton("filter");
		filterBtn.addActionListener(clientController.new Filter(filter));
		
		filterPanel.add(filterBtn);
		
		this.add(filterPanel, BorderLayout.SOUTH);
	}
	
	public void update() {
		//Update the product list
		DefaultListModel dlm = new DefaultListModel();
		int i = 0;
		for(String str : clients.toStringArray()) {
			dlm.add(i,str);
			i++;
		}
		list.setModel(dlm);
	}
}
