package view.data;

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
import model.data.Model;

public class ModelListView extends JPanel implements IDataView {
	
	Model modelData;
	JList list;
	
	public ModelListView(Model modelData, ModelDataController modelDataController, String title) {
		
		//this is a view displaying the model data.
		modelData.addView(this);
		
		//Panel settings
		this.modelData = modelData;
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel(title), BorderLayout.NORTH);
		
		//Make the list from the model
		list = new JList(modelData.toStringArray());
		list.setSelectedIndex(modelData.getSelectedIndex());
				
		//To update the model on selection
		list.addListSelectionListener(modelDataController.new Select(list));
				
		//To view details on item double click
		list.addMouseListener(modelDataController.new DetailsDoubleClick());

		JScrollPane sp = new JScrollPane(list);
		this.add(sp, BorderLayout.CENTER);
				
		//Filter panel
		JPanel filterPanel = new JPanel();
		filterPanel.setLayout(new FlowLayout());
		
		//Details button
		JButton detailsBtn = new JButton("Details");
		detailsBtn.addActionListener(modelDataController.new Details());
		filterPanel.add(detailsBtn);
			
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

	//Responsible for updating the list's content with the model
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

	//Responsible for setting the selected index to the model's selected index
	@Override
	public void updateSelectedIndex() {
		list.setSelectedIndex(modelData.getSelectedIndex());
		
	}
}
