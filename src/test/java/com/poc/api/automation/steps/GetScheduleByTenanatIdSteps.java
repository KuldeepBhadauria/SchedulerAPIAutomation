package com.poc.api.automation.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.GetScheduleByTenanatIdSpecifications;
import com.poc.api.automation.utils.TestDataReaderCsvUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetScheduleByTenanatIdSteps {

	ConfigProvider configProvider = new ConfigProvider();
	GetScheduleByTenanatIdSpecifications getScheduleByTenanatIdSpecifications = new GetScheduleByTenanatIdSpecifications();
	TestDataReaderCsvUtil testData = new TestDataReaderCsvUtil();
	public static String currentWorkingDirectory = System.getProperty("user.dir");
	
	
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
	
	@When("User executes get schedule request with endpoint and query param values from sheet name {string} and row number {int}")
	public void executeGetRequestWithQueryParamBasedOnSheetNameAndRowNum(String sheetName, int rowNumber) throws InvalidFormatException, IOException {
		List <Map<String,String>> endpointData = testData.retrieveDataBasedOnFilePathAndSheetName
				(currentWorkingDirectory + "/src/test/resources/dataSet/ApiTestData.xlsx", sheetName);
		String path = endpointData.get(rowNumber).get("Endpoint");
		String queryParam = endpointData.get(rowNumber).get("TenantId");
		getScheduleByTenanatIdSpecifications.executeGetRequestWithQueryParam(path,queryParam);		
		//testData.closeWorbook(currentWorkingDirectory + "/src/test/resources/dataSet/ApiTestData.xlsx");
								
	}
	
	@Then("User validates status code from sheet name {string} and row number {int}")
	public void validateStatusCodeBasedOnSheetNameAndRowNum(String sheetName, int rowNumber) throws InvalidFormatException, IOException {		
		List <Map<String,String>> responseCodeData = testData.retrieveDataBasedOnFilePathAndSheetName
				(currentWorkingDirectory + "/src/test/resources/dataSet/ApiTestData.xlsx", sheetName);
		String statusCode = responseCodeData.get(rowNumber).get("ResponseCode");
		int statusCodeInt = Integer.parseInt(statusCode);
		getScheduleByTenanatIdSpecifications.fetchResponseForGetRequestAsString();
		getScheduleByTenanatIdSpecifications.validateStatusCode(statusCodeInt);		
		//testData.closeWorbook(currentWorkingDirectory + "/src/test/resources/dataSet/ApiTestData.xlsx");

	}
	
	@Then("User validates reponse key and value from sheet name {string} and row number {int}")
	public void user_validates_reponse_key_and_value_from_sheet_name_and_row_number(String sName, Integer rNum) throws InvalidFormatException, IOException {
		List <Map<String,String>> responseData = testData.retrieveDataBasedOnFilePathAndSheetName
				(currentWorkingDirectory + "/src/test/resources/dataSet/ApiTestData.xlsx", sName);
		String key = responseData.get(rNum).get("ResponseKey");
		String value = responseData.get(rNum).get("ResponseValue");
		getScheduleByTenanatIdSpecifications.validateKeyValueInResponse(key, value);
		testData.closeWorbook(currentWorkingDirectory + "/src/test/resources/dataSet/ApiTestData.xlsx");
	}
}
