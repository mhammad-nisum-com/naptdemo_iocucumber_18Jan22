Feature: Verify whether user is able to navigate to VP page from Footer




  @browse @checkout @regression
  Scenario Outline: Guest User Navigate to COF page when clicked on apply now in VP page after sign in
    Given I am on the home page
    When User clicks on apply now link in "<applyNowLocation>"
    Then I should be on the "VP" page
#    When User clicks on apply now link in "VP_ApplyNow"
    Then I should be on the "SignIn_Create" page
    And  I signin with credentials
    Then I should be on the "COF" page
    Examples:
      |applyNowLocation|
      |Footer|



  @browse @checkout @regression @WIP
  Scenario Outline: Signed User Navigate to COF page when clicked on apply now in VP page after sign in
    Given I am on the "WS" home page
    Then I click on "Signin" button under Myaccount
    And  I signin with credentials
    When User clicks on apply now link in "<applyNowLocation>"
    Then I should be on the "VP" page
    When User clicks on apply now link in "VP_ApplyNow"
    Then I should be on the "COF" page
    Examples:
      |applyNowLocation|
      |Footer|








