package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
public WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//h1[contains(text(),'Kurtas')]")
	private WebElement productTitle;
	
	public boolean verifyProductTitle() {
		return productTitle.isDisplayed();
	}
	
	

}
