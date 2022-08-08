package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.UpdateScheduleSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateScheduleSteps {
	
	ConfigProvider configProvider = new ConfigProvider();
	UpdateScheduleSpecifications updateScheduleSpecifications = new UpdateScheduleSpecifications();


	@Given("^User configures the base uri for update schedule$")
	public void configureBaseUri() {
		updateScheduleSpecifications
				.configureBaseUriForUpdateSchedule(configProvider.getProperty("scheduler.api.base.uri"));
	}

	@When("^User configures the header for update schedule request as \"(.*)\" with value as \"(.*)\"$")
	public void configureHeaders(String headerKey, String headerValue) {
		updateScheduleSpecifications.createUpdateScheduleRequestObject();
		updateScheduleSpecifications.configureHeaders(headerKey, headerValue);
	}

	@When("^User executes update schedule request  with endpoint (.*) and pathParam (.*) and payload in file (.*)$")
	public void executeCreateSchedule(String path, String pathParam, String filename) {
		updateScheduleSpecifications.executeUpdateScheduleRequest(filename, path, pathParam);
	}

	@Then("^User validates response code for update schedule request as (.*)$")
	public void validateResponseCode(int statusCode) {
		updateScheduleSpecifications.fetchResponse();
		updateScheduleSpecifications.validateResponseCode(statusCode);
	}


	@Then("^User validates update schedule response contains key \"(.*)\" with not null value")
	public void vlaidateKeyValueNotNullInResponse(String key) {
		updateScheduleSpecifications.validateKeyInResponseNotNull(key);

	}
	
	@Then("^User validates update schedule response contains key as \"(.*)\" with value as \"(.*)\"")
	public void vlaidateKeyValueInResponse(String key, String value) {
		updateScheduleSpecifications.validateKeyValueInResponse(key, value);
		
	}


}
