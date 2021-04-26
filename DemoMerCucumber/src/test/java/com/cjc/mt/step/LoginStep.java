package com.cjc.mt.step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class LoginStep {

	WebDriver driver;
	
	@Given("^user open \"(.*)\" browser$")
	public void openBrwoser(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.out.println("Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
			 driver=new ChromeDriver();

		}
		else
		{
			System.out.println("IE");
		}
			
	}
	@And("^user enter application url \"(.*)\"$")
	public void enterUrl(String url)
	{
	driver.get(url);
	System.out.println("Enter Url Success");
	}

}
