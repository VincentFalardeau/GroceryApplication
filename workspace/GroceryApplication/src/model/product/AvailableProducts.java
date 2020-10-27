package model.product;

//Class responsible for managing the available products.
public class AvailableProducts {
	
	public static Product[] availableProducts;
	
	//Converts the availableProducts array to a String array giving information about the products.
	public static String[] toStringArray() {
		
		//The String array.
		String [] array = new String[availableProducts.length];
		
		int i = 0;
		for(Product p : availableProducts) {
			
			//Convert to String depending on the type of product.
			if(p instanceof Food) {
				Food f = (Food)p;
				array[i] = f.toString();
			}
			else if(p instanceof Furniture) {
				Furniture f = (Furniture)p;
				array[i] = f.toString();
			}
			
			i++;
		}
		
		return array;
	}
}
