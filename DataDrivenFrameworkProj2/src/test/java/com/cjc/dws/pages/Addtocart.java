package com.cjc.dws.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Addtocart  {
	WebDriver driver;
	static Logger log= Logger.getLogger(Addtocart.class.getName());
	
	
	@FindBy(how=How.XPATH,using="//li[@class=\"inactive\"]/child ::a[@href=\"/books\"]")
	WebElement books;
	
	@FindBy(how=How.CSS,using="div[class=\"picture\"] a[href=\"/computing-and-internet\"]")
	WebElement cominterbook;
	
	@FindBy(how=How.ID,using="add-to-cart-button-13")
	WebElement bookadd;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")
	WebElement comclick ;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/a/img")
	WebElement deskclick ;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/img")
	WebElement onedeskclick ;
	
	@FindBy(how=How.ID,using="add-to-cart-button-72")
	WebElement onedeskadd;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a")
	WebElement jewelryclick;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/img")
	WebElement createjewelclick;
	
	@FindBy(how=How.NAME,using="product_attribute_71_10_16")
	WebElement length;
	
	@FindBy(how=How.ID,using="add-to-cart-button-71")
	WebElement jeweladd;

	public Addtocart(WebDriver driver)
	{
		this.driver=driver;
		log.info("This is constructor");
	}
	
	public void cartitem(String size) throws InterruptedException
	{
		books.click();
		log.info("Books tab open");
		Thread.sleep(3000);
		cominterbook.click();
		log.info("Click on specific book");
		Thread.sleep(3000);
		bookadd.click();
		log.info("Book add");
		Thread.sleep(3000);
		comclick.click();
		log.info("Click on computer tab");
		Thread.sleep(3000);
		deskclick.click();
		log.info("Click on Desktop");
		Thread.sleep(3000);
		onedeskclick.click();
		log.info("Click on specific Desktop");
		Thread.sleep(3000);
		onedeskadd.click();
		log.info("Add Desktop to cart");

		jewelryclick.click();
	
		createjewelclick.click();

		length.sendKeys(size);

		jeweladd.click();
		
	}
	
	
	
	
}