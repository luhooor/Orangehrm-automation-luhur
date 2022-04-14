@HRM-login
Feature: Orange HRM - Login

  Background:
    Given I open OrangeHRM login page

  @positive
  Scenario: user login to orange HRM successfully
    When I input username and password
    And I click on the login button
    Then I can login successfully

  @HRM-login @negative
  Scenario Outline: user login to orange HRM unsuccessfully
    When I input "<username>" as username
    And I input "<password>" as password
    And I click on the login button
    Then I can see an error message: "<message>"

    Examples:
      | username | password    | message                  |
      |          |             | Username cannot be empty |
      | Admin    |             | Password cannot be empty |
      | Admin    | notpassword | Invalid credentials      |