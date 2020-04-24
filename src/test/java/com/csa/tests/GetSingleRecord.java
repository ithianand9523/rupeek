package com.csa.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import com.csa.generics.BaseLib;
import com.csa.generics.IConstants;

import io.restassured.http.ContentType;

public class GetSingleRecord extends BaseLib {

	@Test
	public void getSingleRecordWithValidID() throws Throwable {
		// Bearer Token
		given().auth().oauth2(token).get(IConstants.SINGLE_CUSTOMER);

		given().pathParam("phone", 8037602400l).when().get(IConstants.SINGLE_CUSTOMER).then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).and().body("first_name", equalTo("Aliko")).and()
				.body("last_name", equalTo("Dangote")).and().body("career", equalTo("Billionaire Industrialist")).and()
				.body("phone", equalTo("8037602400")).time(lessThan(1000l));

	}

	@Test
	public void getSingleRecordWithInvalidID() throws Throwable {
		// Bearer Token
		given().auth().oauth2(token).get(IConstants.SINGLE_CUSTOMER);

		given().pathParam("phone", 803760210l).when().get(IConstants.SINGLE_CUSTOMER).then().assertThat()
				.statusCode(404).and().contentType(ContentType.JSON).and().time(lessThan(3000l));
	}

}
