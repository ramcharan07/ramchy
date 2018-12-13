package com.capgemini.mps.service;


import java.util.regex.Pattern;

/*
 * This class validates the data fields of Customer Class
 */
public class CustomerValidator {
	public CustomerValidator(){
		
	}

	/**
	 * 
	 * @param customer
	 * @return true if customer name is a sequence of alphabets,
	 * one or no space else return false
	 */
	
	public Boolean isValidCustomerName(String name){
		String regex1="^[A-Z][a-zA-Z ]{0,19}$";
		 //String regex1="^[a-zA-Z]+(.)?([a-zA-Z]+)?(\\s)?(([a-zA-Z])+)?$";
		 
		 
	 
		return Pattern.matches(regex1,name);
		
	}
	
	
	
	/**
	 * 
	 * @param customer
	 * @return true if email is valid else return false.
	 * email validity:
	 * 1. email begins with either digits or alphabets followed
	 * one @ symbol followed by domain name followed by dot(.)
	 * operator followed by 2 or 3 characters followed by dot(.) operator followed by 2 characters
	 * the second dot operator followed by 2 characters is optional
	 */
	public Boolean isValidCustomerEmail(String email){
		String regex=/*"^([_0-9a-zA-Z]+)+(.)?+([0-9a-zA-Z]+)+(@)+[a-zA-Z]+(.)+([a-zA-Z]{2})$";*/
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return Pattern.matches(regex,email);
	}
	
	/**
	 * 
	 * @param customer
	 * @return true if mobile number is 10-digit number
	 * else return false
	 */
	public Boolean isValidCustomerMobile(Long phnnumber){
		String regex="^[1-9][0-9]{9}$";
		 String mobile= Long.toString(phnnumber);

		return Pattern.matches(regex,mobile);
	}
	public Boolean isValidMobileId(Integer mobileid){
		String regex="^[1-9][0-9]{3}$";
		String mobileidString= Long.toString(mobileid);
		return Pattern.matches(regex,mobileidString);
		
	}

}
