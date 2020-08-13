@smoke @login @lib-100
Feature: Login
  As a user,
  I should be able to login

  @librarian @staff @wip
  Scenario: Login as a librarian
    Given I am on the login page
    When I login as librarian
    Then dashboard should be displayed

  @student @staff
  Scenario: Login as a student
    Given I am on the login page
    When I login as student
    Then student dashboard should be displayed

    @admin
  Scenario: Login as an admin
    Given I am on the login page
    When I login as an admin
    Then dashboard should be displayed


