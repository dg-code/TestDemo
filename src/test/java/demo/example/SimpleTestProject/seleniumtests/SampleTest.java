package demo.example.SimpleTestProject.seleniumtests;

import static demo.example.SimpleTestProject.UIObj.FooterPage.PRODUCTS;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import demo.example.SimpleTestProject.UIObj.FooterPage;
import demo.example.SimpleTestProject.UIObj.HeaderPage;
import demo.example.SimpleTestProject.UIObj.SearchPage;
import demo.example.SimpleTestProject.UIObj.StartPage;

public class SampleTest extends SetupTest {
	
	/*******************************************************
	 * Verify help link in the Header of the StartPage
	 ******************************************************/
	@Test
	public void verifyHelpLinkPresentOnStartPage() {

		StartPage startPage = new StartPage(driver, true);
		HeaderPage headerPage = startPage.getHeader(driver);
		
		assertTrue(headerPage.hasHelpLink());
	}

	/*******************************************************
	 * Search for a "Sport" and verify that more than 
	 * 1000 products were found for "Sport"
	 ******************************************************/
	@Test
	public void verifyMoreThanThousandSearchItemFound() {

		StartPage startPage = new StartPage(driver, true);
		SearchPage searchPage = startPage.submitSearch("Sport");

		assertTrue(searchPage.getFoundItemsNumber() > 1000);
	}

	/*******************************************************
	 * Verify correct products listed on Footer
	 * under Start Page
	 ******************************************************/
	@Test
	public void verifyProductsListedInFooterOnStartPage() {

		StartPage startPage = new StartPage(driver, true);
		FooterPage footerPage = startPage.getFooter(driver);
		List<WebElement> products = footerPage.getProductsList();

		ArrayList<String> listOfProductsFound = new ArrayList<String>();
		ListIterator<WebElement> lit = products.listIterator();

		while (lit.hasNext()) {
			listOfProductsFound.add(lit.next().getText());
		}

		assertTrue(listOfProductsFound.equals(PRODUCTS));
	}
}
