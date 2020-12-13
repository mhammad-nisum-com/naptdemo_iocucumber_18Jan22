Feature: Checkout

    @browse @checkout @regression
      Scenario: User can checkout the cart items.
        Given I am on the home page
        When I search for "athletic tshirts" on home page
        And I select a random search result
        And I add item to bag
        And I checkout the bag items as guest with the following details
          |testaccount@gmail.com|Malav Parekh |44301 Fremont Boulevard|         |Fremont|CA   |94538|6696692200 |
        #|EMAIL                    |FULL NAME    |STREET ADDRESS         |APT UNIT |CITY   |STATE|ZIP  |PHONE      |










