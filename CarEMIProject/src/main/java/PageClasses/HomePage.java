package PageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.BasePageClass;

public class HomePage extends BasePageClass{

	public HomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[13]/div[1]/div/div/div[2]/div[2]/div[3]/div/div/div/div/div/div/p/strong")
	WebElement checkEMI;
	
	@FindBy(xpath = "//*[@class='popupCloseButton']")
	WebElement popUp;
	
	//driver.switchTo().alert.close;
	
	
	
	public Tools checkEmiEligibility()
	{
		try {
			popUp.click();
			Thread.sleep(2000);
			logger.log(Status.PASS,"Pop up is closed successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("No pop up present");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		checkEMI.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.log(Status.PASS, "clicked check eligibility successfully");
		
		Tools toolsPage = new Tools(driver,logger) ;
		PageFactory.initElements(driver,toolsPage);
		return toolsPage;
	}
	
}
