package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import BaseClasses.BasePageClass;
import PageClasses.HomePage;
import PageClasses.LandingPage;
import PageClasses.Result;
import PageClasses.Tools;
import Utilities.ReadFromExcel;


public class InputsToFieldsTest extends BaseClass{		//inputs to the field
	public static String excel[]=new String[12];
	HomePage homePage;
	Tools toolsPage;
	LandingPage landingPage;
	Result result;
	
	public String[] Exceldata() throws IOException {	//returning data from excel
		excel=ReadFromExcel.readExcelData();
		return excel;
	}
	
	@Test(retryAnalyzer=RetryFailedTestCases.class)
	public void Test1() throws IOException, InterruptedException
	{
		logger=report.createTest("Inputs to fields");							//creating extent report
		String[] kString = Exceldata();
		
		invokeBrowser("Mozila");												//invoke browser
		BasePageClass basePageClass=new BasePageClass(driver, logger);
		homePage=basePageClass.openApplication(kString[4]);						//Opening the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		toolsPage=homePage.checkEmiEligibility();								//clicking emi eligibility option
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		toolsPage.LoanOptions();												//clicking on loan option
		toolsPage.CarLoanOption();
		landingPage=toolsPage.CarEmiCalulatorPage();
		landingPage.setCarType();												//setting car type
		landingPage.setLoanAmount(kString[5]);									//entering the loan amount
		landingPage.setloanTerm(kString[6]);									//entering the loan term
		landingPage.setinterestRate(kString[7]);								//entering interest percentage
		result=landingPage.calculate();
		System.out.println("Printing the monthly emi:"+result.mothlyEMIAmount());							//Printing montly emi
		Assert.assertTrue(true);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
