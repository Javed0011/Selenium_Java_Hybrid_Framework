Feature: Verify the Products in ShoppingKart

Scenario Outline: Verify the product added in shoppingkart
	 Given i Navigate to the Flipkart URL
	 When i Enter the "<Product>" in Search field 
	 And i click on search button
	 Then Open the "<Product>" 
	 And Add the product to Kart and verify the Product
Examples:
		|Product|
		|Apple  |
		|Oppo   |
	  |vivo   |
Scenario Outline: Verify the product count in ShoppingKart
	Given i Navigate to the Flipkart URL
	When i Enter the "<Product>" in Search field 
	And i click on search button
	Then Open the "<Product>" 
	And Add the product to Kart and verify the Product count
Examples:
		|Product|
		|Oppo  |

Scenario Outline: Verify the product count in ShoppingKart
	Given i Navigate to the Flipkart URL
	When i Enter the "<Product>" in Search field 
	And i click on search button
	Then Open the "<Product>" 
	And Change the Productcount and Verify the Price
Examples:
		|Product|
		|Oppo  |