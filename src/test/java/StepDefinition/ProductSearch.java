package StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import resources.base;

public class ProductSearch extends base {
	

	@Given("i Navigate to the Flipkart URL")
	public void i_navigate_to_the_Flipkart_url() throws IOException {
		driver = initializeDriver();
	    driver.get(prop.getProperty("url"));
	    
	}

	@When("i Enter the {string} in Search field")
	public void i_enter_the_product_in_search_field(String product) {
		LandingPage landingpage = new LandingPage(driver);
	    landingpage.SearchField().sendKeys(product);
	    
	}

	@When("i click on search button")
	public void i_click_on_search_button() {
	    LandingPage landingpage = new LandingPage(driver);
	    landingpage.SearchButton().click();
	}

	@Then("i should be able to see the {string} related to the search")
	public void i_should_be_able_to_see_the_products_related_to_the_search(String Product) throws InterruptedException {
		LandingPage landingpage = new LandingPage(driver);
		landingpage.SearchResultText().getText().contains(Product);
	}
	@Then("i should be able to see the list of {string} getting displayed")
	public void i_should_be_able_to_see_the_list_of_Products_getting_displayed(String Product) {
		LandingPage landingpage = new LandingPage(driver);
		for(WebElement product:landingpage.displayedProductslist()) {
			String productText = product.getText().toLowerCase();
			Assert.assertTrue(productText.contains(Product.toLowerCase()));
		}
	}
	@After
    public void closure() {
    	driver.quit();
    }

}
