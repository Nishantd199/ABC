package TestNGClasses;

import java.util.concurrent.TimeUnit;

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
import POM.LogOut;
import POM.LoginPage;
import POM.TrimmerPage;


public class TestNg02 {
	public WebDriver driver;
	GooglePage page;
	TrimmerPage trimmerpage;
	LoginPage login;
	AmazonPage amazonpage;
	LogOut logout;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	int testID;
	@BeforeClass
//	@Parameters ("browserName")
//	public void crossbrowsing(String browser)
//	{
//		
//			System.out.println("browser");
//			
//			if(browser.equalsIgnoreCase("Chrome"))
//			{
//				driver=Base.openChromeBrowser();
//			}
//			if(browser.equalsIgnoreCase("Firefox"))
//			{
//				driver=Base.openFirefoxBrowser();
//			}
//		}
	public void launchbrowser()
	{
		System.setProperty("webdriver.gecko.driver","src\\test\\resources\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	    page=new GooglePage(driver);
	    login=new LoginPage(driver);
	    amazonpage=new AmazonPage(driver);
	    trimmerpage=new TrimmerPage(driver);
	    logout=new LogOut(driver);
	}
	@BeforeMethod
	public void loginpage() throws InterruptedException
	{
	    page.SearchBox();
		page.Search();
		page.AmazonLink();
	    login.SignButton(); 
		login.EmailBox(" ");//Enter the valid email address
		login.ContinueButton();
		login.Password(" "); //Enter the valid password 
		login.Submit();
		amazonpage.ProductSearch();
		amazonpage.Search();
		trimmerpage.Philipstrimmer();
	}
		@Test 
		public void TestUrl()
		{
			System.out.println("Curent url is:- "+ driver.getCurrentUrl());
			System.out.println("Title of page is:- "+ driver.getTitle());
		}
		@AfterMethod
		public void logoutfromapplication(ITestResult result) throws InterruptedException
		{
//			Thread.sleep(3000);
//			logout=new LogOut(driver);
//			logout.All();
//			logout.SignOut();
		}
		@AfterClass
		public void closebrowser()
		{
			page=null;
			trimmerpage=null;
			amazonpage=null;
			logout=null;
			login=null;
		}
		@AfterTest
		public void close()
		{
			driver.quit();
			driver=null;
			System.gc();
		}
	    
	 
	}
//This test class check the Title and url of page is correct or not.


