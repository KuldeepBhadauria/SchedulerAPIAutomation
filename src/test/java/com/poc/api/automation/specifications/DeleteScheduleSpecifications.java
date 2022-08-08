package com.poc.api.automation.specifications;

import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteScheduleSpecifications {
	
	public static RequestSpecification deleteScheduleRequest;
	public static Response deleteScheduleResponse;
	public int actualStatusCode;		

	public void configureBaseUriForDeleteSchedule(String uri) {
		RestAssured.baseURI = uri;
	}

	public void createDeleteScheduleRequestObject() {
		deleteScheduleRequest = RestAssured.given();
	}

	public void configureHeaders(String headerName, String headerValue) {
		deleteScheduleRequest.header(headerName, headerValue);
	}

	public void executeDeleteScheduleRequest(String path, String pathParam) {
		deleteScheduleResponse = deleteScheduleRequest.delete(path + "/" + pathParam);
	}

	public void validateResponseCode(int statusCode) {
		// Assert that successful status code is returned.
		actualStatusCode = deleteScheduleResponse.getStatusCode();
		Assert.assertEquals(
				"Expected response code is: " + statusCode
						+ " while actual reponse code is:  " + actualStatusCode,
				statusCode, actualStatusCode);
	}

	public void fetchResponse() {
		System.out.println("******************************************************");
		System.out.println("Response of Delete Schedule Request is" + "\n");
		deleteScheduleResponse.prettyPrint();
		System.out.println("******************************************************");
	}

	public void validateKeyInResponseNotNull(String key) {
		JsonPath jsonPathEvaluator = deleteScheduleResponse.jsonPath();
		String actualValue = (jsonPathEvaluator.get(key)).toString();
		Assert.assertFalse("Expected not null value for key: " + key + "while actual value is: " + actualValue,
				actualValue == null);
	}
	
	public void validateKeyValueInResponse(String key, String value) {
		JsonPath jsonPathEvaluator = deleteScheduleResponse.jsonPath();
        String actualValue =  (jsonPathEvaluator.get(key)).toString(); 
        Assert.assertTrue("Expected value for key: " + key + " is: " + value + " while actual value is: " + actualValue ,actualValue.equalsIgnoreCase(value));
	}

}
