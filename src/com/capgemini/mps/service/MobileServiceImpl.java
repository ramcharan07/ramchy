package com.capgemini.mps.service;

import java.util.List;

import com.capgemini.mps.bean.Mobile;
import com.capgemini.mps.dao.IMobileDAO;
import com.capgemini.mps.dao.MobileDAOImpl;
import com.capgemini.mps.exception.MobilePurchaseSystemException;

public class MobileServiceImpl implements IMobileService{

	private IMobileDAO mobileDAO=new MobileDAOImpl();

	@Override
	public String deleteMobile(Integer mobileId)
			throws MobilePurchaseSystemException {
		String message=mobileDAO.deleteMobile(mobileId);
		return message;
	}

	@Override
	public List<Mobile> viewAllMobiles() throws MobilePurchaseSystemException {
		List<Mobile> mobileList=mobileDAO.viewAllMobiles();
		return mobileList;
	}

	@Override
	public List<Mobile> getMobilesPriceRange(Double lowPrice, Double highPrice)
			throws MobilePurchaseSystemException {
		List<Mobile> mobileList=mobileDAO.getMobilesPriceRange(lowPrice, highPrice);
		return mobileList;
		
	}

	@Override
	public boolean isValidMobileId(Integer mobileId)
			throws MobilePurchaseSystemException {
		
		return mobileDAO.isValidMobileId(mobileId);
	}

	/*@Override
	public Integer updateMobileQuantity(Integer mobileId, Integer quantity)
			throws MobilePurchaseSystemException {
		mobileDAO.updateMobileQuantity(mobileId, quantity);
		return null;
	}
*/
}
