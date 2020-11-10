package model.account;

import java.util.ArrayList;

public class Grocers {
	private ArrayList<Grocer> grocers;
	private int selectedIndex;
	
	public Grocers() {
		grocers = new ArrayList<Grocer>();
	}

	public void add(Grocer grocer) {
		grocers.add(grocer);
	}
	
	public String[] toStringArray() {
		
		String[] array = new String[grocers.size()];
		
		int i = 0;
		for(Grocer d : grocers) {
			array[i] = d.toString();
			i++;
		}
		
		return array;
	}

	
	public ArrayList<Grocer> getGrocers() {
		return grocers;
	}

	public void setGrocers(ArrayList<Grocer> grocers) {
		this.grocers = grocers;
	}

	public int getSelectedIndex() {
		if(selectedIndex < 0) {
			return 0;//return 0 by default
		}
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	//Gives the selected grocer object
	public Grocer getSelectedGrocer() {
		if(selectedIndex < 0) {
			return null;
		}
		return grocers.get(selectedIndex);
	}
	
}
