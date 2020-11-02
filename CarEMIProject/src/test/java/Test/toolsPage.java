package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import BaseClasses.BasePageClass;
import PageClasses.HomePage;
import PageClasses.Tools;
import Utilities.ReadFromExcel;

public class toolsPage extends BaseClass{
	public static String excel[]=new String[12];
	HomePage homePage;
	Tools toolsPage;
	
	public String[] Exceldata() throws IOException {
		excel=ReadFromExcel.readExcelData();
		return excel;
	}
	
	@Test(retryAnalyzer=RetryFailedTestCases.class)
	public void toolsPageTest() throws IOException, InterruptedException
	{
		logger=report.createTest("Testing toolsPage title");
		String[] kString = Exceldata();
		invokeBrowser("Mozila");
		BasePageClass basePageClass=new BasePageClass(driver, logger);
		homePage=basePageClass.openApplication(kString[4]);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		toolsPage=homePage.checkEmiEligibility();
		String title=driver.getTitle();
		System.out.println(title);
		assertEquals(title, "EMI Calculator - Calculate EMI online using Loan Calculator by HDFC Bank");
		
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}

