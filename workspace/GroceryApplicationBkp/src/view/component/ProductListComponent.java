package view.component;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.product.ProductController;
import model.product.Product;
import model.product.Products;

public class ProductListComponent extends JPanel{
	
	Products products;
	JList list;
	
	public ProductListComponent(Products products, ProductController productController) {
		
		this.products = products;
		products.addProductListComponent(this);
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel("Products"), BorderLayout.NORTH);
		
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
		
		//To view details on item double click
		list.addMouseListener(new MouseAdapter() {
			
		    public void mouseClicked(MouseEvent e) {
		    	
		        if (e.getClickCount() == 2) {
		        	
		        	Product p = products.getSelectedProduct();
		        	
		        	if(p != null) {
		        		//Show a message dialog containing the selected product's information
						JOptionPane.showMessageDialog(null, p.toString(), "Details", 1);
		        	}		        	
		        }
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
