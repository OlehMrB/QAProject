Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check login customer user
    Given User opens '<homePage>' page
    And User checks profiles button visibility
    And User clicks SignIn
    And User checks email address field visibility
    When User fills email address '<logins>'
    And User checks password field visibility
    When User fills password field '<passwords>'
    And User clicks SignIn button
    Then User checks yours fill profileName '<successWelcome>' in profile

    Examples:
    | homePage             | logins                  | passwords        |successWelcome|
    | https://www.asos.com | balaniukop@gmail.com    | 1234567890       |WELCOME TO   |

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks wish list on first product
    Then User checks that amount of products in wish list are '<amountOfProducts>'

    Examples:
      | homePage               | keyword | amountOfProducts |
      | https://www.asos.com/  | bag     | 1                |