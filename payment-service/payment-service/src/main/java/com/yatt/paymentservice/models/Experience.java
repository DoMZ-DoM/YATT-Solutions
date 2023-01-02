package com.yatt.paymentservice.models;

public class Experience {
	private String title;
	private String employmentType;
	private String companyName;
	private String industry;
	private String location;
	private String startDate;
	private String startYear;
	private String startMonth;
	private String endDate;
	private String endMonth;
	private String endYear;
	private String description;
	
	public Experience() {}
	public Experience(String title, String employmentType, String companyName, String industry, String location,
			String startDate, String startYear, String startMonth, String endDate, String endMonth, String endYear,
			String description) {
		super();
		this.title = title;
		this.employmentType = employmentType;
		this.companyName = companyName;
		this.industry = industry;
		this.location = location;
		this.startDate = startDate;
		this.startYear = startYear;
		this.startMonth = startMonth;
		this.endDate = endDate;
		this.endMonth = endMonth;
		this.endYear = endYear;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
