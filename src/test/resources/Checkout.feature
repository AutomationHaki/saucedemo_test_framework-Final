Feature: Checkout
  Scenario: Completing the purchase of the Fleece Jacket
    Given The user is logged in
    When The user adds the Fleece Jacket to their cart
    And The user navigates to their cart
    And The user clicks the checkout button
    Then The user enters delivery info
    And Finalizes the checkout process