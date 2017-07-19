package org.qait.coach.coach1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoachCheckOut {
	WebDriver driver;
	By click_on_sale = By.xpath(".//*[text()='SALE']");
	By click_on_close_pop_window_sign = By.cssSelector("button[class='icon-coach-close-black']");
	By clck_on_selected_bag = By.xpath(".//*[text()='bond bootie']");
	By clck_on_selected_size_button = By.cssSelector(".btn.dropdown-toggle.selectpicker.btn-default");
	By set_size = By.xpath(".//span[contains(text(),' 6.5 B ')]");

	By click_on_add_to_Bag = By.cssSelector("#add-to-cart");
	By click_on_bag_button = By.cssSelector(".hidden-xs .cart-quantity");

	By click_on_checkout = By
			.xpath(".//div[contains(@class,'stickymobile-bottom')]//button[contains(text(),'Proceed to Checkout')]");
	By set_first_name = By.cssSelector("#dwfrm_singleshipping_shippingAddress_addressFields_firstName");
	By set_last_name = By.cssSelector("#dwfrm_singleshipping_shippingAddress_addressFields_lastName");
	By set_street_address = By.cssSelector("#dwfrm_singleshipping_shippingAddress_addressFields_address1");
	By set_zip_code = By.cssSelector("#dwfrm_singleshipping_shippingAddress_addressFields_zip");
	By set_city = By.cssSelector("#dwfrm_singleshipping_shippingAddress_addressFields_city");
	By set_phone_number = By.cssSelector("#dwfrm_singleshipping_shippingAddress_addressFields_phone");
	By click_on_continue_button = By.cssSelector("#billingSubmitButton");

	By set_card_number = By.xpath(".//div[@data-required-text='Enter card number']/input");

	By click_month = By
			.xpath(".//button[@class='btn dropdown-toggle selectpicker btn-default']/span[contains(text(),'MONTH')]");
	By set_month = By.xpath(".//span[text()='01']");
	By click_year = By
			.xpath(".//button[@class='btn dropdown-toggle selectpicker btn-default']/span[contains(text(),'YEAR')]");
	By set_year = By.xpath(".//span[text()='2020']");
	
	By set_security_code = By.xpath(".//div[@data-required-text='Enter security code']//input[2]");

	By set_email_address = By.xpath(".//div[@data-required-text='Enter email address']/input[1]");
	By set_confirm_email_address = By.cssSelector("input[id$='emailconfirm']");

	By click_on_place_order = By.xpath(".//div[@class='form-row place-order top-button hidden-xs']/button");
	
	By get_ThankYou_Text=By.xpath(".//*[text()='Thank you for your order.']");

	WebDriverWait wait;

	public CoachCheckOut(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public void clickOnSale() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_on_sale)).click();
	}

	public void closePopWindow() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_on_close_pop_window_sign)).click();
	}

	public void clickOnSelectedBag() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(clck_on_selected_bag)).click();
	}

	public void clickonSelectSizeButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(clck_on_selected_size_button)).click();
	}

	public void setSize() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_size)).click();
	}

	public void clickOnAddToBag() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_on_add_to_Bag)).click();
	}

	public void clickOnBagButton() throws InterruptedException {

		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('icm-icon-bag')[1].click();");
		Thread.sleep(5000);

	}

	public void clickOnCheckOut() throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("$('.btn.btn-primary')[2].scrollIntoView();");
		Thread.sleep(5000);

		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		((JavascriptExecutor) driver).executeScript("$('.btn.btn-primary').eq(2).click()");
	}

	public void setFirstName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_first_name)).sendKeys("John");
	}

	public void setLastName() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(set_last_name)).sendKeys("Doe");

	}

	public void setAdress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_street_address)).sendKeys("450 W 34th St");

	}

	public void setZipCode() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_zip_code)).sendKeys("10001");

	}

	public void setCity() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_city)).sendKeys("New York");
	}

	public void setPhoneNumber() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_phone_number)).sendKeys("6105551234");

	}

	public void clickOnContinue() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait1 = new WebDriverWait(driver, 150);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(click_on_continue_button)).click();

	}

	public void setCardNumber(String cardNumber) {
		System.out.println(cardNumber);
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_card_number)).sendKeys(cardNumber);
	}

	public void setMonth() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_month)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(set_month)).click();

	}

	public void setYear() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_year)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(set_year)).click();
	}

	public void setSecurityCode(String securityCode) {
		System.out.println(securityCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_security_code)).sendKeys(securityCode);

	}

	public void setEmailAdress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_email_address)).sendKeys("a@a.com");

	}

	public void setConfirmEmailAdress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_confirm_email_address)).sendKeys("a@a.com");

	}

	public void clickOnPlaceOrder() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 150);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(click_on_place_order)).click();

	}
	
	public String getThankYouText(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(get_ThankYou_Text));
		String thank_you_text = driver.findElement(get_ThankYou_Text).getText();
		return thank_you_text;
	}
}
