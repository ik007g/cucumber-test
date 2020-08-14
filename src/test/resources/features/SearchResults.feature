@regression
Feature: Search functionality on the Users page

  Background:
    Given I am on the login page
  Scenario: Search accuracy
    And I login as librarian
    And I click on "Users" link
    When I search for "fernando"
    Then table should contain rows with "fernando"

  Scenario: table columns names
    And I login using "librarian21@library" and "aZ849tSZ"
    When I click on "Users" link
    Then table should have following columns names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |