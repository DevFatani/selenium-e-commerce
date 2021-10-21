package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	
	public static String downloadPath = System.getProperty("user.dir") + "/Downloads";
	
	public static ChromeOptions chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups",0);
		chromePrefs.put("download.default_directory",downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	
	
	
	public static FirefoxOptions firefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", downloadPath);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/octet-stream");
		options.addPreference("browser.download.manager.showWhenStrting", false);
		return options;
	}
	
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions());
		}else if (browserName.equalsIgnoreCase("chrome-headless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
		}else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions());
		}else {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult iTestResult) {
		if(iTestResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed ...");
			Helper.captureScreenshot(driver, iTestResult.getName());
		}
	}
	
	protected int getRandomNumber() {
		return (int)(Math.random()* Integer.MAX_VALUE);
	}
}
