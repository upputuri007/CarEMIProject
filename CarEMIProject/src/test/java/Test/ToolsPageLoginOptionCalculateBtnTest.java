package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import BaseClasses.BasePageClass;
import PageClasses.HomePage;
import PageClasses.LandingPage;
import PageClasses.Tools;
import Utilities.ReadFromExcel;

public class ToolsPageLoginOptionCalculateBtnTest extends BaseClass{
	public static String excel[]=new String[12];
	HomePage homePage;
	Tools toolsPage;
	LandingPage landingPage;
	
	public String[] Exceldata() throws IOException {
		excel=ReadFromExcel.readExcelData();
		return excel;
	}
	
	@Test(retryAnalyzer=RetryFailedTestCases.class)
	public void toolsPageLoginCalculateOptionTest() throws IOException, InterruptedException
	{
		logger=report.createTest("clicking car emi calculate button");
		String[] kString = Exceldata();
		invokeBrowser("Chrome");
		BasePageClass basePageClass=new BasePageClass(driver, logger);
		homePage=basePageClass.openApplication(kString[4]);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		toolsPage=homePage.checkEmiEligibility();
		toolsPage.LoanOptions();
		toolsPage.CarLoanOption();
		landingPage=toolsPage.CarEmiCalulatorPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String title=driver.getTitle();
		System.out.println(title);
		assertEquals(title, "Car Loan EMI Calculator - Calculate EMI for New Car Loan | HDFC Bank");
		
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
