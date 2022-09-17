package com.Bolt.HomePage;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UIElementsFunctionalityTest {
	public static WebDriver driver;
	
	@BeforeMethod
	public  void loadBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://www.boltinsurance.com/");
		
	}
	@AfterMethod
	public  void closeBrowser() {
	driver.close();	
	}
	@Test
	public void verifyAllTabsInHomePageAreFunctional() {
	WebElement productsTab = driver.findElement(By.xpath("//span[text()='Products']"));	
	}
	
	
	//@Test(priority = 1)
	public void verifyProductsDropdownIsFunctionalOnMouseover() throws Exception {
		WebElement productsTab = driver.findElement(By.xpath("//span[text()='Products']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(productsTab).build().perform();
		WebElement boltExchangeEnterprise = driver.findElement(By.xpath("//a[text()='bolt Exchange Enterprise']"));
		Assert.assertTrue( boltExchangeEnterprise.isDisplayed());
		String boltExchangeEnterprisetext = boltExchangeEnterprise.getText();
		System.out.println(boltExchangeEnterprisetext);
		Assert.assertEquals(boltExchangeEnterprisetext, "bolt Exchange Enterprise");
	}
	//@Test(priority = 0)
	public void verifyBoltLogoIsDisplayed() {
	WebElement boltLogo = driver.findElement(By.xpath("//a[@class = 'css-1c9o8t5']"));
		
	Assert.assertTrue(boltLogo.isDisplayed());
	}
	
	//@Test 
	public void verifyInsightsTabIsClickable() throws Exception {
	driver.findElement(By.linkText("Insights")).click();
	WebElement insightsTab	= driver.findElement(By.xpath("//strong[text()='Insights']"));
	Assert.assertEquals(insightsTab.getText(),"Insights");
	WebElement boltLogo = driver.findElement(By.xpath("//a[@class = 'css-1c9o8t5']"));
	boltLogo.click();
	WebElement HomePageBodyInfoTexts = driver.findElement(By.xpath("//h3[@class = 'css-1mp05gq e2mba340']"));
	Assert.assertTrue(HomePageBodyInfoTexts.isDisplayed());
	Thread.sleep(2000);
	}
	
	@Test 
		public void verifyContact_usTabIsClickable() throws Exception {
		driver.findElement(By.linkText("Contact us")).click();
		WebElement Contact_usPagaText = driver.findElement(By.xpath("//strong[text()='How can we help you?']"));
		Assert.assertEquals(Contact_usPagaText.getText(), "How can we help you?");
		Thread.sleep(2000);
		WebElement boltLogo = driver.findElement(By.xpath("//a[@class = 'css-1c9o8t5']"));
		boltLogo.click();
		WebElement homePageInsuranceBanner = driver.findElement(By.id("insurance-banner"));
		Assert.assertTrue(homePageInsuranceBanner.isDisplayed());
		
}
	@Test
	public void verifyRequestademoTabIsFunctional() {
		WebElement RequestademoTab = driver.findElement(By.xpath("//span[text()='Request a demo']"));
		Assert.assertTrue(RequestademoTab.isEnabled());
		RequestademoTab.click();
		WebElement DemoPageBanner = driver.findElement(By.className("css-1mc0z82"));
		Assert.assertTrue( DemoPageBanner.isDisplayed());
	}
}
