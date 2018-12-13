package com.capgemini.mps.dao;

import java.util.List;

import com.capgemini.mps.bean.Mobile;
import com.capgemini.mps.exception.MobilePurchaseSystemException;

public interface IMobileDAO {
	public abstract String deleteMobile(Integer mobileId)throws MobilePurchaseSystemException;
	public abstract List<Mobile> viewAllMobiles()throws MobilePurchaseSystemException;
	public abstract List<Mobile> getMobilesPriceRange(Double lowPrice,Double highPrice)throws MobilePurchaseSystemException;
	public boolean isValidMobileId(Integer mobileId)throws MobilePurchaseSystemException;
	public Mobile getMobileDetails(Integer mobileId) throws MobilePurchaseSystemException;
	public Integer addMobile(Mobile mobile) throws MobilePurchaseSystemException;
	public Integer updateMobileQuantity(Integer mobileId,Integer quantity)throws MobilePurchaseSystemException;
}
