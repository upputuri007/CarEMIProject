package PageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.BasePageClass;

public class LandingPage extends BasePageClass{

	public LandingPage(WebDriver driver, ExtentTest logger) {
		// TODO Auto-generated constructor stub
		super(driver,logger);
	}
		
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[13]/div[2]/div/div/div/div/div/div[1]/div[1]/div[3]/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div/form/input[1]")
	WebElement carTypeElement;
	
	@FindBy(xpath = "//*[@id='amt']")
	WebElement loanAmountElement;
	
	@FindBy(xpath = "//*[@id='int']")
	WebElement interestRateElement;
	
	@FindBy(xpath = "//*[@id='years']")
	WebElement loanTermElement;
	
	@FindBy(xpath = "//*[@id=\"carSpecs\"]/div/div[1]/div/div[5]/a")
	WebElement calculateElement;
	
	
	public void setCarType() {
		carTypeElement.click();
		logger.log(Status.PASS,"Selecting the car Type i.e pre-owned or new car");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void setLoanAmount(String amount)
	{
		loanAmountElement.clear();
		loanAmountElement.sendKeys(amount);
		logger.log(Status.PASS, "Inserting the loan Amount");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	public void setinterestRate(String interest)
	{
		interestRateElement.clear();
		interestRateElement.sendKeys(interest);
		logger.log(Status.PASS,"Inserting Interest rate");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void setloanTerm(String term)
	{
		loanTermElement.clear();
		loanTermElement.sendKeys(term);
		logger.log(Status.PASS, "Inserting the loan term");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public Result calculate()
	{
		calculateElement.click();
		logger.log(Status.PASS, "Clicking on calculate button");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Result resultpage = new Result(driver,logger) ;
		PageFactory.initElements(driver,resultpage);
		return resultpage;
	}
}
