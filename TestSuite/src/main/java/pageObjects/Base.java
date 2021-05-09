package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\PageObjects\\gift.properties");
		prop.load(fis);


		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		// Uses data.properties values for browser field

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\PageObjects\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		if (browserName.equals("firefox"))

		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\PageObjects\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		if (browserName.contentEquals("chrome_emulator")) {
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "iPhone X");
			mobileEmulation.put("deviceName", "iPhone X");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\PageObjects\\chromedriver.exe");

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);

		}

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public void captureScreenshot() throws IOException {
		Date date = new Date();
		File evidence = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(evidence,
		// new File("F:\\Automation 2020\\Screenshots\\E2EProject\\screenshot_" +
		// date.getTime() + ".png"));
		FileUtils.copyFile(evidence, new File(System.getProperty("user.dir") + date.getTime() + ".png"));

	}

}
