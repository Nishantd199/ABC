package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
	WebDriver driver;
	@FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
	private WebElement productsearch; //Search box
	
	@FindBy(xpath="//input[@id=\"nav-search-submit-button\"]")
	private WebElement search;//Search button
	
	public AmazonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ProductSearch()
	{
		productsearch.click();
		productsearch.sendKeys("Trimer");//Search for trimmer
	}
	public void Search()
	{
		search.click();//click action on search
	}
	

}
