package com.cjc.dws.pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Shoppingcart {

	WebDriver driver;
	static Logger log= Logger.getLogger(Shoppingcart.class.getName());
	Properties pro=new Properties();

	@FindBy(how=How.XPATH,using ="//*[@id=\"topcartlink\"]/a/span[1]")
	WebElement shoppingcart;
	@FindBy(how=How.XPATH,using ="//*[@id=\"CountryId\"]")
	WebElement country;
	@FindBy(how=How.XPATH,using ="//*[@id=\"ZipPostalCode\"]")
	WebElement zipcode;
	@FindBy(how=How.XPATH,using ="//*[@id=\"termsofservice\"]")
	WebElement ticktoagree;
	@FindBy(how=How.XPATH,using ="//*[@id=\"checkout\"]")
	WebElement checkout;
	
	public Shoppingcart(WebDriver driver)
	{
		this.driver=driver;
		log.info("This is constructor");
	}
	public void cartclick()
	{
		shoppingcart.click();
	}
	public void shopdata(String Countrybill, String Zipcode) 
	{
		
		country.sendKeys(Countrybill);
		zipcode.sendKeys(Zipcode);
	}
	public void shopingdata()
	{
		 ticktoagree.click();
		 checkout.click();
	}
}
