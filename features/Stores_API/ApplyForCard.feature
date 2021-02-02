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