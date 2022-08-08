#Author: NM
#Date:
#Description:

@api
@ValidateDeleteSchedule
Feature: Delete Schedule Feature
    

  @DeleteScheduleHappyPath
  Scenario Outline: Validation of Delete Schedule API
    Given User configures the base uri for delete schedule
    When User configures the header for delete schedule request as "Content-Type" with value as "application/json"
    And User executes delete schedule request  with endpoint <Endpoint> and path param as <ScheduleId>
    Then User validates response code for delete schedule request as <ResponseCode>
    And User validates delete schedule response contains key as "success" with value as "OK"
    
    Examples:
    |Endpoint       |ScheduleId                          |ResponseCode|
    |/deleteSchedule|20010987FRDE987620018765000000002017|     200    |