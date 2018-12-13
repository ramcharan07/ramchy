package com.capgemini.mps.dao;

public interface QueryMapper {
	public static final String VIEW_ALL_MOBILES="SELECT * FROM mobiles";
	public static final String DELETE_MOBILE="DELETE FROM mobiles WHERE mobileid=?";
	public static final String SEARCH_MOBILE="SELECT * FROM mobiles WHERE price >=? AND price<=?";
	public static final String CHECK_VALID_MOBILEID="SELECT * from mobiles WHERE mobileid=? ";
	public static final String ADD_PURCHASE_DETAILS="INSERT INTO purchasedetails VALUES(purchase_sequence.NEXTVAL,?,?,?,SYSDATE,?)";
	public static final String PURCHASE_ID="SELECT purchaseid FROM purchasedetails where phoneno=?";
	public static final String MOBILE_QUANTITY_UPDATE="UPDATE mobiles set quantity=quantity-? where mobileid=?";
	public static final String RETRIVE_MOBILE="SELECT * FROM mobiles WHERE mobileid=?"; 
		 

}
