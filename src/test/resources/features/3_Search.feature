
Feature: Product Search

  @TC09 @all
  Scenario: Search product with valid keyword
    When User searches for product "iPhone"
    Then Search results should display at least one product

  @TC10 @all
  Scenario: Search product with invalid keyword
    When User searches for product "NonexistentProductXYZ"
    Then No products message should appear

  @TC11 @all
  Scenario: Verify product details page
    When User searches for product "MacBook"
    And User clicks on the first product
    Then Product details page should open