package tests;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.HomePage;
import pageobjects.ProductPage;

public class SearchProduct extends Base {

	public WebDriver driver;
	public HomePage homePage;
	public ProductPage productPage;

	@AfterMethod
	public void close() {

		driver.quit();
	}

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {

		loadPropertiesFile();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}

	@Test
	public void verifySearchProduct() {
		homePage = new HomePage(driver);
		homePage.enterProductName(prop.getProperty("productName"));
		
		productPage = new ProductPage(driver);
		Assert.assertTrue(productPage.verifyProductTitle());
	}
	
	
	
}
