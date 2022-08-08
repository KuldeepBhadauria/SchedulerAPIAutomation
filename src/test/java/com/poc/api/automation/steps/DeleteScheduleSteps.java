package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.DeleteScheduleSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteScheduleSteps {
	
	ConfigProvider configProvider = new ConfigProvider();
	DeleteScheduleSpecifications deleteScheduleSpecifications = new DeleteScheduleSpecifications();


	@Given("^User configures the base uri for delete schedule$")
	public void configureBaseUri() {
		deleteScheduleSpecifications
				.configureBaseUriForDeleteSchedule(configProvider.getProperty("scheduler.api.base.uri"));
	}

	@When("^User configures the header for delete schedule request as \"(.*)\" with value as \"(.*)\"$")
	public void configureHeaders(String headerKey, String headerValue) {
		deleteScheduleSpecifications.createDeleteScheduleRequestObject();
		deleteScheduleSpecifications.configureHeaders(headerKey, headerValue);
	}

	@When("^User executes delete schedule request  with endpoint (.*) and path param as (.*)$")
	public void executeCreateSchedule(String path, String pathParam) {
		deleteScheduleSpecifications.executeDeleteScheduleRequest(path, pathParam);
	}

	@Then("^User validates response code for delete schedule request as (.*)$")
	public void validateResponseCode(int statusCode) {
		deleteScheduleSpecifications.fetchResponse();
		deleteScheduleSpecifications.validateResponseCode(statusCode);
	}


	@Then("^User validates delete schedule response contains key \"(.*)\" with not null value")
	public void vlaidateKeyValueNotNullInResponse(String key) {
		deleteScheduleSpecifications.validateKeyInResponseNotNull(key);

	}
	
	@Then("^User validates delete schedule response contains key as \"(.*)\" with value as \"(.*)\"$")
	public void vlaidateKeyValueInResponse(String key, String value) {
		deleteScheduleSpecifications.validateKeyValueInResponse(key, value);
		
	}


}
