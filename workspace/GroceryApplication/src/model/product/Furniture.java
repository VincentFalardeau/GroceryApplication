package model.product;

import model.data.IData;

//Vincent Falardeau
//20170932

public class Furniture extends Product{
	
	private String type;
	private float price;
	private float height;
	
	public Furniture(String directorName, String type, float price, float height){
		super(directorName);
		
		this.setType(type);
		this.setPrice(price);
		this.setHeight(height);
	}
	
	@Override
	public String toString() {
		return "Furniture, type: " + type + ", price: " + price + ", height: " + height + " - " + super.toString();
		
	}
	
	@Override
	public String getDetails() {
		return this.toString();
	}

	public String getType() {
		return type;
	}
	
	public String getName() {
		return type;
	}

	public void setType(String type) {
		if(type.length() > IData.MAX_INPUT_LEN) {
			this.type = type.substring(0, IData.MAX_INPUT_LEN);
		}
		else {
			this.type = type;
		}
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if(price < 0.0f) {
			this.price = 0.0f;
		}
		else if((int)price > IData.MAX_NUMBER) {
			this.price = IData.MAX_NUMBER;
		}
		else {
			this.price = price;
		}
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		if(height < 0.0f) {
			this.height = 0.0f;
		}
		else if((int)height > IData.MAX_NUMBER) {
			this.height = IData.MAX_NUMBER;
		}
		else {
			this.height = height;
		}
	}
}
