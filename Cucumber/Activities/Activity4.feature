@activity4
Feature: Data driven test without Example

  @loginTest @loginSuccess
  Scenario: Successful login test
    Given the user is on the login page
    When the user enters "admin" and "password"
    And clicks the submit button
    Then get the confirmation text and verify message as "Welcome Back, admin"

  @loginTest @loginFail
  Scenario: Test with incorrect data from inputs
    Given the user is on the login page
    When the user enters "admin12" and "password12"
    And clicks the submit button
    Then get the confirmation text and verify message as "Invalid Credentials"