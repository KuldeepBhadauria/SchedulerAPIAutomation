#Author: NM
#Date:
#Description:

@api
@ValidateGetSchedule
Feature: Get Schedule By Teanant Id Feature
    

  @GetScheduleByTenantIdHappyPath
   Scenario Outline: Validation of Get Schedule By Valid Tenanat Id
    Given User configures the base uri for api request
    When User configures the header for request
    
    | HeaderName  |   HeaderValue    |
    |Content-Type |application/json  |
    
    And User executes "<requestMethod>" request  with endpoint "getSchedulebyTenantId?tenantId=TENANTID001"
    Then User validates response code for request is 200
    And User validates response contains key value pair
    
    |    Key         |           Value                    |
    |scheduleId      |20010987FRDE987620018765000000002017|
    |recordStatus    |SCHEDULED                           |
 
    And User validates response body matches the response in file "GetScheduleByTenantID" at location "<responseFolderPath>"
    
    Examples:
    |requestMethod|responseFolderPath                 |
    |GET          |src/test/resources/responseObjects/|
    
      
  @GetScheduleByTenantIdUnHappyPath
  Scenario Outline: Validation of Get Schedule By Invalid Tenanat Id
    Given User configures the base uri for api request
    When User configures the header for request
    
    | HeaderName  |   HeaderValue    |
    |Content-Type |application/json  |
    
    And User executes "<requestMethod>" request  with endpoint "<Endpoint>"
    Then User validates response code for request is <ResponseCode>
    And User validates response body matches the response in file "<fileName>" at location "<responseFolderPath>"
    
    Examples:
    
    |requestMethod|        Endpoint                            |ResponseCode|        fileName                    |responseFolderPath                 |    
    |GET          |getSchedulebyTenantId?tenantId=TENANTID006  |     404    |GetScheduleByNotPresentTenantID     |src/test/resources/responseObjects/| 
    |GET          |getSchedulebyTenantId?tenantId=TENANTID0@@  |     400    |GetScheduleByNonAlphanumericTenantID|src/test/resources/responseObjects/|
    |GET          |getSchedulebyTenantId?tenantId=             |     400    |GetScheduleByNullTenantID           |src/test/resources/responseObjects/|
    |GET          |getSchedulebyTenantId?tenantId=TENANTIDNINE |     400    |GetScheduleByNonAlphanumericTenantID|src/test/resources/responseObjects/|
    |GET          |getSchedulebyTenantId?tenantId=0000082      |     400    |GetScheduleByNonAlphanumericTenantID|src/test/resources/responseObjects/|
   