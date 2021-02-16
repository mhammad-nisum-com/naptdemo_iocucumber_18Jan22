Feature: Checkout
  Background:
  Given that param "globals.ldapApi" is set to value "http://authentication-service-qa3.apps.np.stratus.albertsons.com"
  Given that param "globals.activitiesApi" is set to value "https://osco-pick-services-qa3.apps.np.stratus.albertsons.com"
  Given that param "globals.uriLdapToken" is set to value "/ldapToken"
  Given that param "globals.uriSearchActivities" is set to value "/api/searchActivities"
  Given that param "globals.uriGetActivity" is set to value "/api/activity/{activityId}"

  @safewayorder @regression @smoke
  Scenario: User can create an order
    Given that I set the headers for "searchActivities"
    Given that I set the headers for "getActivity"
    When I call the get search activities for storeId "2941"
    Then I verify that activity "10627" is present in the response
    And I get details for activity id "10627"
    Then I verify that the following items are present in the activity.
    |ItemId       |
    |960228461    |
    |960134449    |
    |184060016    |
    |188300244    |


















    #Given that I set the headers for "ldapToken"
    #And that I generate a new LDAP token
    #Given that param "globals.uriSearchActivities" is set to value "/api/searchActivities?open=true&userId=vgunj00&siteId=2941"
    #Given that param "globals.uriGetActivity" is set to value "/api/activity/{activityId}?loadCA=true&loadIA=true"