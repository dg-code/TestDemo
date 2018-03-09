package demo.example.SimpleTestProject.UIObj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {
	
	public static final ArrayList<String> PRODUCTS = new ArrayList<String>(
			Arrays.asList("Shoes", "Clothing", "Accessories", "New arrivals", "Outlet"));
	
	private WebDriver driver;

	public FooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getProductsList() {
		List<WebElement> products = driver.findElements(By.xpath(".//a[contains(@manual_cm_sp,'footer-_-products')]"));
		return products;
	}
}
