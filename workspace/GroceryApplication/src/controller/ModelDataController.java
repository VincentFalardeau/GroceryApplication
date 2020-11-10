package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exception.InputException;
import model.account.Client;
import model.account.Director;
import model.data.Model;
import model.product.Food;
import model.data.IData;

//Vincent Falardeau
//20170932

public class ModelDataController {
	
	Model modelData;
	
	public ModelDataController(Model modelData) {
		this.modelData = modelData;
	}
	
	//To set the model's selected index on selection
	public class Select implements ListSelectionListener{
		
		JList list;
		
		public Select(JList list) {
			this.list = list;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			modelData.setSelectedIndex(list.getSelectedIndex());
		}
	}
	
	//To view details on double click
	public class DetailsDoubleClick extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
		    	
			if (e.getClickCount() == 2) {
				viewDetails(); 
		    }
		}
	}
	
	//To view details on button click
	public class Details implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			viewDetails();  	
        }
	}
	
	//Displays the details of the selected item in a message dialog
	public void viewDetails() {
		IData n = modelData.getSelected();
    	
    	if(n != null) {
    		//Show a message dialog containing the selected item's information
			JOptionPane.showMessageDialog(null, n.getDetails(), "Details", 1);
    	}	
	}

	//To filter the model's items
	public class Filter implements ActionListener{
		
		private JTextField filter;
		
		public Filter(JTextField filter) {
			this.filter = filter;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			modelData.setFilter(filter.getText());
			
		}
	}
	
	//To delete the model's selected item
	public class Delete implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			modelData.deleteSelected();
			
		}
	}
}
