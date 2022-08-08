package com.poc.api.automation.specifications;

import java.io.File;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateScheduleSpecifications {

		public static RequestSpecification createScheduleRequest;
		public static Response createScheduleResponse;
		public int actualStatusCode;		

		public void configureBaseUriForCreateSchedule(String uri) {
			RestAssured.baseURI = uri;
		}

		public void createCreateScheduleRequestObject() {
			createScheduleRequest = RestAssured.given();
		}

		public void configureHeaders(String headerName, String headerValue) {
			createScheduleRequest.header(headerName, headerValue);
		}

		public void executeCreateScheduleRequest(String fileNameFromPath, String path) {
			String fileName = fileNameFromPath;
			File jsonData = new File("src/test/resources/requestObjects/" + fileName + ".json");
			createScheduleResponse = createScheduleRequest.body(jsonData).post(path);
		}

		public void validateResponseCode(int statusCode) {
			// Assert that successful status code is returned.
			actualStatusCode = createScheduleResponse.getStatusCode();
			Assert.assertEquals(
					"Expected response code is: " + statusCode
							+ " while actual reponse code is:  " + actualStatusCode,
					statusCode, actualStatusCode);
		}

		public void fetchResponse() {
			System.out.println("******************************************************");
			System.out.println("Response of Create Schedule Request is" + "\n");
			createScheduleResponse.prettyPrint();
			System.out.println("******************************************************");
		}

		public void validateKeyInResponseNotNull(String key) {
			JsonPath jsonPathEvaluator = createScheduleResponse.jsonPath();
			String actualValue = (jsonPathEvaluator.get(key)).toString();
			Assert.assertFalse("Expected not null value for key: " + key + "while actual value is: " + actualValue,
					actualValue == null);
		}
		
		public void validateKeyValueInResponse(String key, String value) {
			JsonPath jsonPathEvaluator = createScheduleResponse.jsonPath();
	        String actualValue =  (jsonPathEvaluator.get(key)).toString(); 
	        Assert.assertTrue("Expected value for key: " + key + " is: " + value + " while actual value is: " + actualValue ,actualValue.equalsIgnoreCase(value));
		}
	

}
