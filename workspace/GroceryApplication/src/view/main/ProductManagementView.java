package view.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	private JList directorList;
	private JList productList;
	private JScrollPane directorScrollPane;
	private JScrollPane productScrollPane;
	
	
	public ProductManagementView(Directors directors, DirectorController directorController, AvailableProducts products, ProductController productController) {
		
		frame = new JFrame();
		frame.setSize(1200, 800);
		
		content = (JPanel)frame.getContentPane();
		content.setLayout(new FlowLayout());
		
		
		//Director panel
		directorPanel = new JPanel();
		directorPanel.setLayout(new BorderLayout());
		//Label
		JLabel label1 = new JLabel("Choose director");
		directorPanel.add(label1, BorderLayout.NORTH);
		//Director selector
		directorList = new JList(directors.toStringArray());
		directorScrollPane = new JScrollPane(directorList);
		directorPanel.add(directorScrollPane, BorderLayout.SOUTH);
		//Add director panel to frame
		content.add(directorPanel);
		
		//Product panel
		productPanel = new JPanel();
		productPanel.setLayout(new BorderLayout());
		//Label
		JLabel label2 = new JLabel("Choose product");
		productPanel.add(label2, BorderLayout.NORTH);
		//Product selector
		productList = new JList(products.toStringArray());
		productScrollPane = new JScrollPane(productList);
		productPanel.add(productScrollPane, BorderLayout.SOUTH);
		//Add product panel to frame
		content.add(productPanel);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
