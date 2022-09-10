Feature: Testing Browser As A Hybrid App.

  @DemoSiteMobileApp
  Scenario: Demonstrating mobile app capabilities of NAPT
    When I switch to the "NATIVE_APP" context
    When I type the url "https://www.saucedemo.com"
    When I switch to the "WEBVIEW_chrome" context
    When I login as "standard_user"
    When I switch to the "NATIVE_APP" context
    Then I click "Back" button of browser