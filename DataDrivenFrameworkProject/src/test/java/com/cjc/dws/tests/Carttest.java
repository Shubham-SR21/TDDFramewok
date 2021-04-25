package com.cjc.dws.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cjc.dws.pages.Addtocart;

public class Carttest  {
	

	WebDriver driver;
	static Logger log= Logger.getLogger(Carttest.class.getName());
	Properties pro = new Properties();

	
	public Carttest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Test
	public void addtocart() throws IOException
	{
		Addtocart addcart= PageFactory.initElements(driver, Addtocart.class);
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProject\\src\\test\\java\\com\\cjc\\dws\\utility\\Prop.properties");
		pro.load(fis);
		addcart.cartitem(pro.getProperty("size"));
	}
}
