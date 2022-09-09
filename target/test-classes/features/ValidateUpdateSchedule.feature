#Author: NM
#Date:
#Description:

@api
@ValidateUpdateSchedule
Feature: Put - Update Schedule Feature
    

  @UpdateScheduleHappyPath
  Scenario Outline: Validation of Create Schedule API
    Given User configures the base uri for api request
    When User configures the header for request
    
    | HeaderName  |   HeaderValue    |
    |Content-Type |application/json  |
    
    And User executes "PUT" request  with payload in file "<fileName>" and endpoint as "<Endpoint>"
    Then User validates response code for request is <ResponseCode>
    And User validates response contains key "scheduleId" with not null value
    And User validates response contains key "updatedDateTime" with not null value
    And User validates response contains key value pair
    
    |    Key     | Value   |
    |recordStatus|SCHEDULED|
    
    And User validates response body matches the response in file "<fileName>"
    
    Examples:
    |Endpoint                                            |fileName      |ResponseCode|
    |/UpdateSchedule/20010987FRDE987620018765000000002017|UpdateSchedule|     200    |