@ccrt239
Feature: User can apply for card at the store once the Associate initiates it through POS

  @getaccesstoken
  Scenario: Access Token
    Given that param "base_url.url" is set to value "https://api-partner-it.capitalone.com:9001"
    When that param "headers.Content-Type" is set to value "application/x-www-form-urlencoded"
    When that param "oauthEncoded.client_secret" is set to value "7e730a8909e9edcc26914845d2d74bce"
    When that param "oauthEncoded.grant_type" is set to value "client_credentials"
    When that param "oauthEncoded.client_id" is set to value "0dab20d9264644b083bec5c9f1c38b85"
    When I read the JSON from file "/src/main/resources/testData/applyForCard/body.txt" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "/oauth2/token" and Body from Dictionary Key "PostUsers" to get oauthEncoded
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get oAuth

  @getpublickey
  Scenario: Get Public key
    Given that param "base_url.url" is set to value "https://api-partner-it.capitalone.com:9001/developer-platform/key-management/certificates"
    When that param "headers.Accept" is set to value "application/json;v=1"
    When that param "headers.Authorization" is set to value "access_token"
    When I make a "GET" REST Call with URI "/keys?productId=EncryptionKeyRotation&kty=RSA&keyId=1234568&listAllowedClients=true" and store the response with Dictionary Key "GetUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetUsers"

  Scenario: Initiate Look Up
    Given that param "headers.Content-Type" is set to value "application/json"
    When I read the JSON from file "/src/main/resources/testData/accountLookUp_TestData/InitiateLookUp.json" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "/api/AccountLookup/InitiateLookup" and Body from Dictionary Key "PostUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get sessionID

  Scenario: Disclosure Acknowledgement
    Given that param "headers.Content-Type" is set to value "application/json"
    When I read the JSON from file "/src/main/resources/testData/accountLookUp_TestData/InitiateLookUp.json" into Dictionary Key "PostDisAck"
    When I make a "POST" REST Call with URL "/api/AccountLookup/InitiateLookup" and Body from Dictionary Key "PostDisAck"
    Then I verify that the response code is "200" for the response with Dictionary Key "PostDisAck" and get sessionID

  Scenario: Scan Driver Licence
    Given that param "headers.Content-Type" is set to value "application/json"
    When I read the JSON from file "/src/main/resources/testData/applyForCard/scanDriverLicense.json" into Dictionary Key "PostScanUsers"
    When I make a "POST" REST Call with URL "/api/AccountLookup/ScanDriverLicense" and Body from Dictionary Key "PostScanUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "PostScanUsers" and get sessionID

  Scenario: Get Lookup Questions
    When I make a "GET" REST Call with URI "/api/AccountLookup/GetLookupQuestions" and store the response of sessionID with Dictionary Key "GetUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetUsers"

  Scenario Outline: Apply For Card
    Given that param "xml_headers.Content-Type" is set to value "application/soap+xml; charset=utf-8"
    When I read the XML from file "<piiData_Path>" into Dictionary Key "PostPIIData"
    When I make a "POST" REST Call with URL "/api/AccountLookup/PIIData" and Body from Dictionary Key "PostPIIData" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostPIIData"

    Examples:
      | piiData_Path                                      |
      | /src/main/java/resources/applyForCard/PIIData.xml |