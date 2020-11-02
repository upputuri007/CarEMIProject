package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.BasePageClass;

public class errorResult extends BasePageClass{
	@FindBy(xpath = "//*[@id=\"carSpecs\"]/div/div[1]/div/div[1]/div[1]/span[1]")
	WebElement errorLoanAmount;
	
	
	@FindBy(xpath = "//*[@id=\"carSpecs\"]/div/div[1]/div/div[2]/div[1]/span[1]")
	WebElement errorLoanTerm;
	
	@FindBy(xpath = "//*[@id=\"carSpecs\"]/div/div[1]/div/div[3]/div[1]/span[1]")
	WebElement errorLoanInterest;
	
	@FindBy(xpath = "//*[@id='amt']")
	WebElement loanAmountElement;
	
	@FindBy(xpath = "//*[@id='int']")
	WebElement interestRateElement;
	
	@FindBy(xpath = "//*[@id='years']")
	WebElement loanTermElement;

	public errorResult(WebDriver driver, ExtentTest logger) {
		// TODO Auto-generated constructor stub
		super(driver,logger);
	}

	public String errorLoanAmount()
	{
		loanAmountElement.click();
		logger.log(Status.PASS,"Clicking on error loan amount box");
		String errorAmount=errorLoanAmount.getText();
		return errorAmount;
	}
	
	public String errorLoanTerm()
	{
		loanTermElement.click();
		logger.log(Status.PASS,"Clicking on error loan term box");
		String errorTerm=errorLoanTerm.getText();
		return errorTerm;
	}
	
	public String errorLoanInterest()
	{
		interestRateElement.click();
		logger.log(Status.PASS,"Clicking on error loan interest box");
		String errorInterest=errorLoanInterest.getText();
		return errorInterest;
	}

}
