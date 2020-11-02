 package BaseClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReportManager;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports report=ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	
	
	/******************************Invoke Browser *******************************************/
	public WebDriver invokeBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Chrome")) 
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver83.exe");
				driver = new ChromeDriver(options);
				logger.log(Status.INFO,"opening chrome");
			} 
			else if (browserName.equalsIgnoreCase("Mozila")) 
			{
				FirefoxOptions options=new FirefoxOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver(options);
				logger.log(Status.INFO,"opening Firefox");
			}
			else {
				System.out.println("Invalid Choice");
				logger.log(Status.INFO,"Invalid Choice");
			}
		} catch (Exception e) 
		{
			//reportFail(e.getMessage());
			System.out.println(e.getMessage());
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		return driver;
	}

	
	
	

	/******************************Closing the Extent Report*******************************************/
	@AfterMethod
	public void flushReport()
	{
		report.flush();
	}

}
