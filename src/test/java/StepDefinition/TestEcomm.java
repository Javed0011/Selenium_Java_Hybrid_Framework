package StepDefinition;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageobjects.*;
import resources.base;
import utilities.ExtentReporter;

public class TestEcomm extends base {
    public String ProductName1;
    public String ProductName2;
    Properties prop = new Properties();
    FileInputStream fis;
    public TestEcomm() throws IOException {
        fis = new FileInputStream("src/main/java/resources/data.properties");
        prop.load(fis);
    }


    @Given("User is on the Ecomm home page")
    public void user_is_on_the_ecomm_home_page()
            throws IOException, InterruptedException {

        ExtentReporter.createNode("Application Launch");

        // Initialize browser
        base b = new base();
        WebDriver driver = b.initializeDriver();

        driver.manage().window().maximize();
        ExtentReporter.logInfo("Browser launched successfully");

        // Initialize Page Object
        EcommLandingPage landingPage = new EcommLandingPage(driver);

        // Navigate to application
        driver.get(prop.getProperty("url"));
        ExtentReporter.logInfo(
                "Navigated to application URL: " + prop.getProperty("url")
        );

        try {
            Assert.assertTrue(
                    landingPage.logo().isDisplayed(),
                    "Landing page logo is not displayed"
            );

            ExtentReporter.logPass("Landing page logo is displayed successfully");

        } catch (Throwable e) {

            ExtentReporter.logFail(
                    "Ecomm home page validation failed: " + e.getMessage()
            );

            throw e;
        }
    }

        @When("User searches for {string}")
        public void user_searches_for(String product) throws IOException, InterruptedException {
            EcommLandingPage landingPage = new EcommLandingPage(driver);
            ExtentReporter.createNode("Product Search");
            Thread.sleep(5000);
            landingPage.searchField().sendKeys(product);
            ExtentReporter.logInfo("Entered product name: " + product);
            landingPage.searchButton().click();
            ExtentReporter.logInfo("Clicked on search button");
            ExtentReporter.logPass("Searched for product: " + product);
        }

        @Then("Search results for {string} should be displayed")
        public void user_should_see_the_search_results_for(String product) throws IOException, InterruptedException{

            EcommSearchedProductPage searchedProductPage = new EcommSearchedProductPage(driver);
            ExtentReporter.createNode("Search Results Validation");
            try {
                Assert.assertTrue(
                        searchedProductPage.searchedProductTitle1().getText().contains(product),
                        "Searched product title is not displayed"
                );
                ExtentReporter.logPass("Search results for " + product + " are displayed successfully");
            } catch (Throwable e) {
                ExtentReporter.logFail(
                        "Search results validation failed: " + e.getMessage()
                );
                throw e;
            }
        }
        @And("User selects the first product from search results")
        public void user_selects_the_first_product_from_search_results() throws IOException, InterruptedException {
        base b = new base();
            EcommSearchedProductPage searchedProductPage = new EcommSearchedProductPage(driver);
            ExtentReporter.createNode("Select First Product");
            try {
                ProductName1 = searchedProductPage.searchedProductTitle1().getText();
                searchedProductPage.searchedProductTitle1().click();
                ExtentReporter.logInfo("Clicked on the first product from search results" + ProductName1);
                ExtentReporter.logPass("First product selected successfully");
                b.SwitchToPageByIndex(1);
                ExtentReporter.logInfo("Switched to product details page");
            } catch (Throwable e) {
                ExtentReporter.logFail(
                        "Selecting first product failed: " + e.getMessage()
                );
                throw e;
            }
        }

        @Then ("Product details page should be displayed")
        public void product_details_page_should_be_displayed() throws IOException, InterruptedException {
            base b = new base();
            EcommProductDetlPage productDetailsPage = new EcommProductDetlPage(driver);
            ExtentReporter.createNode("Product Details Page Validation");
            b.WaitForThePagetobeLoaded();
            try {
                Assert.assertTrue(
                        productDetailsPage.productTitle().isDisplayed(),
                        "Product details page is not displayed"
                );
                ExtentReporter.logPass("Product details page is displayed successfully");
            } catch (Throwable e) {
                ExtentReporter.logFail(
                        "Product details page validation failed: " + e.getMessage()
                );
                throw e;
            }
        }
    @And("User adds the product to the shopping cart")
    public void user_adds_the_product_to_the_shopping_cart() throws IOException, InterruptedException {
        EcommProductDetlPage productDetailsPage = new EcommProductDetlPage(driver);
        ExtentReporter.createNode("Add Product to Cart");
        productDetailsPage.addToCartButton().click();
        ExtentReporter.logInfo("Clicked on 'Add to Cart' button");
        try {
            Assert.assertTrue(
                    productDetailsPage.addedToCartConfirmationText().isDisplayed(),
                    "Product was not added to the cart"
            );
            ExtentReporter.logPass("Product added to the shopping cart successfully");
        } catch (Throwable e) {
            ExtentReporter.logFail(
                    "Adding product to cart failed: " + e.getMessage()
            );
            throw e;

        }
    }

    @Then("verify the Product in cart")
    public void verify_the_product_in_cart() throws IOException, InterruptedException {
        EcommProductDetlPage productDetailsPage = new EcommProductDetlPage(driver);
        EcommShoppingCartPage shoppingCartPage = new EcommShoppingCartPage(driver);
        ExtentReporter.createNode("Verify Product in Cart");
        productDetailsPage.goToCartButton().click();
        ExtentReporter.logInfo("Clicked on cart icon to view cart");
        try{
            Assert.assertTrue(
                    shoppingCartPage.cartPageTitle().isDisplayed(),
                    "Cart page is not displayed"
            );
            ExtentReporter.logPass("Navigated to the shopping cart page successfully");
        } catch (Throwable e) {
            ExtentReporter.logFail(
                    "Cart page validation failed: " + e.getMessage()
            );
            throw e;
        }
        Thread.sleep(3000);
        try {
            ProductName2 = shoppingCartPage.cartProductText1().getText();
            Assert.assertTrue(
                    ProductName2.contains(ProductName1),
                    "Product in cart does not match the selected product" + ProductName1 + " and " + ProductName2
            );
            ExtentReporter.logPass("Verified that the product in the cart matches the selected product:  " + ProductName1);
        } catch (Throwable e) {
            ExtentReporter.logFail(
                    "Verification of product in cart failed: " + e.getMessage()
            );
            throw e;
        }
    }
}
