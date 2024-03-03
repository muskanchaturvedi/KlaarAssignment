Feature: Login Functionality Negative Scenario's

  Background:
    Given the user launches the Klaar website

  Scenario: Incorrect Credentials
    When the user clicks on login button without entering username and password
    Then verify username error message should be displayed
    And  verify password error message should be displayed
    And the user clicks on the back to other options login button
    When the user enters an invalid email "rthdj" format and clicks on login
    Then verify username error message should be displayed
    And  verify password error message should be displayed
    And the user clicks on the back to other options login button
    When the user enters an incorrect email "test1@gmail.com" and password "demo123#" and clicks on login
    And verify error message about minimum attempts left should be displayed
    And the user clicks on the back to other options login button
    When the user enters a valid email "deepa.nayak@gamma.klaar.team" but an incorrect password "demo123#" and clicks on login
    And verify error message about minimum attempts left should be displayed

  Scenario: Forgot Password Functionality
    When the user clicks on reset email button without entering email
    Then verify error message about the required email should be displayed
    And the user clicks on the back to login button
    When the user enters a phone number that does not meet the requirements
    Then verify error message about the required email should be displayed
    And the user clicks on the back to login button
    When the user clicks on the reset password link and enters an email that does not meet the requirements
    Then verify error message about the required email should be displayed
    And the user clicks on the back to login button


