package com.poc.api.automation.specifications;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiSpecifications {

	public static RequestSpecification request;
	public static Response response;
	public int actualStatusCode;

	public static final String GET_REQUEST = "GET";
	public static final String POST_REQUEST = "POST";
	public static final String DELETE_REQUEST = "DELETE";
	public static final String UPDATE_REQUEST = "PUT";

	public void configureBaseUri(String uri) {
		RestAssured.baseURI = uri;
	}

	public void createRequestObject() {
		request = RestAssured.given();
	}

	public void configureHeaders(String headerName, String headerValue) {
		request.header(headerName, headerValue);
	}

	public void executeRequestWithMethodTypeAndPayloadFromFile(String requestMethod, String baseLocation, String fileNameFromPath,
			String path) {

		String fileName = fileNameFromPath;
		File jsonData = new File(baseLocation + fileName + ".json");
		String method = requestMethod.toUpperCase();
		switch (method) {

		case GET_REQUEST:

			response = request.body(jsonData).get(path);
			break;

		case POST_REQUEST:

			response = request.body(jsonData).post(path);
			break;

		case UPDATE_REQUEST:

			response = request.body(jsonData).put(path);
			break;

		case DELETE_REQUEST:

			response = request.body(jsonData).delete(path);
			break;

		default:
			System.out.println("Invalid Request Method !");

		}

	}

	public void executeRequestWithMethodTypeAndPath(String requestMethod, String path) {

		switch (requestMethod.toUpperCase()) {

		case GET_REQUEST:

			response = request.get(path);
			break;

		case POST_REQUEST:

			response = request.post(path);
			break;

		case UPDATE_REQUEST:

			response = request.put(path);
			break;

		case DELETE_REQUEST:

			response = request.delete(path);
			break;

		default:
			System.out.println("Invalid Request Method !");

		}

	}

	public void validateResponseCode(int expectedStatusCode) {
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals("Expected response code is: " + expectedStatusCode + " while actual reponse code is:  "
				+ actualStatusCode, expectedStatusCode, actualStatusCode);
	}

	public void fetchResponse() {
		System.out.println("******************************************************");
		System.out.println("RESPONSE IS : " + "\n");
		response.prettyPrint();
		System.out.println("******************************************************");
	}

	public void validateKeyInResponseNotNull(String key) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		String actualValue = (jsonPathEvaluator.get(key)).toString();
		Assert.assertFalse("Expected not null value for key: " + key + "while actual value is: " + actualValue,
				actualValue == null);
	}

	public void validateKeyValueInResponse(String key, String value) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		String actualValue = (jsonPathEvaluator.get(key)).toString();
		Assert.assertTrue("Expected value for key: " + key + " is: " + value + " while actual value is: " + actualValue,
				actualValue.equalsIgnoreCase(value));
	}

	public void validateResponseBodyFromFile(String baseLocation,String fileNameFromPath) throws IOException, ParseException {

		String actualResponse = response.asString();
		String fileName = fileNameFromPath;
		String expectedResponseInString = "";
		expectedResponseInString = new String(Files.readAllBytes(Paths
				.get(/* System.getProperty("user.dir") + */baseLocation + fileName + ".json")));
		/*
		 * Assert.assertTrue("Expected response is: " + expectedResponseInString +
		 * " while actual response is: " + actualResponse,
		 * actualResponse.equalsIgnoreCase(expectedResponseInString));
		 */

		// converting response in string to json object
		JSONParser parser = new JSONParser();
		JSONObject expectedJson = (JSONObject) parser.parse(expectedResponseInString);
		JSONObject actualJson = (JSONObject) parser.parse(actualResponse);
		Assert.assertTrue("Expected response is: " + expectedJson + " while actual response is: " + actualJson,
				actualJson.equals(expectedJson));
		
		
	
	}

}
