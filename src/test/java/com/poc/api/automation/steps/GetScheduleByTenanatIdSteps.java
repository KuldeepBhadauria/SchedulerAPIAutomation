package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.GetScheduleByTenanatIdSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetScheduleByTenanatIdSteps {

	ConfigProvider configProvider = new ConfigProvider();
	GetScheduleByTenanatIdSpecifications getScheduleByTenanatIdSpecifications = new GetScheduleByTenanatIdSpecifications();
	
	public String responseBodyAsString;
	
	@Given("^User configures the base uri for get book schedule by Tenant Id$")
	public void configureBaseUri() {
		getScheduleByTenanatIdSpecifications.getBaseUri(configProvider.getProperty("scheduler.api.base.uri"));

	}
	
	@When("^User configures the header \"(.*)\" with value as \"(.*)\"$")
	public void configureHeaders(String headerKey, String headerValue) {
		getScheduleByTenanatIdSpecifications.createGetScheduleByTenantIdObject();
		getScheduleByTenanatIdSpecifications.configureHeaders(headerKey, headerValue);
	}

	@When("^User executes get schedule request with endpoint \"(.*)\" and query param \"(.*)\"$")
	public void getScheduleByTenantId(String path, String queryParam) {
		getScheduleByTenanatIdSpecifications.executeGetRequestWithQueryParam(path,queryParam);
	}
	
	@When("^User executes get schedule request with endpoint as (.*) and query param as (.*)$")
	public void getScheduleByTenantIdExamples(String path, String queryParam) {
		getScheduleByTenanatIdSpecifications.executeGetRequestWithQueryParam(path,queryParam);
	}
	
	
	@Then("^User stores the api response for validation$")
	public void storeAPIResponse() {
	     responseBodyAsString = getScheduleByTenanatIdSpecifications.fetchResponseForGetRequestAsString();
	}
	
	@Then("^User validates status code \"(.*)\"$")
	public void validateStatusCode(int statusCode) {
		getScheduleByTenanatIdSpecifications.fetchResponseForGetRequestAsString();
		getScheduleByTenanatIdSpecifications.validateStatusCode(statusCode);

	}
	
	@Then("^User validates status code as (.*)$")
	public void validateStatusCodeExamples(int statusCode) {
		getScheduleByTenanatIdSpecifications.fetchResponseForGetRequestAsString();
		getScheduleByTenanatIdSpecifications.validateStatusCode(statusCode);

	}
	
	@Then("^User validates response contains key \"(.*)\" with value \"(.*)\"")
	public void vlaidateKeyValueInResponse(String key, String value) {
		getScheduleByTenanatIdSpecifications.validateKeyValueInResponse(key, value);
		
	}
	
	@Then("^User validates response contains key as (.*) with value as (.*)")
	public void vlaidateKeyValueInResponseExamples(String key, String value) {
		getScheduleByTenanatIdSpecifications.validateKeyValueInResponse(key, value);
		
	}
}
