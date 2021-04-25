package com.cjc.dws.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cjc.dws.pages.Shoppingcart;

public class Shoppingcarttest {

	WebDriver driver;
	static Logger log= Logger.getLogger(Shoppingcarttest.class.getName());
	Properties pro = new Properties();
	
public Shoppingcarttest(WebDriver driver)
{
	this.driver=driver;
}
	@Test
	public void shoptest() throws IOException, InterruptedException
	{
		Shoppingcart rp = PageFactory.initElements(driver, Shoppingcart.class);
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProject\\src\\test\\java\\com\\cjc\\dws\\utility\\Prop.properties"); 
		pro.load(fis);
		rp.cartclick();
		Thread.sleep(3000);
		rp.shopdata(pro.getProperty("Countrybill"), pro.getProperty("Zipcode"));
		Thread.sleep(3000);
		rp.shopingdata();
		
		
	}
	
}
