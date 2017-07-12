package org.qait.coach.coach1;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class TestCoach {
	WebDriver driver;

	Coach_Gift_Card coachGCObj;
	ExcelFile efObj;
    int sleepTime=5000;
	
	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://storefront:coach123@dwdevelopment2.coach.com/");
		coachGCObj = new Coach_Gift_Card(driver);
		efObj = new ExcelFile();
	}

	@Test(priority = 0)
	public void TestGiftCards() throws InterruptedException {
		
		
		coachGCObj.clickOnGiftCards();
		coachGCObj.closePopWindow();
	
		Thread.sleep(sleepTime);
		((JavascriptExecutor) driver).executeScript("document.getElementById('search-result-content').scrollIntoView(true);");
		Thread.sleep(sleepTime); 
		
		assertEquals("SEND STYLE", driver.findElement( By.xpath(".//h1[contains(text(),'SEND STYLE')]")).getText());
		assertEquals("The luxury of choice is a wonderful gift.", driver.findElement( By.xpath(".//div[contains(text(),'The luxury of choice is a wonderful gift.')]")).getText());	
		assertEquals("GIFT CARDS", driver.findElement( By.xpath(".//div[contains(text(),'GIFT CARDS')]")).getText());

			
	    int	cursor=1;
	    while(cursor<efObj.getNoOfRows()-2){
	    Thread.sleep(sleepTime);
		coachGCObj.clickOnCheckYourBalance();
		Thread.sleep(sleepTime);
		
		coachGCObj.setGiftCardNumber(efObj.getGiftCardNumber(cursor));
		Thread.sleep(sleepTime);

		coachGCObj.setGiftCardPinNumber(efObj.getGiftCardPinNumber(cursor));
		
		Thread.sleep(sleepTime);
		System.out.println("Gift Card No: is " +efObj.getGiftCardNumber(cursor) + "Pin No: " + efObj.getGiftCardPinNumber(cursor));
		coachGCObj.clickOnSubmitButton();
		Thread.sleep(sleepTime);
        
		String Balance=driver.findElement(By.xpath(".//div[@class='row balance-row']/span")).getText();
		
 	    System.out.println("Balance is "+Balance);
		
		coachGCObj.closePopWindow();
		Thread.sleep(sleepTime);
 	    cursor++;

	}
	
	}

	
	
}