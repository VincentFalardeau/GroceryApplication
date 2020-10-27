package model.product;

public class Furniture extends Product{
	
	private String type;
	private float price;
	private float height;
	
	public Furniture(String directorName, String type, float price, float height) {
		super(directorName);
		
		this.setType(type);
		this.setPrice(price);
		this.setHeight(height);
	}
	
	@Override
	public String toString() {
		return super.toString() + "Furniture, type: " + type + ", price: " + price + ", height: " + height;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
}
