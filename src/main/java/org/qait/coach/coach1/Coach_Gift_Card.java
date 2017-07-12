package org.qait.coach.coach1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Coach_Gift_Card {
	WebDriver driver;
	By click_on_gift_cards = By.cssSelector(".footer-lower-wrap [href*='gift-card']");
	By click_on_close_pop_window_sign= By.cssSelector("button[class='icon-coach-close-black']");
	By click_on_check_your_balance= By.cssSelector("#gift-card-balance");
	By set_gift_card_Number= By.cssSelector("#dwfrm_giftcard_inquireBalance_giftcardcode");
	By set_gift_card_pin_Number= By.cssSelector("#dwfrm_giftcard_inquireBalance_giftcardpin");
	By click_on_submit_button= By.xpath(".//button[contains(text(), 'Submit')]");
	
	public Coach_Gift_Card(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnGiftCards() {
		driver.findElement(click_on_gift_cards).click(	);
	}
	
	public void closePopWindow(){
		driver.findElement(click_on_close_pop_window_sign).click();
	}

	public void clickOnCheckYourBalance(){
		driver.findElement(click_on_check_your_balance).click();
	}
		
	public void setGiftCardNumber(String CardNumber){
	driver.findElement(set_gift_card_Number).sendKeys(CardNumber);;
	}
	
	public void setGiftCardPinNumber(String PinNumber){
	driver.findElement(set_gift_card_pin_Number).sendKeys(PinNumber);;
	}
	
	public void clickOnSubmitButton(){
		driver.findElement(click_on_submit_button).click();
	}

}
