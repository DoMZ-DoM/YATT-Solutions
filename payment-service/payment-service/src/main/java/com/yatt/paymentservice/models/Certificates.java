package com.yatt.paymentservice.models;

public class Certificates {

	private String name;
	private String issuingOrg;
	private String issueDate;
	private String issueYear;
	private String issueMonth;
	private String certifacteId;
	public Certificates() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuingOrg() {
		return issuingOrg;
	}

	public void setIssuingOrg(String issuingOrg) {
		this.issuingOrg = issuingOrg;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(String issueYear) {
		this.issueYear = issueYear;
	}

	public String getIssueMonth() {
		return issueMonth;
	}

	public void setIssueMonth(String issueMonth) {
		this.issueMonth = issueMonth;
	}

	public String getCertifacteId() {
		return certifacteId;
	}

	public void setCertifacteId(String certifacteId) {
		this.certifacteId = certifacteId;
	}

	public Certificates(String name, String issuingOrg, String issueDate, String issueYear, String issueMonth,
			String certifacteId) {
		super();
		this.name = name;
		this.issuingOrg = issuingOrg;
		this.issueDate = issueDate;
		this.issueYear = issueYear;
		this.issueMonth = issueMonth;
		this.certifacteId = certifacteId;
	}
	
	
}
