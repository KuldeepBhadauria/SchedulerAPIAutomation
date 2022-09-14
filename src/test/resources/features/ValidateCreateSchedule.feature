#Author: NM
#Date:
#Description:

@api
@ValidateCreateSchedule
Feature: Post - Create Schedule Feature
    

  @CreateScheduleHappyPath
  Scenario Outline: Validation of Create Schedule API
    Given User configures the base uri for api request
    When User configures the header for request
    
    | HeaderName  |   HeaderValue    |
    |Content-Type |application/json  |
        
    And User executes "<requestMethod>" request  with payload at location "<requestFolderPath>" in file "<fileName>" and endpoint as "<Endpoint>"
    Then User validates response code for request is <ResponseCode>
    And User validates response contains key value pair
    
    |    Key         |           Value                    |
    |scheduleId      |20010987FRDE987620018765000000002017|
    |creationDateTime|2022-07-22T11:34:87.987             |
    
    And User validates response contains key "creationDateTime" with not null value
    And User validates response body matches the response in file "<fileName>" at location "<responseFolderPath>"
    
    Examples:
    |requestMethod|requestFolderPath                 |Endpoint       |fileName      |responseFolderPath                 |ResponseCode|
    |POST         |src/test/resources/requestObjects/|/CreateSchedule|CreateSchedule|src/test/resources/responseObjects/|     201    |
    
  
  
  @CreateScheduleUnHappyPath
  Scenario Outline: Validation of Unhappy Path for Create Schedule API
    Given User configures the base uri for api request
    When User configures the header for request
    
    | HeaderName  |   HeaderValue    |
    |Content-Type |application/json  |
      
    And User executes "<requestMethod>" request  with payload at location "<requestFolderPath>" in file "<fileName>" and endpoint as "<Endpoint>"
    Then User validates response code for request is <ResponseCode>
    And User validates response contains key value pair
    
    |    Key         |                      Value                                   |
    |Error           |Either one or all of the mandatory fields required are missing|
    
    And User validates response body matches the response in file "<fileName>" at location "<responseFolderPath>"
    
    Examples:
    |requestMethod|requestFolderPath                 |Endpoint       |fileName                       |responseFolderPath                 |ResponseCode|
    |POST         |src/test/resources/requestObjects/|/CreateSchedule|CreateScheduleMissingParameters|src/test/resources/responseObjects/|     400    |
   
  
  