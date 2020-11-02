package PageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.BasePageClass;

public class Result extends BasePageClass{

	public Result(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//*[@class='emiamt ng-binding']")
	WebElement monthlyEMI;
	
	@FindBy(xpath = "//*[@id=\"carSpecs\"]/div/div[1]/div/span/span")
	WebElement errorMessageElement;
	
	
	
	public String mothlyEMIAmount()
	{
		String amount=monthlyEMI.getText();
		logger.log(Status.PASS, "Printing monthly emi amount");
		amount.replace("?","").trim();
		return 	amount;
		
	}
	public errorResult errorMessage()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String result=errorMessageElement.getText();
		result.replace("?", "").trim();
		System.out.println(result);
		logger.log(Status.PASS,"Printing the error message");
		errorResult errorResultpage = new errorResult(driver,logger) ;
		PageFactory.initElements(driver,errorResultpage);
		return errorResultpage;	
	}
	
	}
