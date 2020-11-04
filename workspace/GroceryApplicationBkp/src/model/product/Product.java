package model.product;

public abstract class Product{
	
	private String directorName;
	
	public Product(String directorName) {
		this.setDirectorName(directorName);
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
	@Override
	public String toString() {
		return "Added by director: " + directorName;
	}

	
	
}
