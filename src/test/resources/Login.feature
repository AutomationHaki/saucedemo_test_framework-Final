Feature: Login functionality

Scenario: Successful Login
  Given The user is on the login page of SwagLabs
  When The user enters valid credentials
  And The user clicks the login button
  Then The user should be taken to the Inventory page