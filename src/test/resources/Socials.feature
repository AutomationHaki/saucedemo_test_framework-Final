Feature:Social Media Buttons
  Scenario: Validate Twitter Button link
    Given The user is logged in
    When The user clicks on the twitter button
    Then The user is directed to the company's twitter profile

  Scenario: Validate Facebook Button Link
    Given The user is logged in
    When The user clicks on the facebook button
    Then The user is directed to the company's facebook profile

  Scenario: Validate LinkedIn Button Link
    Given The user is logged in
    When The user clicks on the linkedin button
    Then The user is directed to the company's linkedin profile