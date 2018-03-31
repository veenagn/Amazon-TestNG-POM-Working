package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SelectItemPage {
	WebDriver driver;
	
	// Declare elements
	By item1 = By.linkText("Le Creuset Stoneware Petite Round Casserole, 0.25 L - Volcanic");

	// Constructor
	public SelectItemPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickItem() {
		driver.findElement(item1).click();
	}
	public void verifyItemPage() {
		String expitp="Le Creuset Stoneware Petite Round Casserole, 0.25 L - Volcanic: Amazon.co.uk: Kitchen & Home";
		String actualitp=driver.getTitle();
		Assert.assertEquals(actualitp, expitp);
	}

}
