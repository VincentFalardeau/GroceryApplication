package view.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.account.Directors;

public class DirectorListComponent extends JPanel {
	
	public DirectorListComponent(Directors directors) {
		
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel("Choose director"), BorderLayout.NORTH);
		
		//Make the list from the model
		JList list = new JList(directors.toStringArray());
		list.setSelectedIndex(0);
		JScrollPane sp = new JScrollPane(list);
		this.add(sp, BorderLayout.SOUTH);
	}
}
