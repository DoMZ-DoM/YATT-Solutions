package com.yatt.jobservice.model;

public class BirthDate {
	private String date;
	private String year;
	private String month;
	public BirthDate () {}
	public BirthDate(String date, String year, String month) {
		super();
		this.date = date;
		this.year = year;
		this.month = month;
	}
	
	public BirthDate(String year, String month) {
		super();
		this.year = year;
		this.month = month;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	
}
