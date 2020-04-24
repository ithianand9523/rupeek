package com.csa.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import com.csa.generics.BaseLib;
import com.csa.generics.IConstants;

import io.restassured.http.ContentType;

public class GetAllRecords extends BaseLib {

	@Test
	public void getReourceWithValidData() {
		// Bearer Token
		given().auth().oauth2(token).get(IConstants.ALL_CUSTOMERS);

		when().get(IConstants.ALL_CUSTOMERS).then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.and().time(lessThan(1000l));
	}
}
