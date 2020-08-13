@show_records  @smoke
Feature: Show records functionality

  Background:
    Given I am on the login page
    And I login as librarian

  Scenario: verify default values in Users page
    When I click on "Users" link
    Then show records default value should be 10
    And show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |


  Scenario: Change number or rows in Users page
    And I click on "Users" link
    When I select Show 15 records
    Then show records default value should be 15
    Then table must display 15 records


  Scenario Outline: Show records all options
    When I click on "Users" link
    When I select Show <count> records
    Then show records default value should be <count>
    And table must display <count> records

    Examples:
      | count |
      | 5     |
      | 10    |
      | 15    |
#      | 50    |
#      | 100   |
#      | 200   |
#      | 500   |



