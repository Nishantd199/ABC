package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath="((//div[@class=\"nav-right\"])[2]//span)[6]")
	private WebElement signbutton;//Enter for Sign button
	
	@FindBy(xpath="//input[@type=\"email\"]")
	private WebElement emailbox;//Address of email box
	
	@FindBy(xpath="//input[@id=\"continue\"]")
	private WebElement continuebutton; //click on continue button
	
	@FindBy(xpath="//div[@class=\"a-box-inner a-alert-container\"]//h4")
	private WebElement error;//click on Error
	
	@FindBy(xpath="//input[@type=\"password\"]")
	private WebElement password;//Enter the password when Valid Email id Enter 
	
	@FindBy(xpath="//input[@id=\"signInSubmit\"]")
	private WebElement submit;//click on submit
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void SignButton()
	{
		signbutton.click();
	}
	public void EmailBox(String name)
	{
		emailbox.click();
		emailbox.sendKeys(name);
	}
	public void ContinueButton()
	{
		continuebutton.click();
	}
	public String Error()
	{
		error.click();
		String test=error.getText().toString();
		return test;
	}
	public void Password(String pass)
	{
		password.click();
		password.sendKeys(pass);//Enter the password in this field
	}
	public void Submit()
	{
		submit.click();
	}

}
