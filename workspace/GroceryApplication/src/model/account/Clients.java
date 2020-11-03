package model.account;

import java.util.ArrayList;

import view.component.ClientListComponent;

public class Clients {
	
	private ArrayList<Client> clients;
	private int selectedIndex;
	private String filter;
	private ClientListComponent clc;
	
	public Clients() {
		
		setClients(new ArrayList<Client>());
		filter = "";
	}

	public void add(Client client) {
		clients.add(client);
	}
	
	public String[] toStringArray() {
		
		String[] array = new String[clients.size()];
		
		int i = 0;
		for(Client c : clients) {
			
			String name = c.getName();
			//If the client's name matches the filter
			if(name.length() >= filter.length() && name.substring(0, filter.length()).equals(filter)) {
				array[i] = c.toString();
			}
			else {
				array[i] = "-";
			}
			
			i++;
		}
		
		return array;
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

	//Gives the selected client object
	public Client getSelectedClient() {
		if(selectedIndex < 0) {
			return null;
		}
		return clients.get(selectedIndex);
	}
	
	public void setFilter(String filter) {
		this.filter = filter;
		if(clc != null) {
			clc.update();
		}
		
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public void setClientListComponent(ClientListComponent clc) {
		this.clc = clc;
	}
}
