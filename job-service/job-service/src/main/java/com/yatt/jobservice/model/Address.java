package com.yatt.jobservice.model;

public class Address {
 private String country;
 private String  city;
 private String postalCode;
 
public Address () {}
public Address(String country, String city, String postalCode) {
	super();
	this.country = country;
	this.city = city;
	this.postalCode = postalCode;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
 
}
