package model.account;

import java.util.Date;

public abstract class Account {
	
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	
	public Account(String firstName, String lastName, Date birthDate) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthDate(birthDate);
		this.setEmail(lastName + firstName + "@magasin.ca");
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	@Override
	public String toString() {
		return "name:" + getName() + ", birth date:" + birthDate.toString() + ", email:" + email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
