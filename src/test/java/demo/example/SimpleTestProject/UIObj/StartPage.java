package demo.example.SimpleTestProject.UIObj;

import static demo.example.SimpleTestProject.Utils.DriverAction.verifyElementIsVisible;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage {
	
	static final String PAGE_URL="https://www.adidas.fi/";
	static final String LOC_POUP_XPATH = ".//div/a/i[contains(@class,'icon-close')]";
	static final String SEARCH_FIELD_XPATH = ".//div[@data-auto-id='glass-header-bottom-desktop']//input[@name='q']";
	
	private final WebDriver driver;

	public StartPage(WebDriver driver, Boolean ignoreLocation) {
		this.driver = driver;
		driver.get(PAGE_URL);
		
		if (ignoreLocation) {
			if (hasLocationPopUp())
				closeLocationPopUp();
		}
		assertTrue(driver.getCurrentUrl().equals(PAGE_URL));
	}
	
	private boolean hasLocationPopUp() {
		if (verifyElementIsVisible(driver.findElement(By.xpath(LOC_POUP_XPATH)), driver)) {
			return true;
		}
		return false;
	}
	
	private void closeLocationPopUp() {
		driver.findElement(By.xpath(LOC_POUP_XPATH)).click();
	}

	public SearchPage submitSearch(String searchItem) {
		WebElement searchField = driver.findElement(By.xpath(SEARCH_FIELD_XPATH));
		searchField.sendKeys(searchItem);
		searchField.sendKeys(Keys.RETURN);
		return new SearchPage(driver);
	}
	
	public FooterPage getFooter(WebDriver driver) {
		return new FooterPage(driver);
	}
	
	public HeaderPage getHeader(WebDriver driver) {
		return new HeaderPage(driver);
	}
}