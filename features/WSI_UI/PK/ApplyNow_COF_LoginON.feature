Feature: Verify whether user is able to navigate to VP page from Footer

  @browse @checkout @regression
  Scenario Outline: Guest User Navigate to COF page when clicked on apply now in VP page after sign in
    Given I am on the "WS" home page
    When User clicks on apply now link in "<applyNowLocation>"
    Then I should be on the "VP" page
    When User clicks on apply now link in "VP_ApplyNow"
    Then I should be on the "SignIn_Create" page
    Examples:
      |applyNowLocation|
      |PIP_page|
      |Footer|
      |myAccount|


  @browse @checkout @regression
  Scenario Outline:Signed User Navigate to COF page when clicked on apply now in VP page after sign in
    Given I am on the "WS" home page
    When User clicks on apply now link in "<applyNowLocation>"
    Then I should be on the "VP" page
    When User clicks on apply now link in "VP_ApplyNow"
    Then I should be on the "COF" page
    Examples:
      |applyNowLocation|
      |Footer|
      |myAccount|
      |PIP_page|

  @browse @checkout @regression @sign123  @584
  Scenario Outline: Verify whether able to navigate properly to COF page after sign in or creating account
    Given I navigate to the "/instant-credit-accept.html" url through browser
    Then I should be on the "SignIn_Create" page
    And  I "<SignIn_CreateAccount>" with credentials
    Then I should be on the "COF" page
    Examples:
      | SignIn_CreateAccount  |
      | signin          |
      | createAccount |




