#Author: NM
#Date:
#Description:

@api
@ValidateUpdateSchedule
Feature: Put - Update Schedule Feature
    

  @UpdateScheduleHappyPath
  Scenario Outline: Validation of Create Schedule API
    Given User configures the base uri for update schedule
    When User configures the header for update schedule request as "Content-Type" with value as "application/json"
    And User executes update schedule request  with endpoint <Endpoint> and pathParam <ScheduleId> and payload in file <fileName>
    Then User validates response code for update schedule request as <ResponseCode>
    And User validates update schedule response contains key "scheduleId" with not null value
    And User validates update schedule response contains key "updatedDateTime" with not null value
    And User validates update schedule response contains key as "recordStatus" with value as "SCHEDULED"
    
    Examples:
    |Endpoint       |ScheduleId                          |fileName      |ResponseCode|
    |/UpdateSchedule|20010987FRDE987620018765000000002017|UpdateSchedule|     200    |