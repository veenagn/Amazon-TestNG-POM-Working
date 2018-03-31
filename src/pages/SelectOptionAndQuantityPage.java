package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectOptionAndQuantityPage {

	WebDriver driver;
	// Declare elements

	By addtobasket = By.id("add-to-cart-button");

	// Constructor
	public SelectOptionAndQuantityPage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods
	public void selectColour() throws InterruptedException {
		// Select Colour
		WebElement selectcolour = driver.findElement(By.cssSelector("#a-autoid-14-announce"));
		Actions action = new Actions(driver);
		action.doubleClick(selectcolour).perform();
		Thread.sleep(3000);
	}

	public void selectQuantity() {
		// Select Quantity from dropdown
		WebElement quantity = driver.findElement(By.name("quantity"));
		Select dropdown = new Select(quantity);
		dropdown.selectByValue("2");
	}

	public void addToBasket() {
		driver.findElement(addtobasket).click();
	}

	public void verfiySigninPage() {
		System.out.println("The title of the sign in page is: " + driver.getTitle());
	}
}
