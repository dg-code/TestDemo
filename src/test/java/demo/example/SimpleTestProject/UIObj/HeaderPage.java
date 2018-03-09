package demo.example.SimpleTestProject.UIObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	public static final String HELP_HEADER_LINK = ".//div[@data-auto-id='glass-header-top-desktop']//a[contains(@href,'/help')]";
	
	private WebDriver driver;

	public HeaderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean hasHelpLink() {
		return (driver.findElement(By.xpath(HELP_HEADER_LINK)).getText().equalsIgnoreCase("help"));
	}
}
