package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import BaseClasses.BasePageClass;
import PageClasses.HomePage;
import Utilities.ReadFromExcel;

public class UrlTest extends BaseClass{
	public static String excel[]=new String[12];
	HomePage homePage;
	
	public String[] Exceldata() throws IOException {
		excel=ReadFromExcel.readExcelData();
		return excel;
	}
	
	@Test(retryAnalyzer=RetryFailedTestCases.class)
	public void UrlLinkTest() throws IOException
	{
		logger=report.createTest("checking url and page title");
		logger=report.createTest("clicking car emi calculate button");
		String[] kString = Exceldata();
		invokeBrowser("Mozila");
		BasePageClass basePageClass=new BasePageClass(driver, logger);
		homePage=basePageClass.openApplication(kString[4]);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String title=driver.getTitle();
		System.out.println(title);
		assertEquals(title, "HDFC Bank – Personal Banking & Netbanking Services");
		
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
