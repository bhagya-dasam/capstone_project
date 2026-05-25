Feature: Checkout Process
  As a customer
  I want to complete the checkout process

  Background:
    Given User is on home page
    And User has items in cart and proceeds to checkout
    And User enters billing details "bhagya", "dasam", "145 raod 3", "Bangalore", "560001", "India", "Karnataka"

  @TC19 @all
  Scenario: Proceed to checkout
    Then Shipping method page is displayed

  @TC20 @all
  Scenario: Enter billing details
    Then Shipping method page is displayed

  @TC21 @all
  Scenario: Select payment method
    When User selects shipping method and payment method
    Then Payment information page is displayed

  @TC22 @all
  Scenario: Confirm order successfully
    When User selects shipping method and payment method
    And User enters payment details "Visa", "bhagya dasam", "4111111111112345", "02", "2030", "345"
    And User confirms the order
    Then Order should be successful with confirmation message