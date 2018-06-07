package demo.example.SimpleTestProject.apitests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CheckResponseSpeedAPI {
	
	@BeforeClass
	public void initPath() {

		RestAssured.baseURI = "https://www.blabla.fi";
	}

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
}