Feature: Verify whether user is able to navigate to VP page from Footer




  @browse @checkout @regression
  Scenario Outline: User Navigate to VP page when clicked on apply now under My Account
    Given I am on the "WS" home page
    When User clicks on apply now link in "<applyNowLocation>"
    Then I should be on the "VP" page
    When User clicks on apply now link in "VP_ApplyNow"
    Then I should be on the "SignIn_Create" page
    Examples:
      |applyNowLocation|
      |Footer          |
      |myAccount|
      |PIP_page|

  @browse @checkout1 @regression
  Scenario Outline: SignedUserNavigatetocomenitypagewhenclickedonapplynowonapplynowinVPpage
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




