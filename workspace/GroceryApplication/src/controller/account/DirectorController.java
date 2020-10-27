package controller.account;

import java.util.ArrayList;
import java.util.Arrays;

import model.account.Director;
import model.data.Directors;

public class DirectorController {

	private Directors directors;
	
	public DirectorController(Directors directors) {
		
		this.setDirectors(directors);
	}

	public Directors getDirectors() {
		return directors;
	}

	public void setDirectors(Directors directors) {
		this.directors = directors;
	}

}
