Feature: FB Login

  @FB-Login
  Scenario: user login to FB unsuccessfully
    Given I open facebook login page
    When I input email and password
    And I click button login
    Then I can't see my news feed
    But I see FB has disabled my account