package demo.example.SimpleTestProject.apitests;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;

public class ApiTests {
	
	@BeforeClass
	public void initPath() {

		RestAssured.baseURI = "https://www.adidas.fi";
	}

	/*******************************************************
	 * Send a GET request to /api/pages/landing?path=/ and check that the
	 * response time is bellow 1s
	 ******************************************************/

	@Test
	public void checkResponseTimeBellowSecond() {

		given().
			contentType("application/json").
		when().
			get("/api/pages/landing?path=/").
		then().
			assertThat().
				time(lessThan(1000L), TimeUnit.MILLISECONDS);
	}
	
	/*******************************************************
	 * Send a GET request to all image urls to check availability and check that the
	 * response time is bellow 1s
	 ******************************************************/

	@Test
	public void checkImagesAccessibility() {
		
		Filter imageUrlFilter = filter(
				   where("url").contains(".jpg")
				);
				
		String response = given().contentType("application/json").when().get("/api/pages/landing?path=/").asString();
		List<String> imageUrls = JsonPath.parse(response).read("$..url", imageUrlFilter);
		List<String> uniqueImageUrls = new ArrayList<String>(new HashSet<String>(imageUrls)); //remove duplicate urls
		ListIterator<String> lit = uniqueImageUrls.listIterator();
		
		while (lit.hasNext()) {
			
			given().
			when().
				get(lit.next()).
			then().
				assertThat().
					statusCode(200).
					time(lessThan(1000L), TimeUnit.MILLISECONDS);
		}
	}
	
	/*******************************************************
	 * Send a GET request to check that for every component item there is 
	 * analytics data
	 ******************************************************/
	
	@Test
	public void checkEveryComponentHasAnalyticsData() {
		
		String response = given().contentType("application/json").when().get("/api/pages/landing?path=/").asString();	
		List<String> allComponents = JsonPath.read(response, "$.component_presentations[*]component.content_fields.items[*]");
		List<String> componentsWithAnalytics = JsonPath.read(response, "$.component_presentations[*]component.content_fields.items[*].supporting_fields.supporting_fields.standard_metadata[?(@.analytics_name)]");
		
		assertEquals(componentsWithAnalytics.size(), allComponents.size());
	}
}
