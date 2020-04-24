package com.csa.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.csa.generics.BaseLib;
import com.csa.generics.IConstants;
import com.csa.util.JsonUtil;

import io.restassured.http.ContentType;

public class GetAllRecords extends BaseLib {

	@Test(priority = 0)
	public void getReourceWithValidData() {
		// Bearer Token
		token = JsonUtil.getJsonString(response, "token");
		given().header("Authorization", "Bearer" + token).get(IConstants.SINGLE_CUSTOMER).then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON);
	}
}
