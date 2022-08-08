#Author: NM
#Date:
#Description:

@api
@ValidateCreateSchedule
Feature: Post - Create Schedule Feature
    

  @CreateScheduleHappyPath
  Scenario Outline: Validation of Create Schedule API
    Given User configures the base uri for create schedule
    When User configures the header for create schedule request as "Content-Type" with value as "application/json"
    And User executes create schedule request  with endpoint <Endpoint> and payload in file <fileName>
    Then User validates response code for create schedule request as <ResponseCode>
    And User validates create schedule response contains key as <keyName> with value as <keyValue>
    And User validates create schedule response contains key "creationDateTime" with not null value
    
    Examples:
    |Endpoint       |fileName      |ResponseCode|keyName   |keyValue                            |
    |/CreateSchedule|CreateSchedule|     201    |scheduleId|20010987FRDE987620018765000000002017|
    
  
  
  @CreateScheduleUnHappyPath
  Scenario Outline: Validation of Unhappy Path for Create Schedule API
    Given User configures the base uri for create schedule
    When User configures the header for create schedule request as "Content-Type" with value as "application/json"
    And User executes create schedule request  with endpoint <Endpoint> and payload in file <fileName>
    Then User validates response code for create schedule request as <ResponseCode>
    And User validates create schedule response contains key as <keyName> with value as <keyValue>
    
    Examples:
    |Endpoint       |fileName                       |ResponseCode|keyName  |keyValue                                                      |
    |/CreateSchedule|CreateScheduleMissingParameters|     400    |Error    |Either one or all of the mandatory fields required are missing|
  