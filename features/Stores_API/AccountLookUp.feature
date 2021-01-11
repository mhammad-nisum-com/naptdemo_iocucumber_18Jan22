@accountlookup
Feature: Account Look UP feature

  Background:
    Given that param "base_url.url" is set to value "https://storeordersqa.wsgc.com/accountlookupservice"

  @post
  Scenario: POST InitiateLookUp Scenario
    Given that param "headers.Content-Type" is set to value "application/json"
    When that param "headers.clientCode" is set to value "DevTesting"
    When that param "headers.clientToken" is set to value "rXFlcm5heWU6cGTzc4dvcmWxTjG"
    When I read the JSON from file "/src/main/java/resources/testData/InitiateLookUp.json" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "/api/accountlookupservice/v1/InitiateLookup" and Body from Dictionary Key "PostUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get sessionID

  @post
  Scenario: POST Primary Account Scenario
    Given that param "sessionheaders.Content-Type" is set to value "application/json"
    When that param "sessionheaders.sessionID" is set to value "sessionID"
    When I read the JSON from file "/src/main/java/resources/testData/primaryAccount.json" into Dictionary Key "PostPrimaryAccount" and replace the sessionID
    When I make a "POST" REST Call with URL "/api/accountlookupservice/v1/sessionID/PostLookup" and Body from Dictionary Key "PostPrimaryAccount" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostPrimaryAccount"

  @post
  Scenario: POST Secondary Account Scenario
    Given that param "sessionheaders.Content-Type" is set to value "application/json"
    When that param "sessionheaders.sessionID" is set to value "sessionID"
    When I read the JSON from file "/src/main/java/resources/testData/secondaryAccount.json" into Dictionary Key "PostSecondaryAccount" and replace the sessionID
    When I make a "POST" REST Call with URL "/api/accountlookupservice/v1/sessionID/PostLookup" and Body from Dictionary Key "PostSecondaryAccount" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostSecondaryAccount"

  @get
  Scenario: Get Lookup Questions Scenario
    When I make a "GET" REST Call with URI "/api/accountlookupservice/v1/sessionID/GetLookupQuestions" and store the response of sessionID with Dictionary Key "GetUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetUsers"

  @post
  Scenario: POST PIIData Scenario
    Given that param "xml_headers.Content-Type" is set to value "application/soap+xml; charset=utf-8"
    When I read the XML from file "/src/main/java/resources/testData/PIIData.xml" into Dictionary Key "PostPIIData"
    When I make a "POST" REST Call with URL "/api/accountlookupservice/v1/sessionID/PIIData" and Body from Dictionary Key "PostPIIData" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostPIIData"

  @get
  Scenario: Get Credit Lookup Scenario
    When I make a "GET" REST Call with URI "/api/accountlookupservice/v1/sessionID/GetCreditLookup" and store the response of sessionID with Dictionary Key "GetCreditLookUp"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetCreditLookUp"
    Then I verify that the response body with the Return Code as "100" and Return Message as "ACCOUNT FOUND" with Dictionary Key "GetCreditLookUp"
