package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FilterPrimePage {
	
		WebDriver driver;
	
		// Declare elements
		By primechk = By.name("s-ref-checkbox-419158031");

		// Constructor
		public FilterPrimePage(WebDriver driver) {
			this.driver = driver;
		}

		public void clickPrime() {
			driver.findElement(primechk).click();
		}
		public void verifyItemPrimePage() {
			
			String expfpp="Amazon.co.uk: Le Crueset - Casserole Dishes / Baking Dishes: Home & Kitchen";
			String actualfpp=driver.getTitle();
			Assert.assertEquals(actualfpp, expfpp);
		}

}
