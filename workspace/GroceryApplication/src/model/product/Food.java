package model.product;

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
		return super.toString() + " - Food, name: " + name + ", color: " + color + ", weight: " + weight;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
}
