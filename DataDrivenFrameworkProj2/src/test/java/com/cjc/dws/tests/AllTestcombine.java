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
import org.testng.annotations.Test;
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
		 FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProj2\\src\\test\\java\\com\\cjc\\dws\\utility\\Prop.properties"); 
		  pro.load(fis); // driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chormodriver\\chromedriver.exe");
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
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void cookies()
	{ 
		log.info("Cookies addedd successfully");
	}
	
	
	@Test(priority = 1)
	public void regPage() throws IOException, InterruptedException
	{
		RegisterPage1 rp = PageFactory.initElements(driver, RegisterPage1.class);
		
		FileInputStream fls= new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProj2\\src\\test\\resources\\Projectexcel.xlsx");
	
		XSSFWorkbook xsw = new XSSFWorkbook(fls);
		XSSFSheet sheet = xsw.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		log.info("Row count: "+rowcount);
		for(int i=1;i<rowcount;i++)
		{	
			XSSFRow row = sheet.getRow(i);
			XSSFCell col0 =row.getCell(0);
			XSSFCell col1 =row.getCell(1);
			XSSFCell col2 =row.getCell(2);
			XSSFCell col3 =row.getCell(3);
			XSSFCell col4 =row.getCell(4);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try
			{
				String fname= col0.getStringCellValue();
				log.info("first Name: "+fname);	
				String lname= col1.getStringCellValue();
				log.info("Last Name: "+lname);
				String email= col2.getStringCellValue();
				log.info("Email: "+email);
				String pword= col3.getStringCellValue();
				log.info("Password: "+pword);
				String cword= col4.getStringCellValue();
				log.info("Confirm Password: "+cword);
				
				rp.gender();
				rp.regData(fname, lname, email, pword, cword);
				rp.regisbutton();

				
			}
			catch (Exception e) {
				System.out.println("Null Pointer Exception handle");
					}
			
					
		}
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
