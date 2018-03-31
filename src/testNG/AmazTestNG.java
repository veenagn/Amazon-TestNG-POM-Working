package testNG;

import org.testng.annotations.Test;

import pages.FilterItemPage;
import pages.FilterPrimePage;
import pages.SearchItemPage;
import pages.SelectItemPage;
import pages.SelectOptionAndQuantityPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class AmazTestNG {
	
	WebDriver driver;
	
	@Test(priority=0)
	public void verifySearchItem() {
		SearchItemPage home = new SearchItemPage(driver);
		home.searchItem();
		home.clickOnSearchBtn();
		home.verifyHomePage();
	}
	
	@Test(priority=1)
	public void verifyFilterItem() {
		FilterItemPage fip = new FilterItemPage(driver);
		fip.clickfilterItem();
		fip.verifyFilterItemPage();
	}
	
	@Test(priority=2)
	public void verifyPrimeItem() {
		FilterPrimePage fpp = new FilterPrimePage(driver);
		fpp.clickPrime();
		fpp.verifyItemPrimePage();
	}
	
	@Test(priority=3)
	public void verifySelectItem() {
		SelectItemPage sip = new SelectItemPage(driver);
		sip.clickItem();
		sip.verifyItemPage();
	}
	
	@Test(priority=4)
	public void verifyAddToBasket() throws InterruptedException {
		SelectOptionAndQuantityPage soqp = new SelectOptionAndQuantityPage(driver);
		soqp.selectColour();
		soqp.selectQuantity();
		soqp.addToBasket();
		soqp.verfiySigninPage();
	}
	@BeforeMethod
	public void refreshPage() {
		driver.navigate().refresh();
	}
	  
  @BeforeClass
  public void HomePage() {
		try {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-fullscreen");
			driver = new ChromeDriver(options);

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("https://www.amazon.co.uk");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

  @AfterClass
  public void closeBrowser() {
		driver.close();
		System.out.println("Closing the browser - End Test");
	}

}
