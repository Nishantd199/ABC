package TestNGClasses;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Browser.Base;
import POM.AmazonPage;
import POM.GooglePage;
import POM.LoginPage;

public class TestNg01 {
	public WebDriver driver;
	GooglePage page;
	LoginPage login;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	int testID;
	AmazonPage amazon;
	Utilities classe;
	@BeforeTest
	public void crossbrowsing(String browser)
	{
		
			System.out.println(browser);
			
			if(browser.equalsIgnoreCase("Chrome"))
			{
				driver=Base.openChromeBrowser();
			}
			if(browser.equalsIgnoreCase("Firefox"))
			{
				driver=Base.openFirefoxBrowser();
			}
			
		}

	
	@BeforeClass
	public void launchbrowser()
	{
		System.setProperty("webdriver.gecko.driver","src\\test\\resources\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    page=new GooglePage(driver);
	    login=new LoginPage(driver);
	    driver.manage().window().maximize();
	}
	@BeforeMethod
	public void loginpage() throws InterruptedException
	{
	    page.SearchBox();
		page.Search();
		page.AmazonLink();
	    login.SignButton(); 
	    login.EmailBox(" ");//enter the invalid email address then they check the error msg
	    login.ContinueButton();
	    login.Error();
	    
	 
	}
	@Test
	public void VerifyError() throws InterruptedException
	{
		testID =01;
		
		boolean result=login.Error().equals("There was a problem");
		if(result==true)
		{
			System.out.println("Correct Error");
		}
		else
		{
			System.out.println("Incorrect Error");
		}	
		

	}
	@AfterMethod
	public void logoutfromapplication(ITestResult result) throws InterruptedException
	{

		System.out.println("After the Method");
	    
	}
	@AfterClass
	public void closebrowser()
	{
		System.out.println("After the class");
	}
	@AfterTest
	public void close()
	{
		driver.close();
		System.out.println("After the Test");
		System.gc();
	}

}
//This Test class verify the Error msg after invalid email id Enter into box
