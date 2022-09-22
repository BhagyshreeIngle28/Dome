package Pageclass.Dome;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Factory;

import Utilities.Baseclass;

public class Locators extends Baseclass {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/div[3]/a[1]")
	WebElement Buynow;

	@FindBy(xpath = "//*[@id=\"ProductInfo-template--15348804157694__16526826304f05be48\"]/variant-radios/fieldset[1]/div[2]/div[2]/label")
	WebElement Producttype1;

	@FindBy(xpath = "//*[@id=\"ProductInfo-template--15348804157694__16526826304f05be48\"]/variant-radios/fieldset[2]/div[2]/div[2]/label")
	WebElement Size;

	@FindBy(xpath = "//*[@id=\"ProductInfo-template--15348804157694__16526826304f05be48\"]/div[2]/quantity-input/button[1]")
	WebElement Minus;

	@FindBy(xpath = "//*[@id=\"ProductInfo-template--15348804157694__16526826304f05be48\"]/div[2]/quantity-input/button[2]")
	WebElement Plus;

	@FindBy(xpath = "//*[@id=\"product-form-template--15348804157694__16526826304f05be48\"]/div/button[1]")
	WebElement BuyOnce;

	@FindBy(xpath = "//*[@id=\"slidecarthq\"]/div[2]/div/div/div[2]/div[2]/div/button[1]/svg/path")
	WebElement Checkoutminus;

	@FindBy(xpath = "//*[@id='slidecart-checkout-form']/button")
	WebElement Checkoutdrawer;

	@FindBy(id = "checkout_email_or_phone")
	WebElement Email;

	@FindBy(id = "continue_button")
	WebElement Continue;

	// checkbox for offers and newsletters
	@FindBy(id = "checkout_buyer_accepts_marketing")
	WebElement checkboxmarketing;

	// Lastnamecheckout
	@FindBy(id = "checkout_shipping_address_last_name")
	WebElement Lastnamec;

	// Address[Auto sugestion]
	@FindBy(id = "checkout_shipping_address_address1")
	WebElement Address;

	// discount code
	@FindBy(id = "checkout_reduction_code")
	WebElement Discountcode;

	// Apply Button
	@FindBy(id = "checkout_submit")
	WebElement Apply;

	// change / Edit the shipping details
	@FindBy(xpath = "/html/body/div/div/div/main/div[1]/form/div[1]/div[1]/div/div/div[2]/div[2]/a[@class='link--small']")
	WebElement Editshippingdetails;

	// changeshipping method
	@FindBy(id = "checkout_shipping_rate_id_shopify-standard-0_00")
	WebElement standard;

	// Continue Payment
	@FindBy(id = "continue_button")
	WebElement Continuepayment;

	// completed order
	@FindBy(xpath = "//div[@class='shown-if-js']/button[@id='continue_button']")
	WebElement Completeorder;
	
	//Country 
	@FindBy(id = "checkout_shipping_address_country")
	WebElement Country;
	
	//Creditcard
	//cardnumber
	@FindBy(id ="number")
	WebElement cardnumber;
	
	

//	public Locators(WebDriver driver) {
//
//		 PageFactory.initElements(driver, this);
//
//	}
	public Locators(WebDriver driver) {

		this.driver = driver;

	}

	public void signpage() throws IOException, InterruptedException {

		Buynow.click();
		highLightElement(driver, Buynow);
		System.out.println("Click on Buynow");
		Thread.sleep(2000);

		Producttype1.click();
		// highLightElement(driver, Producttype1);
		System.out.println("Click on Product");
		Thread.sleep(2000);

		// highLightElement(driver, Size);
		Size.click();
		System.out.println("Click on Size");
		Thread.sleep(200);

		Plus.click();
		System.out.println("Click Plus");
		Thread.sleep(200);

		Minus.click();
		System.out.println("Click Minus");
		Thread.sleep(200);

		Plus.click();
		System.out.println("Click Plus");
		Thread.sleep(200);

		BuyOnce.click();
		System.out.println("Click Buyonce");
		Thread.sleep(2000);

//		Checkoutminus.click();
//		System.out.println("Click Checkoutminus");
//		Thread.sleep(200);

		Checkoutdrawer.click();
		System.out.println("Click Checkout");
		Thread.sleep(200);

		Email.sendKeys("John1@givmail.com");
		System.out.println("Email Entered");
		Thread.sleep(200);

		Continue.click();
		System.out.println("Click Continue Shopping");
		Thread.sleep(200);
		
		checkboxmarketing.click();
		System.out.println("Click checkboxmarketing");
		Thread.sleep(200);
		
		Lastnamec.sendKeys("John");
		System.out.println("Last name entered");
		Thread.sleep(200);
		
		Address.sendKeys("Vastrapur");
		Address.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		Address.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		Address.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		Address.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		Continue.click();
		System.out.println("Click Continue Shopping");
		Thread.sleep(200);
		
		Editshippingdetails.click();
		System.out.println("Click on Editshopping");
		Thread.sleep(200);
		
		//Seymour
		Select fruits = new Select(Country);
		fruits.selectByValue("Australia");
		
		Address.clear();
		Address.sendKeys("Seymour");
		Address.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		Address.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		Address.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		Continue.click();
		System.out.println("Click Continue Shopping");
		Thread.sleep(200);
		
		Continuepayment.click();
		System.out.println("Click Continue Payment");
		Thread.sleep(200);
		
		Completeorder.click();
		System.out.println("Click Complete order");
		Thread.sleep(2000);
		
		
		
		
		
		
		

	}

}
