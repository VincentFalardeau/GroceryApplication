package model.data;

import java.util.ArrayList;

import model.account.Director;
import view.data.IDataView;

//Vincent Falardeau
//20170932

public abstract class Model extends ArrayList<IData> {
	
	//The index of the selected item
	protected int selectedIndex;
	
	//The views displaying the data
	private ArrayList<IDataView> views;
	
	//To filter the items
	private String filter;
	
	public Model(){
		super();
		this.views = new ArrayList<IDataView>();
		this.filter = "";
	}
	
	//Adds data in the list
	@Override
	public boolean add(IData x) {
		
		boolean added =  super.add(x);
		
		//update the associated views
		update();
		
		return added;
	}
	
	//Removes an object from the list
	@Override
	public boolean remove(Object o) {
		
		//Remove the object
		IData x = (IData)o;
		boolean removed = super.remove(x);
		
		//Update the views
		update();
		
		return removed;
	}
	
	//Gives a string array representing the array list.
	public String[] toStringArray() {
		
		String[] array = new String[this.size()];

		int i = 0;
		for(IData t : this) {
	
			//If the client's name matches the filter
			String name = t.getName();
			if(name.indexOf(this.filter) == 0) {
				array[i] = t.toString();
			}
			else {
				array[i] = "-";
			}
			i++;
		}
		
		return array;
	}
	
	//Sets a new filter and updates the views
	public void setFilter(String filter) {
		this.filter = filter;
		update();
		
	}
	
	//Gives the selected item, null if none is selected
	public IData getSelected() {
		if(selectedIndex < 0) {
			return null;
		}
		return this.get(selectedIndex);
	}
	
	//Deletes the selected item
	public void deleteSelected() {
		
		if(selectedIndex >= 0) {
			
			//Delete the selected object
			this.remove(selectedIndex);
			
			//Set the selected index to 0 if possible
			if(this.size() == 0) {
				this.selectedIndex = -1;
			}
			else {
				this.selectedIndex = 0;
			}	
			
			//Update the views
			update();
		}
	}
	
	public void addView(IDataView u) {
		views.add(u);
	}
	
	//Updates the views displaying the model
	protected void update() {
		for(IDataView v : views) {
			v.update();
		}
	}
	
	//Updates the selected index in all the views
	private void updateSelectedIndex() {
		for(IDataView v : views) {
			v.updateSelectedIndex();
		}
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}
	
	public void setSelectedIndex(int selectedIndex) {	
		this.selectedIndex = selectedIndex;
		updateSelectedIndex();
	}
}
