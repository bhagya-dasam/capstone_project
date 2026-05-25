Feature: User Login

  @TC05 @all
  Scenario: Login with valid credentials
    Given User is on login page
    When User enters email "bhagyadasam2@gmail.com" and password "bhagya@123"
    Then User should be logged in successfully

  @TC06 @all
  Scenario: Login with invalid credentials
    Given User is on login page
    When User enters email "wrong@test.com" and password "wrong"
    Then Error message "Warning: No match for E-Mail Address and/or Password." is displayed

  @TC07 @all
  Scenario: Verify forgot password functionality
    Given User is on login page
    When User clicks on forgot password link
    Then Password recovery page is opened

  @TC08 @all
  Scenario: Verify logout functionality
    Given User is on login page
    When User enters email "bhagyadasam2@gmail.com" and password "bhagya@123"
    And User clicks logout
    Then User is redirected to home page and login link is visible