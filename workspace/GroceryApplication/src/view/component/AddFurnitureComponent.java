package view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.product.ProductController;
import controller.product.ProductController.AddFood;

public class AddFurnitureComponent extends JPanel{
	
	public AddFurnitureComponent(ProductController productController) {
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel("Add furniture"), BorderLayout.NORTH);
		
		//The inputs
		JPanel inputs = new JPanel();
		inputs.setLayout(new FlowLayout());
		
		//Type field
		inputs.add( new JLabel("Type"));
		JTextField type = new JTextField();
		type.setPreferredSize(new Dimension(100,20));
		inputs.add(type);
		
		//Price field
		inputs.add( new JLabel("Price"));
		JTextField price = new JTextField();
		price.setPreferredSize(new Dimension(100,20));
		inputs.add(price);
				
		//Height field
		inputs.add( new JLabel("Height"));
		JTextField height = new JTextField();
		height.setPreferredSize(new Dimension(100,20));
		inputs.add(height);

		this.add(inputs, BorderLayout.CENTER);
		
		//Add button
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(productController.new AddFurniture(type, price, height));
		
		this.add(addBtn, BorderLayout.SOUTH);
	}
}
