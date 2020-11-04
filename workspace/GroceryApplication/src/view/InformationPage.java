package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.AccountController;
import controller.ModelDataController;
import controller.ProductController;
import model.data.ModelData;
import view.account.MoneyComponent;
import view.product.FavoriteProductView;




public class InformationPage extends JFrame{
	
	public InformationPage(ModelData accounts, AccountController accountController, ModelData products,
			ProductController productController) {
		
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Information");
		
		//The content panel
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new BorderLayout());
		
		//Label
		content.add(new JLabel("*Double click on item to view details"), BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		//Account list
		ModelDataListView accountView = new ModelDataListView(accounts, accountController, "Accounts");
		centerPanel.add(accountView);
		
		//Money
		MoneyComponent mc = new MoneyComponent(accountController);
		centerPanel.add(mc);
		
		//Favorite product list
		FavoriteProductView fpv = new FavoriteProductView(products, productController, accountController);
		centerPanel.add(fpv);
		
		content.add(centerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
