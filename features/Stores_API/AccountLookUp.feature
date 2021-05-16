@accountlookupService
Feature: AccountLookUp

  Background:
    Given that param "base_url.url" is set to value "https://strwebappsqa2.wsgc.com/AccountLookupService_CCRP"

  @accountLookUp
  Scenario Outline: Account Look Up Service Validation Initiate LookUp,POST LookUp,Get Lookup Questions,POST PIIData Scenario,Get Credit Lookup Scenario
#***************** Initiate LookUp *****************
    Given that param "headers.Content-Type" is set to value "application/json"
    When that param "headers.clientCode" is set to value "DevTesting"
    When that param "headers.clientToken" is set to value "rXFlcm5heWU6cGTzc4dvcmWxTjG"
    When I read the JSON from file "/src/main/resources/testData/ALU_TestData/InitiateLookup.json" with StoreID "<storeID>" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "/api/accountlookupservice/v1/InitiateLookup" and Body from Dictionary Key "PostUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get sessionID
#*****************   POST LookUp  *****************
    Given that param "sessionheaders.Content-Type" is set to value "application/json"
    When that param "sessionheaders.sessionID" is set to value "sessionID"
    When I read the JSON from file "<postLookUp_Path>" into Dictionary Key "PostPrimaryAccount" and replace the sessionID
    When I make a "POST" REST Call with URL "/api/accountlookupservice/v1/sessionID/PostLookup" and Body from Dictionary Key "PostPrimaryAccount" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostPrimaryAccount"
#*****************   Get Lookup Questions  *****************
    When I make a "GET" REST Call with URI "/api/accountlookupservice/v1/sessionID/GetLookupQuestions" and store the response of sessionID with Dictionary Key "GetUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetUsers"
#*****************   POST PIIData Scenario *****************
    Given that param "xml_headers.Content-Type" is set to value "application/soap+xml; charset=utf-8"
    When I read the XML from file "<piiData_Path>" with SSN "<SSN>" into Dictionary Key "PostPIIData"
    When I make a "POST" REST Call with URL "/api/accountlookupservice/v1/sessionID/PIIData" and Body from Dictionary Key "PostPIIData" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostPIIData"
#*****************   Get Credit Lookup Scenario  *****************
    When I make a "GET" REST Call with URI "/api/accountlookupservice/v1/sessionID/GetCreditLookup" and store the response of sessionID with Dictionary Key "GetCreditLookUp"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetCreditLookUp"
    Then I verify that the response body with the Return Code as "<Return_Code>" and Return Message as "<Return_Message>" with Dictionary Key "GetCreditLookUp"

    Examples:
      | storeID | SSN       | postLookUp_Path                                              | piiData_Path                                          | Return_Code | Return_Message    |
      | 3472    | 993400028 | /src/main/resources/testData/ALU_TestData/postLookUp.json    | /src/main/resources/testData/ALU_TestData/PIIData.xml | 100         | ACCOUNT FOUND     |
      | 3423    | 993400020 | /src/main/resources/testData/ALU_TestData/postLookUp.json    | /src/main/resources/testData/ALU_TestData/PIIData.xml | 100         | ACCOUNT FOUND     |
      | 3422    | 993400022 | /src/main/resources/testData/ALU_TestData/postLookUp.json    | /src/main/resources/testData/ALU_TestData/PIIData.xml | 100         | ACCOUNT FOUND     |
      | 3471    | 666113992 | /src/main/resources/testData/ALU_TestData/postLookUp.json    | /src/main/resources/testData/ALU_TestData/PIIData.xml | 300         | ACCOUNT NOT FOUND |
      | 3471    | 666113992 | /src/main/resources/testData/ALU_TestData/postLookUp304.json | /src/main/resources/testData/ALU_TestData/PIIData.xml | 304         | Bank error        |
