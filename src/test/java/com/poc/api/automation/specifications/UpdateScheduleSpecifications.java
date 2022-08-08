package com.poc.api.automation.specifications;

import java.io.File;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateScheduleSpecifications {

			public static RequestSpecification updateScheduleRequest;
			public static Response updateScheduleResponse;
			public int actualStatusCode;		

			public void configureBaseUriForUpdateSchedule(String uri) {
				RestAssured.baseURI = uri;
			}

			public void createUpdateScheduleRequestObject() {
				updateScheduleRequest = RestAssured.given();
			}

			public void configureHeaders(String headerName, String headerValue) {
				updateScheduleRequest.header(headerName, headerValue);
			}

			public void executeUpdateScheduleRequest(String fileNameFromPath, String path, String pathParam) {
				String fileName = fileNameFromPath;
				File jsonData = new File("src/test/resources/requestObjects/" + fileName + ".json");
				updateScheduleResponse = updateScheduleRequest.body(jsonData).put(path + "/" + pathParam);
			}

			public void validateResponseCode(int statusCode) {
				// Assert that successful status code is returned.
				actualStatusCode = updateScheduleResponse.getStatusCode();
				Assert.assertEquals(
						"Expected response code is: " + statusCode
								+ " while actual reponse code is:  " + actualStatusCode,
						statusCode, actualStatusCode);
			}

			public void fetchResponse() {
				System.out.println("******************************************************");
				System.out.println("Response of Update Schedule Request is" + "\n");
				updateScheduleResponse.prettyPrint();
				System.out.println("******************************************************");
			}

			public void validateKeyInResponseNotNull(String key) {
				JsonPath jsonPathEvaluator = updateScheduleResponse.jsonPath();
				String actualValue = (jsonPathEvaluator.get(key)).toString();
				Assert.assertFalse("Expected not null value for key: " + key + "while actual value is: " + actualValue,
						actualValue == null);
			}
			
			public void validateKeyValueInResponse(String key, String value) {
				JsonPath jsonPathEvaluator = updateScheduleResponse.jsonPath();
		        String actualValue =  (jsonPathEvaluator.get(key)).toString(); 
		        Assert.assertTrue("Expected value for key: " + key + " is: " + value + " while actual value is: " + actualValue ,actualValue.equalsIgnoreCase(value));
			}


}
