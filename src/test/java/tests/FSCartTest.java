package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class FSCartTest {

	@Test
	public void getCartById() {
		given()
		.when()
			.get("https://fakestoreapi.com/carts/3")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void getAllCarts() {
		given()
		.when()
			.get("https://fakestoreapi.com/carts")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void deleteCart() {
		given()
		.when()
			.delete("https://fakestoreapi.com/carts/3")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void addNewCart() {
		
		String reqBody = "{\\\"id\\\": 10,\\\"userId\\\": 38,\\\"products\\\": [{\r\n"
				+ "      \\\"id\\\": 1,\\\"title\\\": \\\"Sunglasses\\\",\\\"price\\\": 9000.99,\"description\\\": \\\"Men's Sunglasses\\\",\\\"category\\\": \\\"Eyewear\\\",\\\"image\\\": \\\"http://example.com\\\"}]}";
		
		given()
			.body(reqBody)
		.when()
			.post("https://fakestoreapi.com/carts")
		.then()
			.statusCode(201);
	}
	
	@Test
	public void updateExistingCart() {
		
		String reqBody = "{\\\"id\\\": 1,\\\"userId\\\": 10,\\\"products\\\": [\\\"id\\\": 0,\r\n"
				+ "      \\\"title\\\": \\\"string\\\",\\\"price\\\": 0.1,\r\n"
				+ "      \\\"description\\\": \\\"string\\\",\r\n"
				+ "      \\\"category\\\": \\\"string\\\",\r\n"
				+ "      \\\"image\\\": \\\"http://example.com\\\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		
		
		
		given()
			.body(reqBody)
		.when()
			.put("https://fakestoreapi.com/carts/1")
		.then()
			.statusCode(200);
	}
	
}
