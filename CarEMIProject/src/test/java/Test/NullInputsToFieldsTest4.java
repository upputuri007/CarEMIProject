package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import BaseClasses.BasePageClass;
import PageClasses.HomePage;
import PageClasses.LandingPage;
import PageClasses.Result;
import PageClasses.Tools;
import PageClasses.errorResult;
import Utilities.ReadFromExcel;

public class NullInputsToFieldsTest4 extends BaseClass {
	public static String excel[]=new String[12];
	HomePage homePage;
	Tools toolsPage;
	LandingPage landingPage;
	Result result;
	errorResult errorResul;
	
	public String[] Exceldata() throws IOException {
		excel=ReadFromExcel.readExcelData();
		return excel;
	}
	
	@Test(retryAnalyzer=RetryFailedTestCases.class)
	public void TestNullInput() throws IOException, InterruptedException
	{
		logger=report.createTest("Null inputs to interest input fields");
		String[] kString = Exceldata();
		invokeBrowser("Mozila");
		BasePageClass basePageClass=new BasePageClass(driver, logger);
		homePage=basePageClass.openApplication(kString[4]);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		toolsPage=homePage.checkEmiEligibility();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		toolsPage.LoanOptions();
		toolsPage.CarLoanOption();
		landingPage=toolsPage.CarEmiCalulatorPage();
		landingPage.setCarType();
		landingPage.setLoanAmount(kString[5]);
		landingPage.setinterestRate("");
		landingPage.setloanTerm(kString[6]);
		result=landingPage.calculate();
		errorResul=result.errorMessage();
		System.out.println(errorResul.errorLoanInterest());
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
