package BaseClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.HomePage;

public class BasePageClass extends BaseClass{
	public BasePageClass(WebDriver driver, ExtentTest logger) {
	super();
	}
	/******************************Open Application*******************************************/
	public  HomePage openApplication(String URL)
	{
		driver.get(URL);	
		logger.log(Status.INFO, "Opening the url");
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		HomePage home=new HomePage(driver,logger);
		PageFactory.initElements(driver,home);
		return home;

	}
	/******************************Get PageTitle*******************************************/
	public void getTitle(String expectedString)
	{
		try {
			Assert.assertEquals(driver.getTitle(), expectedString);
			//reportPass("Actual Title:"+driver.getTitle()+" -equals to Expected Title:"+expectedString);
		} catch (Exception e) {
			// TODO: handle exception
			//reportFail(e.getMessage());
		}
		
	}
	
	


}
