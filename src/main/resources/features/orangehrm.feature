@UI
Feature: User login to OrangeHRM then adding or deleting a new user by Admin

  Scenario: Login to Admin page

    Given User navigates to "https://opensource-demo.orangehrmlive.com/"
    And User enters a valid username "Admin" and password "admin123"


  Scenario Outline: Admin adds new user and checks it is added
    Given User navigates to "https://opensource-demo.orangehrmlive.com/"
    And User enters a valid username "Admin" and password "admin123"
    Given User navigates to admin icon
    When The number of records found
    And User clicks on add button
    And User Fills the required fields <UserRole>, <EmployeeName>, <Status>, <Username>, <Password>, <ConfirmPassword>
    And User clicks on save button
    Then User validates Total Number of Records Increased by 1


    Examples:
      | UserRole |  EmployeeName      |  Status   | Username | Password         | ConfirmPassword   |
      | Admin    |  Sagar hag hgfkag  |  Enabled  | TestSam  | sampasswordtest1 | sampasswordtest1  |


  Scenario Outline: User searches with the username and deletes it then validates it is deleted
    Given User navigates to "https://opensource-demo.orangehrmlive.com/"
    And User enters a valid username "Admin" and password "admin123"
    Given User navigates to admin icon
    Given Get Total Records Before Deleting
    When User Searches for the new user <searchInput>
    And User Deletes the new user
    And confirm to delete
    And User waits for success message
    And User clicks on Reset Research
    Then User validates that the number of records decreased by 1

    Examples:
      | searchInput |
      | TestSam     |