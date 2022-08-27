package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrimmerPage {
	WebDriver driver;
	@FindBy(xpath="(//div[@class=\"a-section a-spacing-base\"]//h2)[1]")
	private WebElement philipstrimer;//Click on Philipstrim page
	
	public TrimmerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Philipstrimmer()
	{
		philipstrimer.click();
	}

}
