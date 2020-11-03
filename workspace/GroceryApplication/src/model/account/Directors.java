package model.account;

import java.util.ArrayList;

import view.ProductManagementView;

public class Directors {

	private ArrayList<Director> directors;
	private int selectedIndex;
	
	public Directors() {
		directors = new ArrayList<Director>();
	}
	
	public Directors(ArrayList<Director> directors) {
		
		this.setDirectors(directors);
	}

	public void add(Director director) {
		directors.add(director);
	}
	
	public String[] toStringArray() {
		
		String[] array = new String[directors.size()];
		
		int i = 0;
		for(Director d : directors) {
			array[i] = d.toString();
			i++;
		}
		
		return array;
	}
	
	public ArrayList<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(ArrayList<Director> directors) {
		this.directors = directors;
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

	//Gives the selected director objet
	public Director getSelectedDirector() {
		if(selectedIndex < 0) {
			return null;
		}
		return directors.get(selectedIndex);
	}
}
