package com.cjc.dws.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllTestcomb {

	WebDriver driver;
	static Logger log= Logger.getLogger(AllTestcomb.class.getName());
	Properties pro = new Properties();
	
	
	@BeforeSuite
	public void openBrowser() throws IOException
	{
		  FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProject\\src\\test\\java\\com\\cjc\\dws\\utility\\Prop.properties"); 
		  pro.load(fis); // driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
		  driver = new ChromeDriver(); 
		  log.info("Open Chrome");
		 	
	}
	  @BeforeTest 
	  
	  public void openURL() 
	  { 
		  driver.get(pro.getProperty("url"));
	  log.info("Open URL");
		
	  }
	  
	  @BeforeClass
	  public void maximize() {
   
		  driver.manage().window().maximize();
		  
	  }
	 
	@BeforeMethod
	public void cookies()
	{
		log.info("Cookies addedd successfully");
	}
	@Test
	(priority=1)
	public void registerTestpage() throws IOException, InterruptedException
	{
		Registertest trp = PageFactory.initElements(driver, Registertest.class);
		trp.regPage();
		
	}
	@Test
	(priority=2)
	public void cartdtest() throws IOException, InterruptedException
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Carttest trp = PageFactory.initElements(driver, Carttest.class);
		trp.addtocart();
		
	}
	
	@Test
	(priority=3)
	public void shopingtest() throws IOException, InterruptedException
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Shoppingcarttest trp = PageFactory.initElements(driver, Shoppingcarttest.class);
		
		trp.shoptest();
		
	}
	@Test
	(priority=4)
	public void checkouttest() throws IOException, InterruptedException
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    Checkouttest trp = PageFactory.initElements(driver, Checkouttest.class);
		
		trp.checkouttest();
		
	}
}
