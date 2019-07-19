package com.relayr.restapi;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Relayr {

	Properties prop = new Properties();
	Logger log = Logger.getLogger(Relayr.class);

	@BeforeClass
	public void getData() throws IOException {

		FileInputStream filestream = new FileInputStream(
				"C:\\Users\\shrgr\\eclipse-workspace\\RESTAPIProject-Relayr\\Prop.properties");
		prop.load(filestream);
	}

	@Test
	public void Employee1() throws Exception {

		System.out.println("----Employee1_POST_GET_Delete Operation----");
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = prop.getProperty("BaseURL");

		// Performing POST Operation - To create Employee Record

		RestAssured.registerParser("text/plain", Parser.JSON);
		Response res = given().body(prop.getProperty("payload1")).header("Content-Type", "application/json").when()
				.post(resources.postdata()).then().assertThat().statusCode(200).and().contentType("text/html").extract()
				.response();

		String POST_ResponseString = res.asString();
		System.out.println("Creating Employee Record using Post Request-->" + POST_ResponseString);
		System.out.println("Status Code :" + res.getStatusCode());
		JsonPath js = new JsonPath(POST_ResponseString);
		String employee_id = js.get("id");
		System.out.println("Employee ID " + employee_id);

		// Performing GET Operation - To validate if the Employee Record created exists

		Response res1 = given().body(prop.getProperty("BaseURL")).when().get("/api/v1/employee" + "/employee_id").then()
				.assertThat().statusCode(200).and().contentType("text/html").extract().response();

		String GET_ResponseString = res.asString();
		System.out.println("Checking Employee Record using GET Request-->" + GET_ResponseString);

		// Performing Delete Operation - To delete Employee Record

		Response res2 = given().body(prop.getProperty("BaseURL")).when().delete("/api/v1/delete" + "/employee_id")
				.then().assertThat().contentType("text/html").extract().response();

		String DELETE_ResponseString = res2.asString();
		System.out.println("Status Code :" + res2.getStatusCode());
		System.out.println("Deleting Employee Record Created-->" + DELETE_ResponseString);

	}

	@Test
	public void Employee2() throws Exception {

		System.out.println("----Employee2_POST_GET_Delete Operation----");
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = prop.getProperty("BaseURL");

		// Performing POST Operation - To create Employee Record

		RestAssured.registerParser("text/plain", Parser.JSON);
		Response res = given().body(prop.getProperty("payload2")).header("Content-Type", "application/json").when()
				.post(resources.postdata()).then().assertThat().statusCode(200).and().contentType("text/html").extract()
				.response();

		String POST_ResponseString = res.asString();
		System.out.println("Creating Employee Record using Post Request-->" + POST_ResponseString);
		System.out.println("Status Code :" + res.getStatusCode());
		JsonPath js = new JsonPath(POST_ResponseString);
		String employee_id = js.get("id");
		System.out.println("Employee ID " + employee_id);

		// Performing GET Operation - To validate if the Employee Record created exists

		Response res1 = given().body(prop.getProperty("BaseURL")).when().get("/api/v1/employee" + "/employee_id").then()
				.assertThat().statusCode(200).and().contentType("text/html").extract().response();

		String GET_ResponseString = res.asString();
		System.out.println("Checking Employee Record using GET Request-->" + GET_ResponseString);

		// Performing Delete Operation - To delete Employee Record

		Response res2 = given().body(prop.getProperty("BaseURL")).when().delete("/api/v1/delete" + "/employee_id")
				.then().assertThat().contentType("text/html").extract().response();

		String DELETE_ResponseString = res2.asString();
		System.out.println("Status Code :" + res2.getStatusCode());
		System.out.println("Deleting Employee Record Created-->" + DELETE_ResponseString);

	}

	@Test
	public void Employee3() throws Exception {

		System.out.println("----Employee3_POST_GET_Delete Operation----");
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = prop.getProperty("BaseURL");

		// Performing POST Operation - To create Employee Record

		RestAssured.registerParser("text/plain", Parser.JSON);
		Response res = given().body(prop.getProperty("payload3")).header("Content-Type", "application/json").when()
				.post(resources.postdata()).then().assertThat().statusCode(200).and().contentType("text/html").extract()
				.response();

		String POST_ResponseString = res.asString();
		System.out.println("Creating Employee Record using Post Request-->" + POST_ResponseString);
		System.out.println("Status Code :" + res.getStatusCode());
		JsonPath js = new JsonPath(POST_ResponseString);
		String employee_id = js.get("id");
		System.out.println("Employee ID " + employee_id);

		// Performing GET Operation - To validate if the Employee Record created exists

		Response res1 = given().body(prop.getProperty("BaseURL")).when().get("/api/v1/employee" + "/employee_id").then()
				.assertThat().statusCode(200).and().contentType("text/html").extract().response();

		String GET_ResponseString = res.asString();
		System.out.println("Checking Employee Record using GET Request-->" + GET_ResponseString);

		// Performing Delete Operation - To delete Employee Record

		Response res2 = given().body(prop.getProperty("BaseURL")).when().delete("/api/v1/delete" + "/employee_id")
				.then().assertThat().contentType("text/html").extract().response();

		String DELETE_ResponseString = res2.asString();
		System.out.println("Status Code :" + res2.getStatusCode());
		System.out.println("Deleting Employee Record Created-->" + DELETE_ResponseString);

	}
}
