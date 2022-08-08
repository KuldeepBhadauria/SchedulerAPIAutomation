package com.poc.api.automation.steps;


import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.CreateScheduleSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateScheduleSteps {

	
	ConfigProvider configProvider = new ConfigProvider();
	CreateScheduleSpecifications createScheduleSpecifications = new CreateScheduleSpecifications();


	@Given("^User configures the base uri for create schedule$")
	public void configureBaseUri() {
		createScheduleSpecifications
				.configureBaseUriForCreateSchedule(configProvider.getProperty("scheduler.api.base.uri"));
	}

	@When("^User configures the header for create schedule request as \"(.*)\" with value as \"(.*)\"$")
	public void configureHeaders(String headerKey, String headerValue) {
		createScheduleSpecifications.createCreateScheduleRequestObject();
		createScheduleSpecifications.configureHeaders(headerKey, headerValue);
	}

	@When("^User executes create schedule request  with endpoint (.*) and payload in file (.*)$")
	public void executeCreateSchedule(String path, String filename) {
		createScheduleSpecifications.executeCreateScheduleRequest(filename, path);
	}

	@Then("^User validates response code for create schedule request as (.*)$")
	public void validateCreatedResponseCode(int statusCode) {
		createScheduleSpecifications.fetchResponse();
		createScheduleSpecifications.validateResponseCode(statusCode);
	}


	@Then("^User validates create schedule response contains key \"(.*)\" with not null value")
	public void vlaidateKeyValueNotNullInResponse(String key) {
		createScheduleSpecifications.validateKeyInResponseNotNull(key);

	}
	
	@Then("^User validates create schedule response contains key as (.*) with value as (.*)")
	public void vlaidateKeyValueInResponseExamples(String key, String value) {
		createScheduleSpecifications.validateKeyValueInResponse(key, value);
		
	}

}
