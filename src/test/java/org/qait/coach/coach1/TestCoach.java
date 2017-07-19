package org.qait.coach.coach1;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class TestCoach {
     
	CoachGiftCard coachGCObj;
	ExcelFile efObj;
    Driver driverobj;
    CoachCheckOut coachCheckOutObject;
	int sleepTime=5000;
	WebDriver driver;
	String GiftcardTitle="SEND STYLE";
	String giftCardDescription="The luxury of choice is a wonderful gift.";
	String giftCard="GIFT CARDS";
	String thankYou="Thank you for your order.";
	@BeforeTest
	public void setup() {
	    driverobj = new Driver();
		driver= driverobj.driverLaunch();		
		coachGCObj = new CoachGiftCard(driver);
		efObj = new ExcelFile();
		coachCheckOutObject= new CoachCheckOut(driver);
	}

	
	
	@Test(priority = 0)
	public void TestGiftCards() throws InterruptedException {
		
		
		coachGCObj.clickOnGiftCards();
		coachGCObj.closePopWindow();
	    
		coachGCObj.scrollIntoView();
		
	    assertEquals("check GiftcardTitle",GiftcardTitle, coachGCObj.getGiftCardTitle());
	   assertEquals("check giftCardDescription",giftCardDescription, coachGCObj.getGiftCardDescription());	
	    assertEquals("check giftCardText",giftCard, coachGCObj.getGiftCardText());

			
	    int	cursor=1;
	    while(cursor<efObj.getNoOfRows()-2){
	 
		coachGCObj.clickOnCheckYourBalance();
	
		coachGCObj.setGiftCardNumber(efObj.getGiftCardNumber(cursor));

		coachGCObj.setGiftCardPinNumber(efObj.getGiftCardPinNumber(cursor));
		System.out.println("Gift Card No: is " +efObj.getGiftCardNumber(cursor) + "Pin No: " + efObj.getGiftCardPinNumber(cursor));

		coachGCObj.clickOnSubmitButton();
	

		String Balance=coachGCObj.getGiftCardBalance();

 	    System.out.println(Balance);
		
		coachGCObj.closePopWindow();

 	    cursor++;

	}
	}
	
	
	  
	
	   @Test(priority=1)
	   public void TestCoachCheckOut() throws InterruptedException{
		   
		   int	cursor=1;
		 
		   while(cursor<efObj.getNoOfRowsOfCreditCardFile()-2){
   
		   coachCheckOutObject.clickOnSale();

		   coachCheckOutObject.clickOnSelectedBag();
		   coachCheckOutObject.clickonSelectSizeButton();
		   coachCheckOutObject.setSize();
		   coachCheckOutObject.clickOnAddToBag();
		   coachCheckOutObject.clickOnBagButton();
		   coachCheckOutObject.clickOnCheckOut();
		   coachCheckOutObject.setFirstName();
		   coachCheckOutObject.setLastName();
		   coachCheckOutObject.setAdress();
		   coachCheckOutObject.setZipCode();
	
		   coachCheckOutObject.setPhoneNumber();
		   coachCheckOutObject.clickOnContinue();
		   
		   coachCheckOutObject.setCardNumber(efObj.getCreditCardNumber(cursor));
		   coachCheckOutObject.setMonth();
		   coachCheckOutObject.setYear();
		   coachCheckOutObject.setSecurityCode(efObj.getCreditCardSecurityNumber(cursor));
		   coachCheckOutObject.setEmailAdress();
		   coachCheckOutObject.setConfirmEmailAdress();
		   coachCheckOutObject.clickOnContinue();
		   coachCheckOutObject.setSecurityCode(efObj.getCreditCardSecurityNumber(cursor));
		   coachCheckOutObject.clickOnContinue();
		   coachCheckOutObject.clickOnPlaceOrder();
		   assertEquals("check your order is placed",thankYou, coachCheckOutObject.getThankYouText());
		   cursor++;
			   }
	
	   }
	
	
}
