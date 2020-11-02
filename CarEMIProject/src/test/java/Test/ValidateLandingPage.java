package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import BaseClasses.BasePageClass;
import PageClasses.HomePage;
import PageClasses.LandingPage;
import PageClasses.Result;
import PageClasses.Tools;
import PageClasses.validateLandingPageValues;
import Utilities.ReadFromExcel;

public class ValidateLandingPage extends BaseClass{
	public static String excel[]=new String[12];
	public static String lCarType;
	public static String lAmount;
	public static String lTerm;
	public static String lInterest;
	HomePage homePage;
	Tools toolsPage;
	LandingPage landingPage;
	Result result;
	
	
	public String[] Exceldata() throws IOException {
		excel=ReadFromExcel.readExcelData();
		return excel;
	}
	
	@Test(retryAnalyzer=RetryFailedTestCases.class)
	public void Test1() throws IOException, InterruptedException
	{
		logger=report.createTest("validating values entered into input fields");
		String[] kString = Exceldata();
		invokeBrowser("Mozila");
		BasePageClass basePageClass=new BasePageClass(driver, logger);
		homePage=basePageClass.openApplication(kString[4]);
		toolsPage=homePage.checkEmiEligibility();
		toolsPage.LoanOptions();
		toolsPage.CarLoanOption();
		landingPage=toolsPage.CarEmiCalulatorPage();
		landingPage.setCarType();
		landingPage.setLoanAmount(kString[5]);
		landingPage.setloanTerm(kString[6]);
		landingPage.setinterestRate(kString[7]);
		result=landingPage.calculate();
		
		System.out.println(result.mothlyEMIAmount());
		
		validateLandingPageValues validate=new validateLandingPageValues(driver, logger);
		lAmount=validate.getLoanAmount();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lTerm=validate.getLoanTerm();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lInterest=validate.getInterestRate();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
			Assert.assertEquals(lAmount, kString[5]);
			Assert.assertEquals(lTerm, kString[6]);
			Assert.assertEquals(lInterest, kString[7]);
			
			
			
			Assert.assertTrue(true);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}

