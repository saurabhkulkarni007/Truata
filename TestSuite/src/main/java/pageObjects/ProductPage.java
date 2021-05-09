package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Base {

	public WebDriver driver;
	private By productName = By.xpath("//h1/span[@class='product-name']");
	private By productPrice = By.xpath("//div[@class='current-price ']");
	private By topBuyNow = By.xpath("(//div[@class='product-buynow']/button)[1]");

	public ProductPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public String verifyProductName() {
		// TODO Auto-generated method stub
		return driver.findElement(productName).getText();

	}

	public String verifyProductPrice() {
		// TODO Auto-generated method stub
		return driver.findElement(productPrice).getText();
	}

	public void clickTopBuyNow() {
		// TODO Auto-generated method stub
		driver.findElement(topBuyNow).click();
	}

	public boolean validateCartPrice(String pName, String pPrice) {
		// TODO Auto-generated method stub
		By cartDetails = By.xpath("//h3/a[text()='" + pName + "']/../../..//div/span[text()='" + pPrice + ".00']");
		return driver.findElement(cartDetails).isDisplayed();
	}

	public void stopExecution() {
		driver.quit();
	}
}
