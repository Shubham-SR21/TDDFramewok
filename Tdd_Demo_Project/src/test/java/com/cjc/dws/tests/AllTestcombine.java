package com.cjc.dws.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cjc.dws.common.Webcommon;
import com.cjc.dws.pages.Addtocart;
import com.cjc.dws.pages.CheckoutProcess;
import com.cjc.dws.pages.RegisterPage1;
import com.cjc.dws.pages.Shoppingcart;

@Listeners(com.cjc.dws.tests.Isuite_ItestListener.class)
public class AllTestcombine {
	
	WebDriver driver;
	static Logger log= Logger.getLogger(AllTestcombine.class.getName());
	Properties pro= new Properties();



	@BeforeSuite
	public void openBrowser() throws IOException
	{
		driver=Webcommon.OpenBrowser();
	}
	@BeforeTest
	public void openURL()
	{
		Webcommon.openURL();
	}

	
	
	@Test(priority = 1)
	@Parameters({"fname","lastname","email","password","Cpass"})
	public void regPage(String lastname, String fname, String email, String password, String Cpass) throws IOException, InterruptedException
	{
		RegisterPage1 rp = PageFactory.initElements(driver, RegisterPage1.class);
		
		rp.gender();
		
		rp.regData(fname, lastname, email, password, Cpass);
			
		rp.regisbutton();
		
			
					
		}
	
	@Test(priority = 2)
	public void addtocart() throws IOException, InterruptedException
	{
		
		Addtocart addcart= PageFactory.initElements(driver, Addtocart.class);
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProj2\\src\\test\\java\\com\\cjc\\dws\\utility\\Prop.properties");
		pro.load(fis);
		addcart.cartitem(pro.getProperty("size"));
	}
	@Test(priority = 3)
	public void shoptest() throws IOException, InterruptedException
	{
		Shoppingcart rp = PageFactory.initElements(driver, Shoppingcart.class);
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProj2\\src\\test\\java\\com\\cjc\\dws\\utility\\Prop.properties"); 
		pro.load(fis);
		rp.cartclick();
		Thread.sleep(3000);
		rp.shopdata(pro.getProperty("Countrybill"), pro.getProperty("Zipcode"));
		Thread.sleep(3000);
		rp.shopingdata();
		
		
	}
	@Test(priority = 4)
	public void checkouttest() throws IOException, InterruptedException
	{
		CheckoutProcess rp = PageFactory.initElements(driver, CheckoutProcess.class);
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProj2\\src\\test\\java\\com\\cjc\\dws\\utility\\Prop.properties"); 
		pro.load(fis);
		rp.Checkoutdata(pro.getProperty("Companyname"), pro.getProperty("Countrybill"), pro.getProperty("Cityname"), 
				        pro.getProperty("addr1"),pro.getProperty("addr2"),pro.getProperty("Zipcode"),pro.getProperty("Mobno"));
		Thread.sleep(3000);
		rp.pickup();
		Thread.sleep(3000);
		rp.orderno();
		
		
	}
	
}
