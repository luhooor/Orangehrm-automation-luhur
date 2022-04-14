@HRM-login
Feature: Orange HRM - Login


  Scenario: user login to orange HRM successfully
    Given I open OrangeHRM login page
    When I input username and password
    And I click on the login button
    Then I can login successfully