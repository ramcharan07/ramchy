package com.capgemini.mps.presentation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.mps.bean.Mobile;
import com.capgemini.mps.bean.PurchaseDetails;
import com.capgemini.mps.exception.MobilePurchaseSystemException;
import com.capgemini.mps.service.CustomerValidator;
import com.capgemini.mps.service.IMobileService;
import com.capgemini.mps.service.IPurchaseservice;
import com.capgemini.mps.service.MobileServiceImpl;
import com.capgemini.mps.service.PurchaseServiceImpl;


public class MPSTester {
	private static Scanner scanner=new Scanner(System.in);
	private static  IMobileService mobileService = new MobileServiceImpl();
	private static IPurchaseservice purchaseService=new PurchaseServiceImpl();
	
	//private static Logger myUILogger=Logger.getLogger(MPSTester.class);
	public static void main(String[] args) {
		//PropertyConfigurator.configure("resource/log4J.properties");
		int option;
		while (true) {

			// show menu
			System.out.println();
			System.out.println();
			System.out.println("   Mobile Purchase System  ");
			System.out.println("_______________________________\n");

			
			System.out.println("1.Search Mobiles");
			System.out.println("2.Retrive All Mobiles");
			System.out.println("3.Delete Mobile");
			System.out.println("4.Purchase Mobile");
			System.out.println("5.Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			// accept option

			try {
				option = scanner.nextInt();

				switch (option) {
				
				case 1:
					System.out.println("Enter the price range:");
					System.out.println("Enter lowest price");
					Double lowPrice = scanner.nextDouble();
					System.out.println("Enter highest price");
					Double highPrice = scanner.nextDouble();
					List<Mobile> mobileSearchList=getMobilesPriceRange(lowPrice,highPrice);
					showMobiles(mobileSearchList);
					break;
				case 2:
						List<Mobile> mobileList=viewAllMobiles();
						showMobiles(mobileList);
						break;
				case 3:
					System.out.println("Enter mobile id you want to delete:");
					int id=scanner.nextInt();
					String message=deleteMobile(id);
					System.out.println(message);
					break;
				case 4:
					System.out.println("Enter customer 10-digit mobile number:");
					Long phnnumber=scanner.nextLong();
					scanner.nextLine();
					System.out.println("Enter customer name(begin with Uppercase and name cannot exceed 20 characters):");
					String cname=scanner.nextLine();
				
					System.out.println("Enter customer EmailId:");
					String emailId = scanner.nextLine();
					
					
					CustomerValidator validator=new CustomerValidator();
					
					if(validator.isValidCustomerName(cname)){
						
						if(validator.isValidCustomerEmail(emailId)){
							
							if(validator.isValidCustomerMobile(phnnumber)){
								
								PurchaseDetails purchaseDetails=new PurchaseDetails();
								purchaseDetails.setCustomerName(cname);
								purchaseDetails.setMailId(emailId);
								purchaseDetails.setPhoneNumber(phnnumber);
								System.out.println("Enter existing mobile id: ");
								Integer mobileid=scanner.nextInt();
								try {
									if(mobileService.isValidMobileId(mobileid)){
										purchaseDetails.setMobileId(mobileid);
										System.out.println("Enter the quantity of required mobileid");
										Integer quantity=scanner.nextInt();
										Long pid=purchaseService.addPurchaseDetails(cname, emailId, phnnumber, mobileid,quantity);
										System.out.println("Your Purchase Id:"+pid);
								}else{
										System.out.println("Enter valid mobile id");
									}
								} catch (MobilePurchaseSystemException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else{
								System.out.println("Enter valid phone number");
							}
						}else{
							System.out.println("Enter valid email id");
						}
					}else{
						System.out.println("Enter valid customer name");
					}
					
					break;

				case 5:

					System.out.print("Exit Mobile Purchase System ");
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid option[1-6]");
				}// end of switch
			}

			catch (InputMismatchException e) {
				//myUILogger.warn("Enter only integer values");
				scanner.nextLine();
				System.err.println("Please enter a numeric value, try again");
			}

		}
	}
	private static List<Mobile> getMobilesPriceRange(Double lowPrice,
			Double highPrice) {
		List<Mobile> mobileList = new ArrayList<>();
		try {
			mobileList = mobileService.getMobilesPriceRange(lowPrice, highPrice);
			return mobileList;
		} catch (MobilePurchaseSystemException e) {
			//myUILogger.info(e.getMessage());
			System.out.println("Exception occured:");
			e.printStackTrace();
		}
		return null;
	}
	private static String deleteMobile(int id) {
		try {
			String message=mobileService.deleteMobile(id);
			return message;
		} catch (MobilePurchaseSystemException e) {
			//myUILogger.info(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	private static void showMobiles(List<Mobile> mobileList) {
		if (mobileList != null) {
			Iterator<Mobile> iterator = mobileList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} else {
			System.out.println("No data of mobiles");
		}
		
	}
	private static List<Mobile> viewAllMobiles()  {
		List<Mobile> mobileList = new ArrayList<>();
		try {
			mobileList = mobileService.viewAllMobiles();
			return mobileList;
		} catch (MobilePurchaseSystemException e) {
			//myUILogger.error(e.getMessage());
			System.out.println("Exception occured:");
			e.printStackTrace();
		}
		return null;
	}

	}


