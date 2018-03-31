package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FilterItemPage {
	WebDriver driver;

	// Declare elements
	By menuitem = By.linkText("Casserole Dishes");

	// Constructor
	public FilterItemPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickfilterItem() {
		driver.findElement(menuitem).click();
	}
	public void verifyFilterItemPage() {
		
		String expfit="Amazon.co.uk: Le Crueset";
		String actualfit=driver.getTitle();
		Assert.assertEquals(actualfit, expfit);
	}
	
}
