package com.capgemini.mps.bean;

import java.time.LocalDate;


public class PurchaseDetails {
	private Long purchaseId;
	private String customerName;
	private String mailId;
	private Long phoneNumber;
	private LocalDate purchaseDate;
	private Integer mobileId;
	public PurchaseDetails(Long purchaseId, String customerName, String mailId,
			Long phoneNumber, LocalDate purchaseDate, Integer mobileId) {
		super();
		this.purchaseId = purchaseId;
		this.customerName = customerName;
		this.mailId = mailId;
		this.phoneNumber = phoneNumber;
		this.purchaseDate = purchaseDate;
		this.mobileId = mobileId;
	}
	public PurchaseDetails() {
		super();
	}
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Integer getMobileId() {
		return mobileId;
	}
	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}
	@Override
	public String toString() {
		return "PurchaseDetails.... "
				+ "purchaseId=" +getPurchaseId() + 
				", customerName="+getCustomerName()+ 
				", mailId=" + getMailId() + 
				", phoneNumber="+ getPhoneNumber() + 
				", purchaseDate=" + getPurchaseDate()
				+ ", mobileId=" + getMobileId() + "]";
	}
	

}
