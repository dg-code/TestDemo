package demo.example.SimpleTestProject.Utils;

import static demo.example.SimpleTestProject.Utils.Utils.Argument.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverAction {
	// Maximal time for the driver to wait in seconds
	private static final int MAX_ELEMENT_WAIT = 10;
	
	public static boolean verifyElementIsPresent(By byAttribute, WebDriver webDriver) {
        isNotNull(webDriver, "Driver");
        isNotNull(byAttribute, "Attribute of the element");

        try {
            (new WebDriverWait(webDriver, MAX_ELEMENT_WAIT)).until(ExpectedConditions.presenceOfElementLocated(byAttribute));
        } catch (WebDriverException ex) {
            return false;
        }
        return true;
    }
	
    public static boolean verifyElementIsVisible(WebElement webElement, WebDriver webDriver) {
        isNotNull(webDriver, "Driver");
        isNotNull(webElement, "Element");

        try {
            new WebDriverWait(webDriver, MAX_ELEMENT_WAIT).until(ExpectedConditions.visibilityOf(webElement));
        } catch (WebDriverException ex) {
            return false;
        }
        return true;
    }
}
