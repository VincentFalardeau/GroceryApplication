package controller.account;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.account.Client;
import model.account.Grocer;
import model.account.Grocers;

public class GrocerController {
	
	Grocers grocers;

	public GrocerController(Grocers grocers) {
		this.grocers = grocers;
	}
	
	public class Select implements ListSelectionListener{
		
		JList list;
		
		public Select(JList list) {
			this.list = list;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			grocers.setSelectedIndex(list.getSelectedIndex());
		}
	}
	
	public class Details extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
		    	
			if (e.getClickCount() == 2) {
		        	
				Grocer g = grocers.getSelectedGrocer();
		        	
		        	if(g != null) {
		        		//Show a message dialog containing the selected product's information
						JOptionPane.showMessageDialog(null, g.toString(), "Details", 1);
		        	}		        	
		        }
		    }	
		
	}

}
