package view.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.account.GrocerController;
import controller.account.ClientController.Details;
import model.account.Grocers;

public class GrocerListComponent extends JPanel{


	public GrocerListComponent(Grocers grocers, GrocerController grocerController) {
		
		this.setLayout(new BorderLayout());

		
		//Label
		this.add(new JLabel("Grocers"), BorderLayout.NORTH);
		
		//Make the list from the model
		JList list = new JList(grocers.toStringArray());
		
		list.setSelectedIndex(grocers.getSelectedIndex());
		
		//To update the model on grocer selection
		list.addListSelectionListener(grocerController.new Select(list));
		
		//To view details on item double click
		list.addMouseListener(grocerController.new Details());
		
		JScrollPane sp = new JScrollPane(list);
		this.add(sp, BorderLayout.SOUTH);
	}

}
