Feature: Prices
  As a customer
  I want to query the available price models
  So that I can decide which one to purchase.

  Scenario Outline:
    Given the following prices are configured
      | name     | price |
      | default  | 0.1   |
      | discount | 0.07  |
    When I query the prices for model <name>
    Then I get the price <price>

    Examples:
      | name     | price |
      | default  | 0.1   |
      | discount | 0.07  |