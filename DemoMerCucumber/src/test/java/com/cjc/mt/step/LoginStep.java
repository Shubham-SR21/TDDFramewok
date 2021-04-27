package com.cjc.mt.step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep {

	WebDriver driver;
	
	@Given("^user open \"([^\"]*)\" browser$")
	public void user_open_browser(String browsername) throws Throwable {
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

	@Given("^user enter application url \"([^\"]*)\"$")
	public void user_enter_application_url(String url) throws Throwable {
		driver.get(url);
		System.out.println("Enter Url Success");
	}

	@Given("^enter user name as \"([^\"]*)\"$")
	public void enter_user_name_as(String uname) throws Throwable {
		System.out.println("Uname value"+uname);
		driver.findElement(By.cssSelector("body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(3) > form > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > input[type=text]")).sendKeys(uname);
		System.out.println("Enter User Name");
	   
	}

	@Given("^enter password as \"([^\"]*)\"$")
	public void enter_password_as(String pass) throws Throwable {
		driver.findElement(By.name("password")).sendKeys(pass);
		System.out.println("Enter Password");
	}

	@Then("^we get success page$")
	public void we_get_success_page() throws Throwable {
		driver.findElement(By.name("submit")).click();
		System.out.println("Enter Submit Button and get Success");
	    
	}
}
