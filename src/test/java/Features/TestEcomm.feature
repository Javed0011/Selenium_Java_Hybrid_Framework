Feature: TestEcomm

  @Ecomm @Search
  Scenario Outline: Search for a product "<Product>"
    Given User is on the Ecomm home page
    When User searches for "<Product>"
    Then Search results for "<Product>" should be displayed
    Examples:
      | Product |
      | Laptop  |
      | iPhone  |
      | Tab     |