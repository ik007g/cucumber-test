@smoke @lib-132 @navigation @hub @lol
Feature: Page navigation links

  Background:
    Given I am on the login page
    And I login as librarian
@db
  Scenario: Go to users page
    When I click on "Users" link
    Then "Users" page should be displayed

  Scenario: Go to books page
    When I click on "Books" link
    Then "Books" page should be displayed

    Scenario: Go to dashboard page
      And I click on "Books" link
      And I click on "Dashboard" link
      Then "Dashboard" page should be displayed