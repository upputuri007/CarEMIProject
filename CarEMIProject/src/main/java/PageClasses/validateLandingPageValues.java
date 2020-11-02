package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import BaseClasses.BasePageClass;

public class validateLandingPageValues extends BasePageClass {
	
	public validateLandingPageValues(WebDriver driver,ExtentTest logger) {
		// TODO Auto-generated constructor stub
		super(driver,logger);
	}
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[13]/div[2]/div/div/div/div/div/div[1]/div[1]/div[3]/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div/form/input[1]")
	WebElement carTypeElement;
//	
//	@FindBy(xpath = "//*[@id='amt']")
//	WebElement loanAmountElement;
//	
//	@FindBy(xpath = "//*[@id='int']")
//	WebElement interestRateElement;
//	
//	@FindBy(xpath = "//*[@id='years']")
//	WebElement loanTermElement;
//	
//	@FindBy(xpath = "//*[@id=\"carSpecs\"]/div/div[1]/div/div[5]/a")
//	WebElement calculateElement;
	
	
	public String getCarType()
	{
		
		return carTypeElement.getAttribute("value");
	}
	
	public String getLoanAmount()
	{
		return driver.findElement(By.id("amt")).getAttribute("value");
	}
	
	public String getInterestRate()
	{
		return driver.findElement(By.id("int")).getAttribute("value");
	}
	
	public String getLoanTerm()
	{
		return driver.findElement(By.id("years")).getAttribute("value");
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
}
