package demo.example.SimpleTestProject.seleniumtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SetupTest {

	static WebDriver driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability("marionette", true);
			driver = new FirefoxDriver(dc);
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
			// create chrome instance
			driver = new ChromeDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}