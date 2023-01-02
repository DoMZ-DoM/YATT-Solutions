package com.yatt.jobservice.model;

public class ContactInfo {
	private String [] phoneNumber;
	private String [] website;
	private String email;
	private BirthDate birthdate;
	
	public ContactInfo() {}
	public String[] getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String[] getWebsite() {
		return website;
	}
	public void setWebsite(String[] website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BirthDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(BirthDate birthdate) {
		this.birthdate = birthdate;
	}
	
	
	

}
