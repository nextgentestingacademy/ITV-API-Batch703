package tests;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;

public class FSProdTest extends ConfigReader{

	@Test
	public static void getAllProducts() {
		
		//API response of Get All Products
		Response response = given()
				.header("Content-Type","application/json")
		.when()
			.get("products")
		.then()
			.statusCode(200)
			.time(lessThan(10000L))
			.header("Content-Type", equalTo("application/json; charset=utf-8"))
			.body("id[0]", equalTo(1))
			.body("description[0]", containsString("forest"))
			.extract().response();
		
		//Extracting the ID of the first product from the response
		int prodId = response.jsonPath().getInt("id[0]");
		System.out.println(prodId);
		//Executing the API of Get Single Product using the extracted prodId
		given()
		.when()
		.get("products/" + prodId)
		.then()
			.statusCode(200);
		
		
	}
	
}

