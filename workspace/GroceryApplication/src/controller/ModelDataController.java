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
import model.data.ModelData;
import model.product.Food;
import model.data.IData;

public class ModelDataController {
	
	ModelData modelData;
	
	public ModelDataController(ModelData modelData) {
		this.modelData = modelData;
	}
	
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
	
	
	
	public class Details extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
		    	
			if (e.getClickCount() == 2) {
		        	
				IData n = modelData.getSelected();
		        	
		        	if(n != null) {
		        		//Show a message dialog containing the selected item's information
						JOptionPane.showMessageDialog(null, n.getDetails(), "Details", 1);
		        	}		        	
		        }
		    }	
		
	}

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
	
	public class Delete implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			modelData.deleteSelected();
			
		}
	}
}
