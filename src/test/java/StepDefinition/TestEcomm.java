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
//    EcommLandingPage landingPage = new EcommLandingPage(driver);
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
}
