package com.capgemini.mps.service;

import com.capgemini.mps.exception.MobilePurchaseSystemException;

public interface IPurchaseservice {
	public abstract Long addPurchaseDetails(String name,String emailId,Long phoneNumber,Integer mobileId,Integer quantity)throws MobilePurchaseSystemException;
}
