Feature: User Registration

  @TC01 @all
  Scenario: Verify user registration with valid details
    Given User navigates to registration page
    When User enters valid details "bhagya", "dasam", "bhagyadasam2@gmail.com", "1234567890", "bhagya@123", "bhagya@123"
    Then Registration should be successful with message "Your Account Has Been Created!"

  @TC02 @all
  Scenario: Verify registration with existing email
    Given User navigates to registration page
    When User enters existing email "bhagyadasam2@example.com"
    Then Error message for existing email is displayed

  @TC03 @all
  Scenario: Verify mandatory field validation
    Given User navigates to registration page
    When User leaves mandatory fields empty
    Then Validation errors are shown

  @TC04 @all
  Scenario: Verify successful registration message
    Given User navigates to registration page
    When User enters valid details "bhagya", "dasam", "bhagyadasam2@example.com", "1234567890", "bhagya@123", "bhagya@123"
    Then Registration should be successful with message "Your Account Has Been Created!"