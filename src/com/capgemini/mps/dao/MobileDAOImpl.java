package com.capgemini.mps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.capgemini.mps.bean.Mobile;
import com.capgemini.mps.exception.MobilePurchaseSystemException;
import com.capgemini.mps.presentation.MPSTester;
import com.capgemini.mps.util.DBConnection;

public class MobileDAOImpl implements IMobileDAO {
	//private static Logger myMobDAOLogger=Logger.getLogger(MobileDAOImpl.class);
	@Override
	public String deleteMobile(Integer mobileId)
			throws MobilePurchaseSystemException {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.DELETE_MOBILE);

				){
			System.out.println("deleted");
			preparedStatement.setInt(1, mobileId);
			int n=preparedStatement.executeUpdate();
			System.out.println(n);
			if(n>0){
				System.out.println("in if of delete");
				return "Your required mobile id data Deleted";
				//myMobDAOLogger.info("Success");
			}else{
				//myMobDAOLogger.info("Fail");
				return "Error occured not deleted";
			}
		}catch(SQLException e){
			//myMobDAOLogger.error(e.getMessage());
			e.printStackTrace();

		}catch(Exception e){
			//myMobDAOLogger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Mobile> viewAllMobiles() throws MobilePurchaseSystemException {
		int mobileCount=0;
		try(
				Connection connection=DBConnection.getConnection();	
				Statement statement=connection.createStatement();
				){
			ResultSet resultSet = statement.executeQuery(QueryMapper.VIEW_ALL_MOBILES);
			List<Mobile> mobileList = new ArrayList<>();
			while(resultSet.next()){
				mobileCount++;
				Mobile mobile = new Mobile();

				populateMobile(mobile,resultSet);
				mobileList.add(mobile);
			}
			if(mobileCount!=0){
				return mobileList;
			}else{
				return null;
			}

		}catch(SQLException e){
			//myMobDAOLogger.error(e.getMessage());
			throw new MobilePurchaseSystemException("Technical Error! Refer to log");

		}

	}

	private void populateMobile(Mobile mobile, ResultSet resultSet) throws SQLException {
		mobile.setMobileId(resultSet.getInt("mobileid"));
		mobile.setMobileName(resultSet.getString("name"));
		mobile.setPrice(resultSet.getDouble("price"));
		mobile.setQuantity(resultSet.getInt("quantity"));

	}

	@Override
	public List<Mobile> getMobilesPriceRange(Double lowPrice, Double highPrice)
			throws MobilePurchaseSystemException {
		int mobileCount=0;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.SEARCH_MOBILE);

				){
			preparedStatement.setDouble(1,lowPrice);
			preparedStatement.setDouble(2,highPrice);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<Mobile> mobileList=new ArrayList<>();
			while(resultSet.next()){
				mobileCount++;
				Mobile mobile = new Mobile();

				populateMobile(mobile,resultSet);
				mobileList.add(mobile);
			}
			if(mobileCount!=0){
				return mobileList;
			}else{
				return null;
			}

		}catch(SQLException e){
			//myMobDAOLogger.error(e.getMessage());
			throw new MobilePurchaseSystemException("Technical Error! Contact to log ");
		}


	}

	@Override
	public boolean isValidMobileId(Integer mobileId)
			throws MobilePurchaseSystemException {
		String regex="^[1-9][0-9]{3}$";
		String mobileidString= Long.toString(mobileId);
		try(
				Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.CHECK_VALID_MOBILEID);
				){
			preparedStatement.setInt(1, mobileId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true && Pattern.matches(regex,mobileidString);
			}
			//myMobDAOLogger.error("Enter valid mobile id");
			return false;
		}catch(SQLException e){
			//myMobDAOLogger.error(e.getMessage());
			throw new MobilePurchaseSystemException("Technical Error! Contact to log ");
		}



	}

	@Override
	public Mobile getMobileDetails(Integer mobileId)
			throws MobilePurchaseSystemException {
		try(
				Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.RETRIVE_MOBILE);

				){
			preparedStatement.setInt(1, mobileId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				Mobile mobile=new Mobile();
				populateMobile(mobile,resultSet);
				return mobile;
			}
			return null;
		}catch(SQLException e){
			//myMobDAOLogger.error(e.getMessage());
			throw new MobilePurchaseSystemException("Technical Error.. Contact logs");
		}
	}

	@Override
	public Integer addMobile(Mobile mobile)
			throws MobilePurchaseSystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateMobileQuantity(Integer mobileId, Integer quantity)
			throws MobilePurchaseSystemException {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.MOBILE_QUANTITY_UPDATE);

				){
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, mobileId);

			int n=preparedStatement.executeUpdate();
			if(n>0){
				return n;
			}
		}catch(SQLException e){
			//myMobDAOLogger.error(e.getMessage());
			e.printStackTrace();

		}catch(Exception e){
			//myMobDAOLogger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;

	}


}
