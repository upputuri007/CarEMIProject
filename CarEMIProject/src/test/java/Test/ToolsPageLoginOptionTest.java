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

public class ToolsPageLoginOptionTest extends BaseClass{
	public static String excel[]=new String[12];
	HomePage homePage;
	Tools toolsPage;
	
	public String[] Exceldata() throws IOException {
		excel=ReadFromExcel.readExcelData();
		return excel;
	}
	
	@Test(retryAnalyzer=RetryFailedTestCases.class)
	public void toolsPageLoginOptionTest() throws IOException, InterruptedException
	{
		logger=report.createTest("clicking loan option");
		String[] kString = Exceldata();
		invokeBrowser("Mozila");
		BasePageClass basePageClass=new BasePageClass(driver, logger);
		homePage=basePageClass.openApplication(kString[4]);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		toolsPage=homePage.checkEmiEligibility();
		toolsPage.LoanOptions();
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

