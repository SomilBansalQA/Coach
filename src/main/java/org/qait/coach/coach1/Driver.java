package org.qait.coach.coach1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	
	WebDriver driver=null;
	
	public  WebDriver driverLaunch(){

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://storefront:coach123@dwdevelopment2.coach.com/");
		
		return driver;
}
}
