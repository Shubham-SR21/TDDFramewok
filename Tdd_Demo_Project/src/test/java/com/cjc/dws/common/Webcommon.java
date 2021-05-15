package com.cjc.dws.common;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cjc.dws.pages.RegisterPage1;

public class Webcommon {


	static WebDriver driver;

	static Logger log= Logger.getLogger(RegisterPage1.class.getName());
	
	public static WebDriver OpenBrowser() throws IOException
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chormodriver\\chromedriver.exe");
		  driver = new ChromeDriver(); 
		  log.info("Open Chrome");
		  return driver;
	}
	
	public static void openURL()
	{
		driver.get("http://demowebshop.tricentis.com/register");
		log.info("Open URL");
		driver.manage().window().maximize();
	}
	
}
