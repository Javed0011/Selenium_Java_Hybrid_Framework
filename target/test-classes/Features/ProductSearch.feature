Feature: Search an Product and verify the Result Test
 Scenario Outline: Search Product and verify
	 Given i Navigate to the Flipkart URL
	 When i Enter the "<Product>" in Search field 
	 And i click on search button
	 Then i should be able to see the "<Product>" related to the search
 Examples:
	 |Product|
	 |OnePlus| 
	 |Apple  |
	 |Oppo   |
	 |Acer   |
	 
Scenario Outline: Search Product and verify the displyed Items
	 Given i Navigate to the Flipkart URL
	 When i Enter the "<Product>" in Search field 
	 And i click on search button
	 Then i should be able to see the list of "<Product>" getting displayed
 Examples:
	 |Product|
	 |Apple  |
	 |Oppo   |
	 |Acer   |
	 
		

	 