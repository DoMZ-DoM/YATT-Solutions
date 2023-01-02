package com.yatt.jobservice.model;

public class Company {
	private String companyName = null;
	private String tinNumber = null;
	private Image image = null;
	private String companyId = null;
	public Company () {}
	public Company(String companyName, String tinNumber, Image image, String companyId) {
		super();
		this.companyName = companyName;
		this.tinNumber = tinNumber;
		this.image = image;
		this.companyId = companyId;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the tinNumber
	 */
	public String getTinNumber() {
		return tinNumber;
	}
	/**
	 * @param tinNumber the tinNumber to set
	 */
	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}
	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	
}
