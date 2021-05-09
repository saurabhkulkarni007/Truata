package regression;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Base;
import pageObjects.LandingPage;

public class TC_01_ValidateBestSellerTest extends Base {

	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("URL"));
	}

	@Test

	public void validateBestSeller() throws InterruptedException {
		LandingPage lp = new LandingPage(driver);
		String searchKeyword = prop.getProperty("SearchKey");
		String expName = prop.getProperty("NumberOneProduct");
		String expPrice = prop.getProperty("NumberOneProductPrice");
		lp.closeSignUpPopup();
		lp.findSearchField();
		lp.clickSearchField(searchKeyword);
		lp.clickMagnifierSearch();
		Assert.assertEquals(lp.validateNumOneProductName(), expName);
		Assert.assertEquals(lp.validateNumOneProductPrice(), expPrice);
		lp.stopExecution();
	}
}
