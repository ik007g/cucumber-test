Feature: books table

  Background:
    Given I am on the login page
    And I login to application as a librarian
    When I go to "Books" page


  @wip
  Scenario: Verify search results
    And I search for "The Goldfinch"
    Then books table should contain result matching The Goldfinch


  Scenario: Verify books information
    When I edit book The kite runner
    Then I verify book information
      | name            | author          | year |
      | The kite runner | Khaled Hosseini | 2003 |

