  @activity2
  Feature: Acitivity to test the login feature

   @loginTest
   Scenario: Successful login test
     Given the user is on the login page
     When the user enters username and password
     And clicks the submit button
     Then get the confirmation text and verify message