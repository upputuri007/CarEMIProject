package PageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.BasePageClass;

public class Tools extends BasePageClass{

	public Tools(WebDriver driver, ExtentTest logger) {
		// TODO Auto-generated constructor stub
		super(driver,logger);
	}
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[13]/div/div/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[1]")
	WebElement loanOption;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[13]/div/div/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/h3")
	WebElement carLoanOption;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[13]/div/div/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/a")
	WebElement calculateBtn;
	
	public void LoanOptions() throws InterruptedException
	{
		loanOption.click();
		logger.log(Status.PASS,"loan option is clicked successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void CarLoanOption()
	{
		carLoanOption.click();
		logger.log(Status.PASS," car loan option is clicked successfully");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public LandingPage CarEmiCalulatorPage()
	{
		calculateBtn.click();

		logger.log(Status.PASS,"calculate button is clicked successfully");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LandingPage landing=new LandingPage(driver, logger);
		PageFactory.initElements(driver, landing);
		return landing;
	}
}
