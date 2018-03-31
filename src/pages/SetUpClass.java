package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;

public class SetUpClass {
	
	WebDriver driver;
	
	//Constructor
	public SetUpClass(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void invokeBrowser() {
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-fullscreen");
			driver = new ChromeDriver(options);

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void homePage() {
		driver.get("https://www.amazon.co.uk");
	}
	
	public void verifyHomePage() {
		System.out.println("The home page title is - " +driver.getTitle());
		//String expfpp="Amazon.co.uk: Le Crueset - Casserole Dishes / Baking Dishes: Home & Kitchen";
		//String actualfpp=driver.getTitle();
		//Assert.assertEquals(actualfpp, expfpp);
	}
}
