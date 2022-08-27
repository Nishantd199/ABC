package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
	WebDriver driver;
	
	@FindBy(xpath="(//div[@class=\"nav-left\"]//a)[3]")
	private WebElement all;//click on All Section
	
	@FindBy(xpath="//a[text()=\"Sign Out\"]")
	private WebElement signout;//Click on Signout
	
	public LogOut(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void All()
	{
		all.click();
	}
	public void SignOut()
	{
		signout.click();
	}

}
