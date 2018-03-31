package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ShopAmazonTest {

	WebDriver driver;

	public void invokeBrowser(String url) {
		try {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-fullscreen");
			driver = new ChromeDriver(options);

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

			driver.get(url);
			searchItem();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void searchItem() {
		try {
			invokeBrowser("https://www.amazon.co.uk");
			WebElement searchtxb = driver.findElement(By.id("twotabsearchtextbox"));
			searchtxb.clear();
			searchtxb.sendKeys("Le Crueset");
			WebElement searchbtn = driver
					.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input"));
			searchbtn.click();
			String strtitle = driver.getTitle();
			System.out.println("The title of Search Item is " + strtitle);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void filterPrime() {
		try {
			// Should be placed in another method or function - Select Prime and Casserole
			// Dishes
			driver.navigate().refresh();
			WebElement menuitem = driver.findElement(By.linkText("Casserole Dishes"));
			menuitem.click();
			driver.navigate().refresh();
			WebElement primechk = driver.findElement(By.name("s-ref-checkbox-419158031"));
			primechk.click();
			String strtitle1 = driver.getTitle();
			System.out.println("The title of Search Prime Item is " + strtitle1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectItem() {
		try {
			// Select Item from the display
			driver.navigate().refresh();
			WebElement item1 = driver
					.findElement(By.linkText("Le Creuset Stoneware Petite Round Casserole, 0.25 L - Volcanic"));
			item1.click();
			String strtitle2 = driver.getTitle();
			System.out.println("The title of Select Item is " + strtitle2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void optionAddItem() {
		try {
			// Select Colour
			WebElement selectcolour = driver.findElement(By.cssSelector("#a-autoid-14-announce"));
			Actions action = new Actions(driver);
			action.doubleClick(selectcolour).perform();
			Thread.sleep(3000);
			// Select Quantity from dropdown
			WebElement quantity = driver.findElement(By.name("quantity"));
			Select dropdown = new Select(quantity);
			dropdown.selectByValue("2");

			WebElement addtobasket = driver.findElement(By.id("add-to-cart-button"));
			addtobasket.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) {
		ShopAmazonTest atb = new ShopAmazonTest();
		// atb.invokeBrowser();
		atb.searchItem();
		atb.closeBrowser();
	}

}
