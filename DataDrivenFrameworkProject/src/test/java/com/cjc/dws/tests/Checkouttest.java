package com.cjc.dws.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cjc.dws.pages.CheckoutProcess;
import com.cjc.dws.pages.Shoppingcart;

public class Checkouttest {

	WebDriver driver;
	static Logger log= Logger.getLogger(Checkouttest.class.getName());
	Properties pro = new Properties();
	
public Checkouttest(WebDriver driver)
{
	this.driver=driver;
}

@Test
public void checkouttest() throws IOException, InterruptedException
{
	CheckoutProcess rp = PageFactory.initElements(driver, CheckoutProcess.class);
	FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProject\\src\\test\\java\\com\\cjc\\dws\\utility\\Prop.properties"); 
	pro.load(fis);
	rp.Checkoutdata(pro.getProperty("Companyname"), pro.getProperty("Countrybill"), pro.getProperty("Cityname"), 
			        pro.getProperty("addr1"),pro.getProperty("addr2"),pro.getProperty("Zipcode"),pro.getProperty("Mobno"));
	Thread.sleep(3000);
	rp.pickup();
	Thread.sleep(3000);
	rp.orderno();
	
	
}
}
