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
	
	public ProductManagementView(Directors directors, AvailableProducts products, ProductController productController) {
		
		//Initiate frame
		frame = new JFrame();
		frame.setSize(1200, 800);
		
		//Retreive its content panel
		content = (JPanel)frame.getContentPane();
		content.setLayout(new FlowLayout());
		
		//Add panels to the content panel
		addDirectorPanel(directors, content);
		addProductPanel(products, productController, content);
		addFoodPanel(productController, content);		
	
		//Display the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Procedure responsible for adding a list of director to the specified panel
	 * @param directors, the model, containing a list of director
	 * @param panel, the panel in question
	 */
	private void addDirectorPanel(Directors directors, JPanel panel) {
		
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
		
		//Add director panel to panel
		panel.add(directorPanel);
	}
	
	private void addProductPanel(AvailableProducts products, ProductController productController, JPanel panel) {
		
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
		
		//Add product panel to panel
		panel.add(productPanel);
	}
	
	private void addFoodPanel(ProductController productController, JPanel panel) {
		
		//Add food panel
		addFoodPanel = new JPanel();
		addFoodPanel.setLayout(new BorderLayout());
		
		//Label
		JLabel label3 = new JLabel("Add food");
		addFoodPanel.add(label3, BorderLayout.NORTH);
		
		//Food field panel
		addFoodPanelFields = new JPanel();
		addFoodPanelFields.setLayout(new FlowLayout());
				
		//Name field
		foodName = new JTextField();
		addTextInputField("Name", foodName, addFoodPanelFields);
		
		//Color field
		foodColor = new JTextField();
		addTextInputField("Color", foodColor, addFoodPanelFields);
				
		//Weight field
		foodWeight = new JTextField();
		addTextInputField("Weight", foodWeight, addFoodPanelFields);
				
		//Add fields to fields panel
		addFoodPanel.add(addFoodPanelFields, BorderLayout.CENTER);
		
		//Add button
		addFoodButton = new JButton("Add");
		addFoodButton.addActionListener(productController.new Add(productList, directorList, foodName, foodColor, foodWeight));
		addFoodPanel.add(addFoodButton, BorderLayout.SOUTH);
		
		//Add food panel to panel
		panel.add(addFoodPanel);
	}
	
	private void addTextInputField(String name, JTextField field, JPanel panel) {
		JLabel label = new JLabel(name);
		panel.add(label);
		field.setPreferredSize(new Dimension(100, 20));
		panel.add(field);
	}
}
