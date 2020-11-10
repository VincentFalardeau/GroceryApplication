package view.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.account.Directors;

public class DirectorListComponent extends JPanel {
	
	public DirectorListComponent(Directors directors) {
		
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel("Directors"), BorderLayout.NORTH);
		
		//Make the list from the model
		JList list = new JList(directors.toStringArray());
		list.setSelectedIndex(directors.getSelectedIndex());
		
		//To update the model on director selection
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				directors.setSelectedIndex(list.getSelectedIndex());
			}
					
		});
		
		JScrollPane sp = new JScrollPane(list);
		this.add(sp, BorderLayout.SOUTH);
	}
}
