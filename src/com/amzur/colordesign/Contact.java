package com.amzur.colordesign;

public class Contact {

	public int id;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String email;
	public String dateOfBirth;
	
	
	public Contact(){
		
	}
	
	public Contact(int id,String firstName,String lastName,String phoneNumber,String email,String dateOfBirth){
		
		this.id          = id;
		this.firstName   = firstName;
		this.lastName    = lastName;
		this.phoneNumber = phoneNumber;
		this.email       = email;
		this.dateOfBirth = dateOfBirth;
		
	}
	
	public Contact(String firstName,String lastName,String phoneNumber,String email,String dateOfBirth){
		
		
		this.firstName   = firstName;
		this.lastName    = lastName;
		this.phoneNumber = phoneNumber;
		this.email       = email;
		this.dateOfBirth = dateOfBirth;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
	
}
