package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ModelDataController;
import model.data.ModelData;



public class InformationPage extends JFrame{
	
	public InformationPage(ModelData accounts) {
		
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Information");
		
		//The content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new BorderLayout());
		
		//Label
		content.add(new JLabel("*Double click on item to view details"), BorderLayout.NORTH);
		
		//Add views
		ModelDataController accountsController = new ModelDataController(accounts);
		ModelDataListView accountView = new ModelDataListView(accounts, accountsController, "Accounts");
		content.add(accountView, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
