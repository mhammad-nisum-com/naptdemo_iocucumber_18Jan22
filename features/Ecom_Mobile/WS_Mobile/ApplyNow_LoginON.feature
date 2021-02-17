Feature: Verify whether user is able to navigate to VP page from Footer in Mobile View

  @browse @checkout @regression @ApplyNow_WS_Mobile
  Scenario Outline: Guest User Navigate to COF page when clicked on apply now in VP page after sign in Mobile View
    Given I am on the home page
    When User clicks on apply now link in "<applyNowLocation>"
    Then I should be on the "<VP_page>" page
    When User clicks on apply now link in "VP_ApplyNow"
    Then I should be on the "SignIn_Create" page
    And  I "signin" with credentials
    Then I should be on the "COF" page
    And I click on "returnWSI" button
    Then I should be on the "<returnPage>" page
    Examples:
      | applyNowLocation | VP_page   | returnPage  |
      | PIP_page_WS      | VP_PIPage | productPage |

  @browse @checkout @regression @ApplyNow_WS_Mobile1
  Scenario Outline: Signed User Navigate to COF page when clicked on apply now in VP page after sign in WS brand
    Given I am on the home page
    Then I click on "Signin" button in MobileView
    And  I "signin" with credentials
    When User clicks on apply now link in "<applyNowLocation>"
    Then I should be on the "<VP_page>" page
    When User clicks on apply now link in "VP_ApplyNow"
    Then I should be on the "COF" page
    And I click on "returnWSI" button
    Then I should be on the "<returnPage>" page
    Examples:
      | applyNowLocation | VP_page   | returnPage  |
      | PIP_page_WS      | VP_PIPage | productPage |

  @browse @checkout @regression @ApplyNow_WS_Mobile
  Scenario Outline: Verify whether user is navigated properly to COF page after creating account
    Given I am on the home page
    When User clicks on apply now link in "<applyNowLocation>"
    Then I should be on the "<VP_page>" page
    When User clicks on apply now link in "VP_ApplyNow"
    Then I should be on the "SignIn_Create" page
    And  I "createAccount" with credentials
    Then I should be on the "COF" page
    And I click on "returnWSI" button
    Then I should be on the "<returnPage>" page
    Examples:
      | applyNowLocation | VP_page   | returnPage  |
      | PIP_page_WS      | VP_PIPage | productPage |
