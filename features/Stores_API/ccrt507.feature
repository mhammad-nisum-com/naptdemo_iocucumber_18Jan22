@ccrt507
Feature: Create APIs to initiate POS based enrolment in Orchestration service

  @creditorchestration
  Scenario: creditorchestration
    Given that param "base_url.url" is set to value "creditcard-orchestration/v1/identity/services/execute"
    When that param "headers.Content-Type" is set to value "application/json;v=1"
    When I read the JSON from file "/src/main/resources/testData/creditOrchestration/creditOrchestration.json" into Dictionary Key "PostUsers"
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get oAuth