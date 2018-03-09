package demo.example.SimpleTestProject.UIObj;
import static demo.example.SimpleTestProject.Utils.DriverAction.verifyElementIsPresent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	private WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getFoundItemsNumber() {
		verifyElementIsPresent(By.xpath(".//span[@class = 'search-count']"), driver);
		
		WebElement searchResult = driver.findElement(By.xpath(".//span[@class = 'search-count']"));
		int items = Integer.parseInt(searchResult.getText().replaceAll("\\D", ""));
		return items;
	}
}



