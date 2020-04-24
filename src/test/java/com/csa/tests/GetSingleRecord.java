package com.csa.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.csa.generics.BaseLib;
import com.csa.generics.IConstants;
import com.csa.util.JsonUtil;

import io.restassured.http.ContentType;

public class GetSingleRecord extends BaseLib {

	@Test(priority = 0)
	public void getSingleRecordWithValidPhone() throws Throwable {
		// Bearer Token
		token = JsonUtil.getJsonString(response, "token");
		given().header("Authorization", "Bearer" + token).get(IConstants.SINGLE_CUSTOMER);

		given().pathParam("phone", 8037602400l).when().get(IConstants.SINGLE_CUSTOMER).then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).and().body("first_name", equalTo("Aliko")).and()
				.body("last_name", equalTo("Dangote")).and().body("career", equalTo("Billionaire Industrialist"));

	}

	@Test(priority = 1)
	public void getSingleRecordWithInvalidPhone() throws Throwable {
		// Bearer Token
		token = JsonUtil.getJsonString(response, "token");
		given().header("Authorization", "Bearer" + token).get(IConstants.SINGLE_CUSTOMER);

		given().pathParam("phone", 803760210l).when().get(IConstants.SINGLE_CUSTOMER).then().assertThat()
				.statusCode(404).and().contentType(ContentType.JSON);
	}

}
