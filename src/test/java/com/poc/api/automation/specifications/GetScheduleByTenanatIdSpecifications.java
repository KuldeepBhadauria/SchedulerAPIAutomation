package com.poc.api.automation.specifications;

import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetScheduleByTenanatIdSpecifications {
	
	
	RequestSpecification httpRequest;
	Response response;
	int statusCode;
	
	public void getBaseUri(String uri) {
		// Specify the base URL to the RESTful web service 
		RestAssured.baseURI = uri;
		
	}
	
	public void createGetScheduleByTenantIdObject() {
		httpRequest = RestAssured.given();
	}

	public void configureHeaders(String headerName, String headerValue) {
		httpRequest.header(headerName, headerValue);
	}

	public void executeGetRequestWithQueryParam(String path, String queryParam) {
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		// Make a GET request call directly by using RequestSpecification.get() method.
		// Make sure you specify the resource name.
		//response = httpRequest.get("/Books");
		response = httpRequest.get("/" + path + "?" + queryParam);
	}
	
	
	
	public Response fetchResponseForGetRequest() {
		return response;
		
	}
	
	public String fetchResponseForGetRequestAsString() {
		// Response.asString method will directly return the content of the body
		// as String.
		System.out.println("******************************************************");
		System.out.println("Response of Get Schedule By Tenant Id Request is" + "\n");
		response.prettyPrint();
		System.out.println("******************************************************");		
		return response.toString();
			
	}
	
	public int getStatusCodeForGetRequest() {
		// Get the status code from the Response. In case of 
		// a successful interaction with the web service, we
		// should get a status code of 200.
		statusCode = response.getStatusCode();
		return statusCode;
		
	}
	
	public void validateStatusCode(int expectedStatusCode) {
		// Assert that successful status code is returned.
		statusCode = response.getStatusCode();
		Assert.assertEquals("Expected response code is: " +  expectedStatusCode + " while actual reponse code is:  " + statusCode, expectedStatusCode, statusCode/*expected value*/);		
	}
	
	public void validateKeyValueInResponse(String key, String value) {
		Response response = fetchResponseForGetRequest();
		JsonPath jsonPathEvaluator = response.jsonPath();
        String actualValue =  (jsonPathEvaluator.get(key)).toString(); 
        Assert.assertTrue("Expected value for key: " + key + " is: " + value + " while actual value is: " + actualValue ,actualValue.equalsIgnoreCase(value));
	}
	

				
			

				
}
