package com.poc.api.automation.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.ApiSpecifications;
import org.json.simple.parser.ParseException;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiSteps {
	
	ConfigProvider configProvider = new ConfigProvider();
	ApiSpecifications apiSpecifications = new ApiSpecifications();


	@Given("User configures the base uri for api request")
	public void configureBaseUri() {
		apiSpecifications
				.configureBaseUri(configProvider.getProperty("api.base.uri"));
		apiSpecifications.createRequestObject();
	}

	/*
	 * @When("User configures the header for request as {string} with value as {string}"
	 * ) public void configureHeaders(String headerKey, String headerValue) {
	 * apiSpecifications.configureHeaders(headerKey, headerValue); }
	 */
	
	@When("User configures the header for request")
	public void configureHeaders(DataTable table) {
		
		List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> headerKeyValue : rows) {
        	apiSpecifications.configureHeaders(headerKeyValue.get("HeaderName"), headerKeyValue.get("HeaderValue"));
	    
	    }
	}

	@When("User executes {string} request  with payload at location {string} in file {string} and endpoint as {string}")
	public void executeRequestWithPayloadAndPath(String requestMethod, String baseLocation, String filename, String path) {
		apiSpecifications.executeRequestWithMethodTypeAndPayloadFromFile(requestMethod, baseLocation,filename, path);
	}
	
	@When("User executes {string} request  with endpoint {string}")
	public void executeRequestWithPayloadAndPath(String requestMethod, String path) {
		apiSpecifications.executeRequestWithMethodTypeAndPath(requestMethod, path);
	}


	@Then("User validates response code for request is {int}")
	public void validateResponseCode(int statusCode) {
		apiSpecifications.fetchResponse();
		apiSpecifications.validateResponseCode(statusCode);
	}


	@Then("User validates response contains key {string} with not null value")
	public void vlaidateKeyValueNotNullInResponse(String key) {
		apiSpecifications.validateKeyInResponseNotNull(key);

	}
	
	/*
	 * @Then("User validates response contains key as {string} with value as {string}"
	 * ) public void vlaidateKeyValueInResponseExamples(String key, String value) {
	 * apiSpecifications.validateKeyValueInResponse(key, value);
	 * 
	 * }
	 */
	
	@Then("User validates response contains key value pair")
	public void vlaidateKeyValueInResponse(DataTable table) {
		
		List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> responseKeyValue : rows) {
        	apiSpecifications.validateKeyValueInResponse(responseKeyValue.get("Key"), responseKeyValue.get("Value"));
	    
	    }
		
		
	}
	
	@Then("User validates response body matches the response in file {string} at location {string}")
	public void validateResponseAsPerResponseStoredInFilePath(String filepath, String baseLocation) throws IOException, ParseException {
		apiSpecifications.validateResponseBodyFromFile(baseLocation, filepath);
		
	}



}
