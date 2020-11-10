package view.page;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.AccountController;
import controller.ProductController;
import model.data.Model;
import view.account.MoneyComponent;
import view.data.ModelListView;
import view.product.FavoriteProductComponent;

public class InformationPage extends JFrame{
	
	public InformationPage(Model accounts, AccountController accountController, 
			Model products, ProductController productController) {
		
		//Frame settings
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Information");
		
		//The content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new BorderLayout());
		
		//Label
		content.add(new JLabel("*Double click on item to view details"), BorderLayout.NORTH);
		
		//Panel for the center content
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		//Account list
		ModelListView accountView = new ModelListView(accounts, accountController, "Accounts");
		centerPanel.add(accountView);
		
		//Money component
		MoneyComponent mc = new MoneyComponent(accountController);
		centerPanel.add(mc);
		
		//Favorite product list
		FavoriteProductComponent fpv = new FavoriteProductComponent(products, productController, accountController);
		centerPanel.add(fpv);
		
		content.add(centerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
