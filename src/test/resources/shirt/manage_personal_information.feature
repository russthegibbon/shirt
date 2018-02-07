Feature: manage personal information

  Scenario: update first name
    Given I am signed into the shop website
    When I update my first name
    Then I should see my updated first name in the header bar
