package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="mobileNumberPass")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	public void enterLoginCredentials(String emailid,String Password) {
		
		emailId.sendKeys(emailid);
		password.sendKeys(Password);
	}

	@FindBy(xpath="//button[.='LOGIN']")
	private WebElement loginButton;
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	
	@FindBy(xpath="(//span[@class='desktop-userTitle'])[3]")
	private WebElement bag;
	
	public void clickOnBag() {
		bag.click();
	}
	
	@FindBy(xpath="//div[@class='button-base-button emptyCart-base-wishlistButton ']")
	private WebElement NoItems;
	
	public boolean NoItemsInBag() {
		return NoItems.isDisplayed();
	}
	
	public void addItemFromWishlist() {
		NoItems.click();
	}
	

	@FindBy(xpath="(//a[@class='itemcard-moveToBag itemcard-boldFont'])[1]")
	private WebElement item;
	
	@FindBy(xpath="(//button[@class='sizeselect-sizeButton']//b)[1]")
	private WebElement size;
	
	@FindBy(xpath="//div[@class='sizeselect-done']")
	private WebElement done;
	
	public void addItemToBag() {
		item.click();
		size.click();
		done.click();
	}
	
	@FindBy(xpath="//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")
	private WebElement bagTwo;
	
	@FindBy(xpath="//div[@class='bulkActionStrip-message']")
	private WebElement itemAdded;
	
	public boolean checkBagIfItemAdded() {
		bagTwo.click();
		return itemAdded.isDisplayed();
		
	}
}
