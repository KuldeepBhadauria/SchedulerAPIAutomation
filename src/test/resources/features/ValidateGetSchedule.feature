#Author: NM
#Date:
#Description:

@api
@ValidateGetScheduleApi
Feature: Get Schedule API By Invalid Teanant Id Feature   
      
  @GetScheduleByTenantIdApiUnHappyPath
  Scenario Outline: Validation of Get Schedule API By Invalid Tenanat Id
    Given User configures the base uri for get book schedule by Tenant Id
    When User configures the header "Content-Type" with value as "application/json"
    When User executes get schedule request with endpoint and query param values from sheet name "<EndpointSheetName>" and row number <EndPointRowNumber>
    Then User validates status code from sheet name "<ResponseCodeSheetName>" and row number <ResponseCodeRowNum>
    Then User validates reponse key and value from sheet name "<ResponseSheetName>" and row number <ResponseSheetRowNum>
    
    Examples:    
    |EndpointSheetName|EndPointRowNumber|ResponseCodeSheetName|ResponseCodeRowNum|ResponseSheetName|ResponseSheetRowNum|    
    |EndpointSheet    |        0        |ResponseCode         |       0          |ResponseKeyValue |        0          |
    |EndpointSheet    |        1        |ResponseCode         |       1          |ResponseKeyValue |        1          |
    |EndpointSheet    |        2        |ResponseCode         |       1          |ResponseKeyValue |        2          |
    |EndpointSheet    |        3        |ResponseCode         |       1          |ResponseKeyValue |        1          | 