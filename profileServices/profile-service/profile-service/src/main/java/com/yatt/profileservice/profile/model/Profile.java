package com.yatt.profileservice.profile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profile")
public class Profile {
	@Id
	private String id;

	private Company company = null;
	private Candidate candidate = null;

	private Boolean isCandidate = false;

	private String industry = null;

	private Address address = null;

	private Certificates[] certifications = null;

	private ContactInfo contactInfo = null;

	private Boolean activated = false;

	public Profile(){}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate the candidate to set
	 */
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	/**
	 * @return the isCandidate
	 */
	public Boolean getIsCandidate() {
		return isCandidate;
	}

	/**
	 * @param isCandidate the isCandidate to set
	 */
	public void setIsCandidate(Boolean isCandidate) {
		this.isCandidate = isCandidate;
	}

	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the certifications
	 */
	public Certificates[] getCertifications() {
		return certifications;
	}

	/**
	 * @param certifications the certifications to set
	 */
	public void setCertifications(Certificates[] certifications) {
		this.certifications = certifications;
	}

	/**
	 * @return the contactInfo
	 */
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	/**
	 * @param contactInfo the contactInfo to set
	 */
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	/**
	 * @return the activated
	 */
	public Boolean getActivated() {
		return activated;
	}

	/**
	 * @param activated the activated to set
	 */
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}


}
