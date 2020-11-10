package model.data;

import java.util.ArrayList;

import view.data.IDataView;

public class Model extends ArrayList<IData> {
	
	//The index of the selected item
	private int selectedIndex;
	
	//The views displaying the data
	private ArrayList<IDataView> views;
	
	//To filter the items
	private String filter;
	
	//Models to update along with the current one,
	//to maintain coherence
	private ArrayList<Model> linkedModels;
	
	public Model(){
		super();
		this.views = new ArrayList<IDataView>();
		this.filter = "";
		this.linkedModels = new ArrayList<Model>(); 
	}
	
	//Adds data in the list, returns true if successfully added
	@Override
	public boolean add(IData x) {
		
		boolean added =  super.add(x);
		
		//update the associated views
		update();
		
		//update the linked models
		for(Model md : linkedModels) {
			md.add(x);
		}
		return added;
		
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
			
			//Delete the selected object in the linked models
			for(Model md : linkedModels) {
				md.deleteSelected();
			}
			
			//Delete the selected object here
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
	
	//Responsible for updating the views displaying the model
	private void update() {
		for(IDataView v : views) {
			v.update();
		}
	}
	
	//Updates the selected index in all the views
	private void updateSelectedIndex() {
		
		for(IDataView v : views) {
			v.updateSelectedIndex();
		}
		
		//If the selected item is in a linked model,
		//select it there too.
		for(Model md : linkedModels) {
			int index = md.indexOf(this.getSelected());
			if(index >= 0) {
				md.setSelectedIndex(index);
			}
			
		}
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}
	
	public void setSelectedIndex(int selectedIndex) {	
		this.selectedIndex = selectedIndex;
		updateSelectedIndex();
	}
	
	public void addLinkedModel(Model md) {
		this.linkedModels.add(md);
	}
}
