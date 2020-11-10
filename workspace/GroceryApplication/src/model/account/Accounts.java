package model.account;

import model.data.IData;
import model.data.Model;

public class Accounts extends Model{
	
	private Model directors;
	
	public Accounts(Model directors) {
		this.directors = directors;
	}
	
	//Adds an account in the list
	@Override
	public boolean add(IData x) {
			
		boolean added =  super.add(x);
			
		//update the associated views
		update();
		
		//Add to directors model if x is a director
		if(x instanceof Director && !directors.contains(x)) {
			directors.add(x);
		}
			
		return added;
	}

	//Deletes the selected item
	public void deleteSelected() {
		
		int i = getSelectedIndex();
		
		if(i >= 0) {
			
			//Remove from directors
			directors.remove(getSelected());
			
			//Delete the selected object here
			this.remove(i);
			
			//Set the selected index to 0 if possible
			if(this.size() == 0) {
				selectedIndex = -1;
			}
			else {
				selectedIndex = 0;
			}	
			
			update();
		}
	}
}
