package model.data;

import java.util.ArrayList;

import view.IDataList;
import view.Updatable;

//Class responsible for holding a set of model data.
public class ModelData extends ArrayList<IData> {
	
	//To tell the current selected index of the array list.
	private int selectedIndex;
	//The updatable views displaying the data
	private ArrayList<IDataList> views;
	//So that the items can be filtered
	private String filter;
	//The model datas to update when the current one changes
	private ArrayList<ModelData> linkedModelDatas;
	
	public ModelData(){
		super();
		this.views = new ArrayList<IDataList>();
		this.filter = "";
		this.linkedModelDatas = new ArrayList<ModelData>(); 
	}
	
	public ModelData(ArrayList<IData> l) {
		super();
		for(IData t : l) {
			this.add(t);
		}
		this.views = new ArrayList<IDataList>();
		this.filter = "";
		this.linkedModelDatas = new ArrayList<ModelData>(); 
	}
	
	@Override
	public boolean add(IData x) {
		boolean added =  super.add(x);
		update();
		for(ModelData md : linkedModelDatas) {
			md.add(x);
		}
		return added;
		
	}
	
	//Gives a string array representing the array list.
	public String[] toStringArray() {
		
		String[] array = new String[this.size()];

		int i = 0;
		for(IData t : this) {
			
			
	
			String name = t.getName();
			//If the client's name matches the filter
			if(name.length() > 0 && 
					name.length() >= filter.length() && 
					name.substring(0, filter.length()).equals(filter)) {
				array[i] = t.toString();
			}
			else {
				array[i] = "-";
			}
			i++;
		}
		
		return array;
	}
	
	public void setFilter(String filter) {
		this.filter = filter;
		update();
		
	}
	
	//Gives the selected object
	public IData getSelected() {
		if(selectedIndex < 0) {
			return null;
		}
		return this.get(selectedIndex);
	}
	
	//Deletes the selected index
	public void deleteSelected() {
		if(selectedIndex >= 0) {
			//Delete the selected object in the linked models
			for(ModelData md : linkedModelDatas) {
				md.deleteSelected();
			}
			this.remove(selectedIndex);
			
			if(this.size() == 0) {
				this.selectedIndex = -1;
			}
			else {
				this.selectedIndex = 0;
			}			
			update();
		}
	}
	
	public void addView(IDataList u) {
		views.add(u);
	}
	
	//Responsible for updating the views
	private void update() {
		for(IDataList v : views) {
			v.update();
		}
	}
	
	private void updateSelectedIndex() {
		for(IDataList v : views) {
			v.updateSelectedIndex();
		}
		//If the selected object is in a linkedModelData, select it there
		for(ModelData md : linkedModelDatas) {
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
		//System.out.println(selectedIndex);
		updateSelectedIndex();
	}
	
	public void addLinkedModelData(ModelData md) {
		this.linkedModelDatas.add(md);
	}
}
