package com.capgemini.mps.dao;

import com.capgemini.mps.exception.MobilePurchaseSystemException;

public interface IPurchaseDAO {
	public abstract Long addPurchaseDetails(String name,String emailId,Long phoneNumber,Integer mobileId,Integer quantity)throws MobilePurchaseSystemException;
}
