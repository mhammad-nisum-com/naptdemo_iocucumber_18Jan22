@accountlookupService
Feature: Account Look UP feature

  Background:
    Given that param "base_url.url" is set to value "http://strwebappsqa2.wsgc.com/AccountLookupService_CCRP"

  @accountLookUp
  Scenario Outline: Account Look Up Service Validation Initiate LookUp,POST LookUp,Get Lookup Questions,POST PIIData Scenario,Get Credit Lookup Scenario
#   Initiate LookUp
    Given that param "headers.Content-Type" is set to value "application/json"
#    When that param "headers.clientCode" is set to value "DevTesting"
#    When that param "headers.clientToken" is set to value "rXFlcm5heWU6cGTzc4dvcmWxTjG"
    When I read the JSON from file "/src/main/resources/testData/accountLookUp_TestData/InitiateLookUp.json" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "/api/AccountLookup/InitiateLookup" and Body from Dictionary Key "PostUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get sessionID
#   POST LookUp
    Given that param "sessionheaders.Content-Type" is set to value "application/json"
    When that param "sessionheaders.sessionID" is set to value "sessionID"
    When I read the JSON from file "/src/main/resources/testData/accountLookUp_TestData/postLookUp.json" into Dictionary Key "PostPrimaryAccount" and replace the sessionID
    When I make a "POST" REST Call with URL "/api/AccountLookup/PostLookup" and Body from Dictionary Key "PostPrimaryAccount" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostPrimaryAccount"
#   Get Lookup Questions
    When I make a "GET" REST Call with URI "/api/AccountLookup/GetLookupQuestions" and store the response of sessionID with Dictionary Key "GetUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetUsers"
#   POST PIIData Scenario
    Given that param "xml_headers.Content-Type" is set to value "application/soap+xml; charset=utf-8"
    When I read the XML from file "<piiData_Path>" into Dictionary Key "PostPIIData"
    When I make a "POST" REST Call with URL "/api/AccountLookup/PIIData" and Body from Dictionary Key "PostPIIData" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostPIIData"
#   Get Credit Lookup Scenario
    When I make a "GET" REST Call with URI "/api/AccountLookup/GetCreditLookup" and store the response of sessionID with Dictionary Key "GetCreditLookUp"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetCreditLookUp"
    Then I verify that the response body with the Return Code as "<Return_Code>" and Return Message as "<Return_Message>" with Dictionary Key "GetCreditLookUp"

    Examples:
      | piiData_Path                                  | Return_Code | Return_Message    |
      | /src/main/java/resources/testData/PIIData.xml | 100         | ACCOUNT FOUND     |
      | /src/main/java/resources/testData/PIIData.xml | 300         | ACCOUNT NOT FOUND |
      | /src/main/java/resources/testData/PIIData.xml | 304         | BANK ERROR        |
