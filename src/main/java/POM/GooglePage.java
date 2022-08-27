package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage{
	WebDriver driver;
	
	@FindBy(xpath="//input[@type=\"text\"]")
	private WebElement searchbox;//search box of googlr
	
	@FindBy(xpath="(//input[@value=\"Google Search\"])[1]")
	private WebElement search;//click on search button
	
	@FindBy(xpath="(//div[@class=\"yuRUbf\"]//h3)[1]")
	private WebElement amazonlink;
	
	public GooglePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void SearchBox()
	{
		searchbox.click();
		searchbox.sendKeys("Amazon.in");
	}
	public void Search()
	{
		search.click();
	}
	public void AmazonLink()
	{
		amazonlink.click();
	}
}