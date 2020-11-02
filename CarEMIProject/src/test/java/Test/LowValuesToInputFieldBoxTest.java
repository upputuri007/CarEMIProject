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

public class LowValuesToInputFieldBoxTest extends BaseClass{
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
	public void Test() throws IOException, InterruptedException
	{
		logger=report.createTest("Low Values To Input Field Box Test");			//creating extent report
		String[] kString = Exceldata();											//Getting data from excel
		invokeBrowser("Mozila");												//Invoking browser
		BasePageClass basePageClass=new BasePageClass(driver, logger);
		homePage=basePageClass.openApplication(kString[8]);						//opening url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		toolsPage=homePage.checkEmiEligibility();								//clicking on emi eligibility option
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		toolsPage.LoanOptions();
		toolsPage.CarLoanOption();
		landingPage=toolsPage.CarEmiCalulatorPage();
		landingPage.setCarType();
		landingPage.setLoanAmount(kString[9]);
		landingPage.setloanTerm(kString[10]);
		landingPage.setinterestRate(kString[11]);
		result=landingPage.calculate();
		System.out.println(result.mothlyEMIAmount());
		
		System.out.println("Printing the error message");
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

