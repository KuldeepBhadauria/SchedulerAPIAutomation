#Author: NM
#Date:
#Description:

@api
@ValidateDeleteSchedule
Feature: Delete Schedule Feature
    

  @DeleteScheduleHappyPath
  Scenario Outline: Validation of Delete Schedule API
    Given User configures the base uri for api request
    When User configures the header for request
    
    | HeaderName  |   HeaderValue    |
    |Content-Type |application/json  |
    
    And User executes "DELETE" request  with endpoint "<Endpoint>"
    Then User validates response code for request is <ResponseCode>
    And User validates response contains key value pair
    
    |  Key  |Value|
    |success|OK   |
    
    And User validates response body matches the response in file "<fileName>"
    
    Examples:
    |                Endpoint                            |ResponseCode|   fileName   |
    |/deleteSchedule/20010987FRDE987620018765000000002017|     200    |DeleteSchedule|