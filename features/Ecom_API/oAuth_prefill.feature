@oAuth
Feature: oAuth feature

  Background:
    Given that param "base_url.url" is set to value "https://ecinvent-qa-rk1v.wsgc.com:49182/gizmotron/service"

  @post
  Scenario Outline: POST InitiateLookUp Scenario
    Given I read the JSON from file "<testData_Path>" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "/credit-partner-oauth-authorization-service/oauth2/token" and Body from Dictionary Key "PostUsers"
    Then I verify that the response code is "<StatusCode>" for the response with Dictionary Key "PostUsers" and get "<ResponseObject>"
    Examples:
    |testData_Path|StatusCode|ResponseObject|
    |/src/main/resources/testData/oAuth_TestData/SuccessRequest.json|200         |access_token  |
    |src/main/resources/testData/oAuth_TestData/400Response.json    |400         |h1            |