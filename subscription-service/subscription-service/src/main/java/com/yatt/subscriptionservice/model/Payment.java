/**
 * 
 */
package com.yatt.subscriptionservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yatt.subscriptionservice.model.Plan.Type;


/**
 * @author ayich
 *
 */
@Document(collection = "payment")
public class Payment {

	@Id
	private String transactionId;
	private String companyId;
	private String tinId;
	private Plan plan;
	private Plan.Type type = null;
	private int price;
	private Payment.paymentStatus status = null; 

	public Payment(String transactionId, String companyId, String tinId, Plan plan, Type type, int price,
			paymentStatus status) {
		super();
		this.transactionId = transactionId;
		this.companyId = companyId;
		this.tinId = tinId;
		this.plan = plan;
		this.type = type;
		this.price = price;
		this.status = status;
	}

	public Payment(String transactionId, String companyId, String tinId, Plan plan, Type type, int price) {
		super();
		this.transactionId = transactionId;
		this.companyId = companyId;
		this.tinId = tinId;
		this.plan = plan;
		this.type = type;
		this.price = price;
	}
	
	public Payment(String transactionId, String companyId, String tinId, Plan plan) {
		super();
		this.transactionId = transactionId;
		this.companyId = companyId;
		this.tinId = tinId;
		this.plan = plan;
	}

	public Payment(String transactionId, String companyId, String tinId, Type type, int price) {
		super();
		this.transactionId = transactionId;
		this.companyId = companyId;
		this.tinId = tinId;
		this.type = type;
		this.price = price;
	}

	public Payment(String transactionId, String companyId, String tinId, Type type) {
		super();
		this.transactionId = transactionId;
		this.companyId = companyId;
		this.tinId = tinId;
		this.type = type;
	}

	public Payment(String transactionId, Type type) {
		super();
		this.transactionId = transactionId;
		this.type = type;
	}

	/**
	 * status of payment
	 *
	 */
	public enum paymentStatus {
		PENDING, CANCELLED, COMPLETE;
	}
	
	
	/**
	 * @return the status
	 */
	public Payment.paymentStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Payment.paymentStatus status) {
		this.status = status;
	}

	/**
	 * @return the plan
	 */
	public Plan getPlan() {
		return plan;
	}

	/**
	 * @param plan the plan to set
	 */
	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	/**
	 * @return the tinId
	 */
	public String getTinId() {
		return tinId;
	}

	/**
	 * @param tinId the tinId to set
	 */
	public void setTinId(String tinId) {
		this.tinId = tinId;
	}

	/**
	 * @return the type
	 */
	public Plan.Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Plan.Type type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}
