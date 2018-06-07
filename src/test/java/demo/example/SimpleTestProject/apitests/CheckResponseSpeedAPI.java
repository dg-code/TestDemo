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

		RestAssured.baseURI = "https://reqres.in";
	}

	@Test
	public void checkResponseTimeBellowSecond() {

		given().
			contentType("application/json").
		when().
			get("/api/users?page=2").
		then().
			assertThat().
				time(lessThan(1000L), TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void checkResponseStatusOK() {

		given().
			contentType("application/json").
		when().
			get("/api/users?page=2").
		then().
			assertThat().
				statusCode(200);
	}
}