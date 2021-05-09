package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends Base {

	public WebDriver driver;
	private By searchField = By.xpath("//input[@name='search-field']");
	private By magnifireSearch = By.xpath("//span[@id='magnifier-search']");
	private By productTitle = By.xpath("//span[text()='No 1 Bestseller']/../..//h3[@class='producttitle']");
	private By productPrice = By.xpath("//span[text()='No 1 Bestseller']/../..//div[@class='currentprice ']");
	private By closeSignUpPopup = By.xpath("//div[@id='crmSignUp']//i");


	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public WebElement findSearchField() {
		return driver.findElement(searchField);
	}

	public void clickSearchField(String searchKeyword) {
		driver.findElement(searchField).sendKeys("" + searchKeyword + "");
	}

	public void clickMagnifierSearch() {
		driver.findElement(magnifireSearch).click();
	}

	/*
	 * public void navigateToSearch(String searchKeyword) {
	 * driver.findElement(By.xpath("//input[@name='search-field']")).sendKeys("" +
	 * searchKeyword + "");
	 * driver.findElement(By.xpath("//span[@id='magnifier-search']")).click(); }
	 */

	public String validateNumOneProductName() {
		return driver.findElement(productTitle).getText();
	}

	public String validateNumOneProductPrice() {
		return driver.findElement(productPrice).getText();
	}

	public void closeSignUpPopup() {
		driver.findElement(closeSignUpPopup).click();
	}
	
	public void openProduct() {
		// TODO Auto-generated method stub
		driver.findElement(productTitle).click();
		
	}

	public void stopExecution() {
		driver.quit();
	}
}
