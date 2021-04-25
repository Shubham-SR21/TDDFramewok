package com.cjc.dws.pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutProcess {


	WebDriver driver;
	static Logger log= Logger.getLogger(CheckoutProcess.class.getName());
	Properties pro=new Properties();
	
	@FindBy(how=How.XPATH,using ="//*[@id=\"BillingNewAddress_Company\"]")
	WebElement company;	
	@FindBy(how=How.XPATH,using ="//*[@id=\"BillingNewAddress_CountryId\"]")
	WebElement billcountry;	
	@FindBy(how=How.XPATH,using ="//*[@id=\"BillingNewAddress_City\"]")
	WebElement city;
	@FindBy(how=How.XPATH,using ="//*[@id=\"BillingNewAddress_Address1\"]")
	WebElement add1;
	@FindBy(how=How.XPATH,using ="//*[@id=\"BillingNewAddress_Address2\"]")
	WebElement add2;
	@FindBy(how=How.XPATH,using ="//*[@id=\"BillingNewAddress_ZipPostalCode\"]")
	WebElement billzipcode;
	@FindBy(how=How.XPATH,using ="//*[@id=\"BillingNewAddress_PhoneNumber\"]")
	WebElement phoneno;
	@FindBy(how=How.XPATH,using ="//*[@id=\"billing-buttons-container\"]/input")
	WebElement continuebutton;
	
	@FindBy(how=How.XPATH,using ="//*[@id=\"PickUpInStore\"]")
	WebElement pickup;
	@FindBy(how=How.XPATH,using ="//*[@id=\"shipping-buttons-container\"]/input")
	WebElement Continuebutton1;
	@FindBy(how=How.XPATH,using ="//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement Continuebutton2;
	@FindBy(how=How.XPATH,using ="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement Continuebutton3;
	@FindBy(how=How.XPATH,using ="//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement Confirmbutton;
	@FindBy(how=How.XPATH,using ="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")
	WebElement OrderNo;
	@FindBy(how=How.XPATH,using ="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[2]/input")
	WebElement Continuebutton4;
	
	public CheckoutProcess(WebDriver driver)
	{
		this.driver=driver;
		log.info("This is constructor");
	}
	public void Checkoutdata(String Companyname, String Countrybill,String Cityname, 
			String addr1, String addr2, String Zipcode,String Mobno )
	{
		company.sendKeys(Companyname);
		billcountry.sendKeys(Countrybill);
		city.sendKeys(Cityname);
		add1.sendKeys(addr1);
		add2.sendKeys(addr2);
		billzipcode.sendKeys(Zipcode);
		phoneno.sendKeys(Mobno);
		continuebutton.click();
	}
	
	public void pickup() throws InterruptedException
	{
		
		pickup.click();
		Thread.sleep(2000);
		Continuebutton1.click();
		Thread.sleep(2000);
		Continuebutton2.click();
		Thread.sleep(2000);
		Continuebutton3.click();
		Thread.sleep(2000);
		Confirmbutton.click();
	
	}
	public void orderno()
	{
		String Ordno=OrderNo.getText();
		log.info(Ordno);
		
		Continuebutton4.click();
	}
	
	
	
}
