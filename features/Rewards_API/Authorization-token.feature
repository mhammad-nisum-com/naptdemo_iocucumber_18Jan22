@oAuth
Feature: Card feature

  Background:
    Given that param "base_url.url" is set to value "http://localhost:8080"

  @post @CCRT-504 @CardEnrollment
  Scenario: POST InitiateLookUp Scenario
    Given that param "headers.Content-Type" is set to value "application/x-www-form-urlencoded"
    When that param "headers.Authorization" is set to value "Basic ZWNvbV9XUy9RQTpXU2Vjb20xMjM="
    When I read the JSON from file "/src/main/resources/testData/CardEnrollment/body.txt" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "https://webauth-qa-rk01v.wsgc.com/oauth/token" and Body from Dictionary Key "PostUsers" to get oauth
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get oAuth




  @post @CCRT-420 @CreateLoyaltyAccount
  Scenario Outline: POST Create Loyalty Account Scenario
    Given that param "headers.Content-Type" is set to value "application/json"
    And that param "headers.Authorization" is set to value "access_token"
    And I read the JSON from file "<testData_Path>" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "/loyalty/v1/loyaltyCards" and Body from Dictionary Key "PostUsers"
    Then I verify that the response code value is "<StatusCode>" for the response with Dictionary Key "PostUsers" and get "<ResponseObject>" and "<responseMessage>"
    Examples:
      | testData_Path                                                                           | StatusCode | ResponseObject | responseMessage                                                |
      | /src/main/resources/testData/CreateLoyaltyAccount/body.json                         | 201        | status         | processed card successfully                                                        |

