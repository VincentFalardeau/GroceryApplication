package model.product;

import model.data.IData;

//Vincent Falardeau
//20170932

public class Food extends Product{
	
	private String name;
	private String color;
	private float weight;
	
	public Food(String directorName, String name, String color, float weight) {
		super(directorName);
		
		this.setName(name);
		this.setColor(color);
		this.setWeight(weight);
	}
	
	@Override
	public String toString() {
		return "Food, name: " + name + ", color: " + color + ", weight: " + weight + " " + super.toString();
		
	}
	
	@Override
	public String getDetails() {
		return this.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		if(name.length() > IData.MAX_INPUT_LEN) {
			this.name = name.substring(0, IData.MAX_INPUT_LEN);
		}
		else {
			this.name = name;
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		
		if(color.length() > IData.MAX_INPUT_LEN) {
			this.color = color.substring(0, IData.MAX_INPUT_LEN);
		}
		else {
			this.color = color;
		}
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
		if(weight < 0.0f) {
			this.weight = 0.0f;
		}
		else if((int)weight > IData.MAX_NUMBER) {
			this.weight = IData.MAX_NUMBER;
		}
		
	}
}
