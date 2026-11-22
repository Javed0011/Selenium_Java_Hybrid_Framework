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

  @Ecomm @ProductDetails
  Scenario Outline: view product details "<Product>"
    Given User is on the Ecomm home page
    When User searches for "<Product>"
    And User selects the first product from search results
    Then Product details page should be displayed
    Examples:
      | Product     |
      | Redmi Pad 2 |
      | iPhone      |
      | Laptop      |

  @Ecomm @ShoppingCart
  Scenario Outline: view product details "<Product>"
    Given User is on the Ecomm home page
    When User searches for "<Product>"
    And User selects the first product from search results
    And User adds the product to the shopping cart
    Then verify the Product in cart
    Examples:
      | Product     |
      | Redmi Pad 2 |
      | Samsung Tab |
      | realme      |