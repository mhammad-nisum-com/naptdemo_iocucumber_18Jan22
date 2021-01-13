Feature: Verify whether user is able to navigate to VP page

  @browse @checkout @regression @test456
  Scenario Outline: Guest User Navigate to COF page when clicked on apply now in VP page after sign in for WE brand
    Given I am on the home page
    When User clicks on apply now link in "<applyNowLocation>"
    Then I should be on the "VP" page
    When User clicks on apply now link in "VP_ApplyNow"
    Then I should be on the "SignIn_Create" page
    And  I signin with credentials
    Then I should be on the "COF" page
    Examples:
      | applyNowLocation  |
      | PIP_page          |
      | ShoppingCart_page |
'

#  @browse @checkout @regression
#  Scenario Outline:Signed User Navigate to COF page when clicked on apply now in VP page after sign in
#    Given I am on the "WS" home page
#    When User clicks on apply now link in "<applyNowLocation>"
#    Then I should be on the "VP" page
#    When User clicks on apply now link in "VP_ApplyNow"
#    Then I should be on the "COF" page
#    Examples:
#      |applyNowLocation|
#      |Footer|
#      |myAccount|
#      |PIP_page|




