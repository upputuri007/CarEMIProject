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

public class NullInputsToFieldsTest1 extends BaseClass {
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
		logger=report.createTest("Null inputs to input fields");
		String[] kString = Exceldata();
		invokeBrowser("Chrome");
		BasePageClass basePageClass=new BasePageClass(driver, logger);
		homePage=basePageClass.openApplication(kString[4]);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		toolsPage=homePage.checkEmiEligibility();
		toolsPage.LoanOptions();
		toolsPage.CarLoanOption();
		landingPage=toolsPage.CarEmiCalulatorPage();
		landingPage.setCarType();
		landingPage.setLoanAmount("");
		landingPage.setloanTerm("");
		landingPage.setinterestRate("");
		result=landingPage.calculate();
		errorResul=result.errorMessage();

		System.out.println(errorResul.errorLoanAmount());
		System.out.println(errorResul.errorLoanInterest());
		System.out.println(errorResul.errorLoanTerm());
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}


}
