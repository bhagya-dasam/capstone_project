
Feature: Wishlist

  @TC12 @all
  Scenario: Add product to wishlist
    Given User adds a product to wishlist
    When User navigates to wishlist page
    Then Product should be present in wishlist

  @TC13 @all
  Scenario: Remove product from wishlist
    Given User adds a product to wishlist
    When User navigates to wishlist page
    And User removes product from wishlist
    Then Wishlist should be empty

  @TC14 @all
  Scenario: Verify wishlist page
    Given User adds a product to wishlist
    When User navigates to wishlist page
    Then Wishlist page should show correct item details