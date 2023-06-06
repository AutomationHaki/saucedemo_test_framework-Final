Feature: Add Item To Cart
  Scenario: Adding a Fleece Jacket to the cart
    Given The user is logged in
    When The user adds the Fleece Jacket to their cart
    And The user navigates to their cart
    Then The Fleece Jacket should be added to the cart