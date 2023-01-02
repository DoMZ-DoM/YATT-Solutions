package com.yatt.profileservice.profile.model;

import java.time.LocalDate;

public class Certificates {

	private String name;
	private String issuingOrg;
	private LocalDate issuedDate;
	private LocalDate validTill;
	private String certifacteId;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the issuingOrg
	 */
	public String getIssuingOrg() {
		return issuingOrg;
	}
	/**
	 * @param issuingOrg the issuingOrg to set
	 */
	public void setIssuingOrg(String issuingOrg) {
		this.issuingOrg = issuingOrg;
	}
	/**
	 * @return the issuedDate
	 */
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	/**
	 * @param issuedDate the issuedDate to set
	 */
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
	/**
	 * @return the validTill
	 */
	public LocalDate getValidTill() {
		return validTill;
	}
	/**
	 * @param validTill the validTill to set
	 */
	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}
	/**
	 * @return the certifacteId
	 */
	public String getCertifacteId() {
		return certifacteId;
	}
	/**
	 * @param certifacteId the certifacteId to set
	 */
	public void setCertifacteId(String certifacteId) {
		this.certifacteId = certifacteId;
	}
	
	
	
}
