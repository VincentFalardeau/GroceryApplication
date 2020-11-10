package view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.product.ProductController;

public class AddFoodComponent extends JPanel {

	public AddFoodComponent(ProductController productController) {
		this.setLayout(new BorderLayout());
		
		//Label
		this.add(new JLabel("Add food"), BorderLayout.NORTH);
		
		//The inputs
		JPanel inputs = new JPanel();
		inputs.setLayout(new FlowLayout());
		
		//Name field
		inputs.add( new JLabel("Name"));
		JTextField name = new JTextField();
		name.setPreferredSize(new Dimension(100,20));
		inputs.add(name);
		
		//Color field
		inputs.add( new JLabel("Color"));
		JTextField color = new JTextField();
		color.setPreferredSize(new Dimension(100,20));
		inputs.add(color);
				
		//Weight field
		inputs.add( new JLabel("Weight"));
		JTextField weight = new JTextField();
		weight.setPreferredSize(new Dimension(100,20));
		inputs.add(weight);

		this.add(inputs, BorderLayout.CENTER);
		
		//Add button
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(productController.new AddFood(name, color, weight));
		
		this.add(addBtn, BorderLayout.SOUTH);
	}
}
