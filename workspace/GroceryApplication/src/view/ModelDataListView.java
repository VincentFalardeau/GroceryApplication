package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ModelDataController;
import model.data.ModelData;

public class ModelDataListView extends JPanel implements Updatable, IDataList {
	
	ModelData modelData;
	JList list;
	
	public ModelDataListView(ModelData modelData, ModelDataController modelDataController) {
		modelData.addView(this);
		
		this.modelData = modelData;
		this.setLayout(new BorderLayout());
		
		//Make the list from the model
		list = new JList(modelData.toStringArray());
		list.setSelectedIndex(modelData.getSelectedIndex());
				
		//To update the model on selection
		list.addListSelectionListener(modelDataController.new Select(list));
				
		//To view details on item double click
		list.addMouseListener(modelDataController.new Details());

		JScrollPane sp = new JScrollPane(list);
		this.add(sp, BorderLayout.CENTER);
				
		//Filter panel
		JPanel filterPanel = new JPanel();
		filterPanel.setLayout(new FlowLayout());
			
		//Filter input
		JTextField filter = new JTextField();
		filter.setPreferredSize(new Dimension(100,20));
		filterPanel.add(filter);
		
		//Filter button
		JButton filterBtn = new JButton("Filter");
		filterBtn.addActionListener(modelDataController.new Filter(filter));
		filterPanel.add(filterBtn);
				
		this.add(filterPanel, BorderLayout.SOUTH);
	}

	@Override
	public void update() {
		//Update the list
		DefaultListModel dlm = new DefaultListModel();
		int i = 0;
		for(String str : modelData.toStringArray()) {
			dlm.add(i,str);
			i++;
		}
		list.setModel(dlm);
	}

	@Override
	public void updateSelectedIndex() {
		list.setSelectedIndex(modelData.getSelectedIndex());
		
	}
}
