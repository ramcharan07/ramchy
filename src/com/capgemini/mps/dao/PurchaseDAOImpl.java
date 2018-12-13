package com.capgemini.mps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.capgemini.mps.exception.MobilePurchaseSystemException;
import com.capgemini.mps.util.DBConnection;
 
public class PurchaseDAOImpl implements IPurchaseDAO{
	//private static Logger myPurDAOLogger=Logger.getLogger(PurchaseDAOImpl.class);
	@Override
	public Long addPurchaseDetails(String name, String emailId,
			Long phoneNumber, Integer mobileId,Integer quantity ) throws MobilePurchaseSystemException {
		try(
				Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.ADD_PURCHASE_DETAILS);
				PreparedStatement preparedStatement2 = connection.prepareStatement(QueryMapper.PURCHASE_ID);
				
				){
			preparedStatement.setString(1,name);
			preparedStatement.setString(2, emailId);
			preparedStatement.setLong(3,phoneNumber);
			preparedStatement.setInt(4,mobileId);
			preparedStatement2.setLong(1, phoneNumber);
			

			int n=preparedStatement.executeUpdate();
			
			if(n>0){
				//myPurDAOLogger.info("1 row inserted successfully");
				new MobileDAOImpl().updateMobileQuantity(mobileId,quantity);
				ResultSet rs=preparedStatement2.executeQuery();
				if(rs.next()){
					
					 return rs.getLong(1);
				}
				
			
			
			}else{
				//myPurDAOLogger.info("Unable to add details");
				throw new MobilePurchaseSystemException("Technical error! Contact to log");
			}
			
		}catch(SQLException e){
		//myPurDAOLogger.error(e.getMessage());
			throw new MobilePurchaseSystemException("Technical Error! Contact to log ");
		}
		return null;
	}

	

}
