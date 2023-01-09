package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@class='desktop-searchBar']")
	private WebElement searchOption;
	
	public void enterProductName(String product) {
		searchOption.sendKeys(product);
		searchOption.sendKeys(Keys.ENTER);
		
	}

}
