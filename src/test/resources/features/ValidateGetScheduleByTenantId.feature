#Author: NM
#Date:
#Description:

@api
@ValidateGetSchedule
Feature: Get Schedule By Teanant Id Feature
    

  @GetScheduleByTenantIdHappyPath
  Scenario: Validation of Get Schedule By Valid Tenanat Id
    Given User configures the base uri for get book schedule by Tenant Id
    When User configures the header "Content-Type" with value as "application/json"
    And User executes get schedule request with endpoint "getSchedulebyTenantId" and query param "tenantId=TENANTID001"
    Then User validates status code "200"
    And User validates response contains key "scheduleId" with value "20010987FRDE987620018765000000002017"
    And User validates response contains key "recordStatus" with value "SCHEDULED"
    
      
  @GetScheduleByTenantIdUnHappyPath
  Scenario Outline: Validation of Get Schedule By Invalid Tenanat Id
    Given User configures the base uri for get book schedule by Tenant Id
    When User configures the header "Content-Type" with value as "application/json"
    And User executes get schedule request with endpoint as <Endpoint> and query param as <TenantId>
    Then User validates status code as <ResponseCode>
    And User validates response contains key as <ResponseKey> with value as <ResponseValue>
    
    Examples:
    
    |        Endpoint     |    TenantId          |ResponseCode|ResponseKey|        ResponseValue                                |    
    |getSchedulebyTenantId|tenantId=TENANTID006  |     404    |Error      |Not Found - Supplied Tenant Id Not Present in records|
    |getSchedulebyTenantId|tenantId=TENANTID0@@  |     400    |Error      |Invalid - Tenant Id should be alphanumeric only      |
    |getSchedulebyTenantId|tenantId=             |     400    |Error      |Invalid - Tenant Id cannot be null or empty          |
    |getSchedulebyTenantId|tenantId=TENANTIDNINE |     400    |Error      |Invalid - Tenant Id should be alphanumeric only      |
    |getSchedulebyTenantId|tenantId=0000082      |     400    |Error      |Invalid - Tenant Id should be alphanumeric only      |
   