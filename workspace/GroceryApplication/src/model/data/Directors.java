package model.data;

import java.util.ArrayList;

import model.account.Director;

public class Directors {
	
	private ArrayList<Director> directors;
	
	public Directors() {
		directors = new ArrayList<Director>();
	}
	
	public Directors(ArrayList<Director> directors) {
		
		this.setDirectors(directors);
	}

	public void add (Director director) {
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
}
