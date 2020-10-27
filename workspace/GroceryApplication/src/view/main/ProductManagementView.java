package view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.account.DirectorController;
import controller.product.ProductController;
import model.account.Director;
import model.data.Directors;
import model.data.AvailableProducts;
import model.product.Product;

public class ProductManagementView {
	
	private JFrame frame;
	private JPanel content;
	private JPanel directorPanel;
	private JPanel productPanel;
	private JPanel addFoodPanel;
	private JPanel addFoodPanelFields;
	private JList directorList;
	private JList productList;
	private JScrollPane directorScrollPane;
	private JScrollPane productScrollPane;
	private JButton deleteButton;
	private JButton addFoodButton;
	private JTextField foodName;
	private JTextField foodColor;
	private JTextField foodWeight;
	
	
	
	public ProductManagementView(Directors directors, DirectorController directorController, AvailableProducts products, ProductController productController) {
		
		frame = new JFrame();
		frame.setSize(1200, 800);
		
		content = (JPanel)frame.getContentPane();
		content.setLayout(new FlowLayout());
		
		if(directors.getDirectors().size() > 0) {
			//Director panel
			directorPanel = new JPanel();
			directorPanel.setLayout(new BorderLayout());
			//Label
			JLabel label1 = new JLabel("Choose director");
			directorPanel.add(label1, BorderLayout.NORTH);
			//Director selector
			directorList = new JList(directors.toStringArray());
			directorList.setSelectedIndex(0);
			directorScrollPane = new JScrollPane(directorList);
			directorPanel.add(directorScrollPane, BorderLayout.SOUTH);
			//Add director panel to frame
			content.add(directorPanel);
		}
		
		//Product panel
		productPanel = new JPanel();
		productPanel.setLayout(new BorderLayout());
		//Label
		JLabel label2 = new JLabel("Choose product");
		productPanel.add(label2, BorderLayout.NORTH);
		//Product selector
		productList = new JList(products.toStringArray());
		productScrollPane = new JScrollPane(productList);
		productPanel.add(productScrollPane, BorderLayout.CENTER);
		//Delete button
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(productController.new Delete(productList));
		productPanel.add(deleteButton, BorderLayout.SOUTH);
		//Add product panel to frame
		content.add(productPanel);
		
		//Add food panel
		addFoodPanel = new JPanel();
		addFoodPanel.setLayout(new BorderLayout());
		//Label
		JLabel label3 = new JLabel("Add food");
		addFoodPanel.add(label3, BorderLayout.NORTH);
		//Food field panel
		addFoodPanelFields = new JPanel();
		addFoodPanelFields.setLayout(new FlowLayout());
		
		
		label3 = new JLabel("Name");
		addFoodPanelFields.add(label3);
		foodName = new JTextField();
		foodName.setPreferredSize(new Dimension(100,20));
		addFoodPanelFields.add(foodName);
		
		label3 = new JLabel("Color");
		addFoodPanelFields.add(label3);
		foodColor = new JTextField();
		foodColor.setPreferredSize(new Dimension(100,20));
		addFoodPanelFields.add(foodColor);
		
		label3 = new JLabel("Weight");
		addFoodPanelFields.add(label3);
		foodWeight = new JTextField();
		foodWeight.setPreferredSize(new Dimension(100,20));
		addFoodPanelFields.add(foodWeight);
		
		addFoodPanel.add(addFoodPanelFields, BorderLayout.CENTER);
		//Add food button
		addFoodButton = new JButton("Add");
		addFoodButton.addActionListener(productController.new Add(productList, directorList, directors, foodName, foodColor, foodWeight));
		addFoodPanel.add(addFoodButton, BorderLayout.SOUTH);
		//Add product panel to frame
		content.add(addFoodPanel);
		
		//JFormattedTextField(2424.50);
	   // input.setValue(2424.50);
	    //input.setColumns(20);
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
