package com.cjc.dws.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cjc.dws.pages.RegisterPage1;

public class Registertest   {
	
		 
	WebDriver driver;
	static Logger log= Logger.getLogger(Registertest.class.getName());

	
	public Registertest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Test
	public void regPage() throws IOException, InterruptedException
	{
		RegisterPage1 rp = PageFactory.initElements(driver, RegisterPage1.class);
		
		FileInputStream fls= new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DataDrivenFrameworkProject\\src\\test\\resources\\Projectexcel.xlsx");
	
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
	}
}
