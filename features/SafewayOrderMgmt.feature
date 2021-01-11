Feature: Checkout
  Background:
  Given that param "globals.ldapApi" is set to value "http://authentication-service-qa3.apps.np.stratus.albertsons.com"
  Given that param "globals.activitiesApi" is set to value "https://osco-pick-services-qa3.apps.np.stratus.albertsons.com"
  Given that param "globals.uriLdapToken" is set to value "/ldapToken"
  Given that param "globals.uriSearchActivities" is set to value "/api/searchActivities?open=true&userId=vgunj00&siteId=2941"
  Given that param "globals.uriGetActivity" is set to value "/api/activity/9688?loadCA=true&loadIA=true"

  @safewayorder @regression @smoke
  Scenario: User can create an order
    Given that I set the headers for "searchActivities"
    Given that I set the headers for "getActivity"
    When I call the get search activities for storeId "2941"
    Then I verify that activity "9708" is present in the response
    And I pick up activity id "9708"
    Then I verify that the following items are present in the activity.
    |ItemId   |
    |184710678    |
    |184710365    |
    |184710053    |
    |184480039    |
    |184410069    |



