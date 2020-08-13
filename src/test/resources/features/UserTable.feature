
Feature: User table
  Scenario: unique user ID
    Given I am on the login page
    And I login as librarian
    When I click on "Users" link
    Then  Each User ID should be unique