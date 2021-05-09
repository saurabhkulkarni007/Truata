package regression;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Base;
import pageObjects.LandingPage;
import pageObjects.ProductPage;

public class TC_02_ValidateBestSellerProductPageTest2 extends Base {

	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("URL"));
	}

	@Test

	public void validateBestSellerProductPage() throws InterruptedException {
		LandingPage lp = new LandingPage(driver);
		String searchKeyword = prop.getProperty("SearchKey");
		String expName = prop.getProperty("NumberOneProduct");
		String expPrice = prop.getProperty("NumberOneProductPrice");
		lp.closeSignUpPopup();
		lp.findSearchField();
		lp.clickSearchField(searchKeyword);
		lp.clickMagnifierSearch();
		lp.openProduct();
		ProductPage pp=new ProductPage(driver);
		Assert.assertEquals(pp.verifyProductName(),expName);
		Assert.assertEquals(pp.verifyProductPrice(),expPrice);
		pp.clickTopBuyNow();
		Assert.assertTrue(pp.validateCartPrice(expName,expPrice));
		pp.stopExecution();
	}
}
