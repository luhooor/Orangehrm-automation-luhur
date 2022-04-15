@HRM-CRUD
Feature: Orange HRM - CRUD Employee Data

  Background:
    Given I open OrangeHRM login page
    And I input username and password
    And I click on the login button
    And I access employee list

  @HRM-List
  Scenario: User read employee list successfully
    Then I can see the employee list

  @HRM-Create
  Scenario: User add employee successfully
    When I add new employee with required fields only
    Then I can see the newly created user personal details

  @HRM-Update
  Scenario: User update employee successfully
    When I search for new employee
    And I update the employee middle name
    Then I can see the personal detail has changed

  @HRM-Delete
  Scenario: User delete an employee successfully
    When I search for new employee
    And I delete the employee
    Then I cannot see the deleted employee on the list
