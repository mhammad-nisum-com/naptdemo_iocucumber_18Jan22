@oAuth
Feature: Get Card Details API
  Background:
    Given that param "base_url.url" is set to value "https://ecommerceaugusta-credit-card-orchestration-service-ccrt586.services.west.nonprod.wsgc.com"
  @post
  Scenario: POST InitiateLookUp Scenario
    Given that param "headers.Content-Type" is set to value "application/x-www-form-urlencoded"
    When that param "headers.Authorization" is set to value "Basic ZWNvbV9XUy9RQTpXU2Vjb20xMjM="
    When I read the JSON from file "/src/main/resources/testData/CardEnrollment/body.txt" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "https://webauth-qa-rk01v.wsgc.com/oauth/token" and Body from Dictionary Key "PostUsers" to get oauth
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get oAuth

  @post @CCRT-504
  Scenario: POST InitiateLookUp Scenario
    Given that param "headers.Content-Type" is set to value "application/json"
    When that param "headers.Authorization" is set to value "access_token"
    When I make a "params" REST Call with URI "/creditcard-orchestration/v1/card-account-details" and store the response with Dictionary Key "GetUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetUsers" for response

  @post @CCRT-504
  Scenario: POST InitiateLookUp Scenario
    Given that param "headers.Content-Type" is set to value "application/json"
    When that param "headers.Authorization" is set to value "access_token"
    When I make a "params_null" REST Call with URI "/creditcard-orchestration/v1/card-account-details" and store the response with Dictionary Key "GetUsers"
    Then I verify that the response code is "400" for the response with Dictionary Key "GetUsers" and get "errorMessage" and "missing or invalid partner request id"