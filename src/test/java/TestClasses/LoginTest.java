package TestClasses;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.AmazonPage;
import POM.GooglePage;
import POM.LogOut;
import POM.LoginPage;
import POM.TrimmerPage;


public class LoginTest{
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");//open the browser
		driver.manage().window().maximize();//maximize the browser
		GooglePage page=new GooglePage(driver);
		page.SearchBox();
		page.Search();
		page.AmazonLink();
		LoginPage login=new LoginPage(driver);
		login.SignButton();
		login.EmailBox(" ");//Enter the invalid Email Address
		login.ContinueButton();
		login.Error();
		boolean result=login.Error().equals("There was a problem");
		if(result==true)
		{
			System.out.println("Correct Error");
		}
		else
		{
			System.out.println("Incorrect Error");
		}
		driver.navigate().back();
		driver.navigate().refresh();
		login.EmailBox(" ");//Email address enter here
		login.ContinueButton();
		login.Password(" ");//Enter the password here 
		login.Submit();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		AmazonPage amazonpage=new AmazonPage(driver);
		amazonpage.ProductSearch();
		amazonpage.Search();
		
		TrimmerPage trimmerpage=new TrimmerPage(driver);
		trimmerpage.Philipstrimmer();
		System.out.println("Curent url is:- "+ driver.getCurrentUrl());
		System.out.println("Title of page is:- "+ driver.getTitle());
		
		Thread.sleep(2000);
		LogOut logout=new LogOut(driver);
		logout.All();
		logout.SignOut();
		driver.quit();
		
	}
}