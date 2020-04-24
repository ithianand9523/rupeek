package com.csa.generics;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;

/**
 * 
 * @author Prakruthi
 *
 */
public class BaseLib {
	/**
	 * to initialize the base URI,port and authentication
	 */
	@BeforeSuite
	public void config() {
		baseURI = "http://13.126.80.194";
		port = 8080;

	}

	public static String token;

	@BeforeTest
	public void authenticate() {
		try {
			FileInputStream fis = new FileInputStream(new File(".\\src\\test\\resources\\JSON\\Authenticate.json"));
			Response response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when()
					.post(IConstants.TO_AUTHENTICATE);
			response.then().assertThat().contentType(ContentType.JSON).and().statusCode(200);

			token = response.toString();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
