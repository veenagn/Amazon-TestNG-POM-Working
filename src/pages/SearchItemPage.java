package pages;

//This class will store all the locators and methods of home page

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchItemPage {
	
	WebDriver driver;
	
	//Declaring Web elements
	By searchtxb = By.id("twotabsearchtextbox");
	By searchbtn = By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input");
	
	//Creating Constructors
	public SearchItemPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Functions
	//Method or function to search for an item
	public void searchItem() {
		driver.findElement(searchtxb).sendKeys("Le Crueset");
		
	}
	//Method or function to click on the search button
	public void clickOnSearchBtn() {
		driver.findElement(searchbtn).click();
	}
	//Method or function to verify Home Page
	public void verifyHomePage() {
		String homepgtitle = driver.getTitle();
		Assert.assertEquals("Amazon.co.uk: Le Crueset", homepgtitle);
	}
}
