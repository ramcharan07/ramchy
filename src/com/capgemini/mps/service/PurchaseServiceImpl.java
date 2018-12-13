package com.capgemini.mps.service;

import org.apache.log4j.Logger;

import com.capgemini.mps.bean.Mobile;
import com.capgemini.mps.dao.IPurchaseDAO;
import com.capgemini.mps.dao.MobileDAOImpl;
import com.capgemini.mps.dao.PurchaseDAOImpl;
import com.capgemini.mps.exception.MobilePurchaseSystemException;

public class PurchaseServiceImpl implements IPurchaseservice{
	private IPurchaseDAO purchaseDAO=new PurchaseDAOImpl();
	//private static Logger myPurServiceLogger = Logger.getLogger(PurchaseServiceImpl.class);
	@Override
	public Long addPurchaseDetails(String name, String emailId,
			Long phoneNumber, Integer mobileId,Integer quantity)
					throws MobilePurchaseSystemException {
		try{
		Mobile mobile=new MobileDAOImpl().getMobileDetails(mobileId);
		if(mobile.getQuantity()>0){
		Long purchaseid=purchaseDAO.addPurchaseDetails(name, emailId, phoneNumber, mobileId,quantity);
		return purchaseid;
	}else{
		
		throw new MobilePurchaseSystemException("Out of Stock..");
	}
		}catch(MobilePurchaseSystemException e){
			//myPurServiceLogger.error(e.getMessage());
			throw new MobilePurchaseSystemException();
		}
		
	}
}
