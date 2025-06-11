# src/test/resources/features/signup_login.feature
Feature: Sign-Up and Login Flow

  Scenario: Create account and login with valid credentials
    Given user is on the create account page
    When user enters valid details and submits the form
    Then account should be created successfully

    Given user is on the login page
    When user enters valid credentials
    Then user should be logged in successfully
