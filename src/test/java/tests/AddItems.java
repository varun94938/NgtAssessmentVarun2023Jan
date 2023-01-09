package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.LoginPage;

public class AddItems extends Base {

	public WebDriver driver;
	public LoginPage loginPage;

	@AfterMethod
	public void close() {

		driver.quit();
	}

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {

		loadPropertiesFile();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("urlTwo"));

	}

	@Test
	public void addItems() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.enterLoginCredentials(prop.getProperty("emailId"), prop.getProperty("password"));
		loginPage.clickOnLoginButton();
		Thread.sleep(35000);
		loginPage.clickOnLoginButton();
		Thread.sleep(5000);
		loginPage.clickOnBag();
		Thread.sleep(2000);
		
		if(loginPage.NoItemsInBag()) {
			loginPage.addItemFromWishlist();
			Thread.sleep(3000);
			loginPage.addItemToBag();
			Thread.sleep(3000);
			Assert.assertTrue(loginPage.checkBagIfItemAdded());
		}
		else {
			Assert.assertTrue(true);
		}
		
		
	}
}
