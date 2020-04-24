package com.csa.util;

import java.util.List;

import io.restassured.response.Response;

/**
 * 
 * @author Prakruthi
 *
 */
public class JsonUtil {
	
	/**
	 * getJsonString returns the json value from the specified jsonpath
	 * @param respnse
	 * @param jsonpath
	 * @return
	 */
	public static String getJsonString(Response response, String jsonPath) {
		return response.getBody().jsonPath().get(jsonPath).toString();
	}
	
	
	/**
	 * getJsonList returns the values of json array from the specified jsonPath
	 * @param response
	 * @param jsonPath
	 * @return
	 */
	public static List<String> getJsonList(Response response, String jsonPath){
		return response.getBody().jsonPath().getList(jsonPath);
	}

}

