@oAuth
Feature: Card feature

  Background:
    Given that param "base_url.url" is set to value "https://loyalty-dev1-rk1v.wsgc.com"

  @post @AccessToken
  Scenario: POST initialization access token for api's
    Given that param "headers.Content-Type" is set to value with bearer token  "application/x-www-form-urlencoded"
    And that param "headers.Authorization" is set to value "Basic ZWNvbV9XUy9RQTpXU2Vjb20xMjM="
    And I read the JSON from given file "/src/main/resources/testData/CardEnrollment/body.txt" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "https://webauth-qa-rk01v.wsgc.com/oauth/token" and Body from Dictionary Key "PostUsers" to get oauth
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get oAuth


  @post @CreateLoyaltyAccount
  Scenario Outline: POST Create Loyalty Account Scenario
    Given that param "headers.Content-Type" is set to value with bearer token  "application/json"
    And that param "headers.Authorization" is set to value "access_token"
    And I read the JSON from given file "<testData_Path>" and replace partner id with random generated into Dictionary Key "CREATE_ACCOUNT"
    When I make a "POST" REST Call with URL "/loyalty/v1/loyaltyCards" with random generated partner id and Body from Dictionary Key "CREATE_ACCOUNT"
    Then I verify that the post response code value is "<StatusCode>" for the response with Dictionary Key "CREATE_ACCOUNT" and get "<ResponseObject>" and "<responseMessage>"
    Examples:
      | testData_Path                                                             | StatusCode | ResponseObject | responseMessage             |
      | /src/main/resources/testData/CreateLoyaltyAccount/create_api_payload.json | 201        | status         | processed card successfully |


  @get  @GetLoyaltyCardAccount
  Scenario: Get loyalty card account by loyalty card id
    Given that param "headers.Content-Type" is set to value with bearer token  "application/json"
    And that param "headers.Authorization" is set to value "access_token"
    When I make a "GET" REST Call with URL "/loyalty/v1/loyaltyCards" from Dictionary Key "GET_ACCOUNT"
    Then I verify that the get response code value is "200" for the response with Dictionary Key "GET_ACCOUNT"

  @get  @LookupLoyaltyCardAccount
  Scenario: Lookup loyalty card account
    Given that param "headers.Content-Type" is set to value with bearer token  "application/json"
    And that param "headers.Authorization" is set to value "access_token"
    When I make a "LOOKUP" REST Call with URL "/loyalty/v1/loyaltyCards" from Dictionary Key "LOOKUP_ACCOUNT"
    Then I verify that the lookup response code value is "200" for the response with Dictionary Key "LOOKUP_ACCOUNT"


  @get  @loyaltyAccountWithPartnerNameAndPartnerID
    Scenario: Lookup PartnerName and PartnerID
    Given that param "headers.Content-Type" is set to value with bearer token  "application/json"
    And that param "headers.Authorization" is set to value "access_token"
    When I make a "GetAccountWithPartner" Call with PartnerName and PartnerId from Dictionary Key "CREATE_ACCOUNT" and URL "/loyalty/v1/loyaltyCards/partner" from Dictionary Key "GET_ACCOUNT_BY_PARTNER"
    Then I verify that the get response code value is "200" for the response with Dictionary Key "GET_ACCOUNT_BY_PARTNER" with "CREATE_ACCOUNT"

  @post @CreateTokenLoyaltyAccount
  Scenario Outline:
    Given that param "headers.Content-Type" is set to value with bearer token  "application/json"
    And that param "headers.Authorization" is set to value "access_token"
    And I read the JSON from given file "<testData_Path>" and replace token id with random generated into Dictionary Key "CREATE_TOKEN"
    When I make a "POSTTOKEN" Call with loyaltyId from Dictionary Key "CREATE_ACCOUNT" and Request Dictionary Key "CREATE_TOKEN" and URL "/loyalty/v1/loyaltyCards"
    Then I verify the response with status code "<StatusCode>" for Dictionary Key "CREATE_TOKEN"

    Examples:
      | testData_Path                                                             | StatusCode |
      | /src/main/resources/testData/CreateLoyaltyAccount/create_token_api_payload.json | 201   |

