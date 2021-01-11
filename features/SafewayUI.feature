Feature: To test the Safeway Website

  @Test
  Scenario: To test search feature
    Given that I open the home page of safeway website
    And I signin to the website
    When I search for "Milk" on the home page
    And I select a random search result
