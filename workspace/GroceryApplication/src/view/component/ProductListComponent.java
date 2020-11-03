package view.component;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.product.Products;

public class ProductListComponent extends JPanel{
	
	Products products;
	JList list;
	
	public ProductListComponent(Products products) {
		
		this.products = products;
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel("Choose product"), BorderLayout.NORTH);
		
		//Make the list from the model
		list = new JList(products.toStringArray());
		list.setSelectedIndex(products.getSelectedIndex());
		
		//To update the model on product selection
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				products.setSelectedIndex(list.getSelectedIndex());
			}
			
		});
		
		JScrollPane sp = new JScrollPane(list);
		this.add(sp, BorderLayout.SOUTH);
	}
	
	public void update() {
		
		//Update the product list
		DefaultListModel dlm = new DefaultListModel();
		int i = 0;
		for(String str : products.toStringArray()) {
			dlm.add(i,str);
			i++;
		}
		list.setModel(dlm);
	}
}
