Feature: Add new users dialog

  Scenario: Placeholder tests
    Given I am on the login page
    And I login using following credentials:
      | email    | librarian21@library |
      | password | aZ849tSZ            |
    And I click on "Users" link
    When I click on Add User
    Then dialog fields must have matching placeholder
      | fullname | Full Name |
      | email    | Email     |
      | password | Password  |
      | address  |           |

  Scenario: Placeholder tests
    Given I am on the login page
    And I login using following credentials:
      | email    | librarian21@library |
      | password | aZ849tSZ            |
    And I click on "Users" link
    When I search for "486"
    Then table should contain this data
      | userID   | 486                             |
      | fullName | Asuncion Pfeffer                |
      | email    | Oralia Daugherty234@library.com |