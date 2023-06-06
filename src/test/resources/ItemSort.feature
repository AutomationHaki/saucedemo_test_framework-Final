Feature: Sorting Items
  Scenario: Sort Items by price, low to high
    Given The user is logged in
    When The user selects the low to high sort option
    Then The items should be sorted by price in ascending order