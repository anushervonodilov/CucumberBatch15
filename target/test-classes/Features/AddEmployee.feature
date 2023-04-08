Feature: Employee
  @testcase2 @smoke
  Scenario: Valid Admin login
    Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user click on Add employee button
    And user enters firstname and middle and lastname
    And user click on save button
