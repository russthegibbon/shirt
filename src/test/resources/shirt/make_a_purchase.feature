Feature: make a purchase

  Scenario: buy a T-shirt
    Given I am on the shop website
    When I order a t-shirt
    Then I should see the order in my order history