
Feature: Shopping Cart

  @TC15 @all
  Scenario: Add product to cart
    Given User adds a product to cart
    When User goes to cart page
    Then Product should be in cart

  @TC16 @all
  Scenario: Update quantity in cart
    Given User adds a product to cart
    When User goes to cart page
    And User updates quantity to "3"
    Then Cart total should be updated

  @TC17 @all
  Scenario: Remove item from cart
    Given User adds a product to cart
    When User goes to cart page
    And User removes item from cart
    Then Cart should be empty

  @TC18 @all
  Scenario: Verify cart total
    Given User adds a product to cart
    When User goes to cart page
    Then Cart total should be updated