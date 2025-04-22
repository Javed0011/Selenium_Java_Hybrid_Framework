package StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import resources.base;

public class Login extends base{
	
	Logger log;
	
	@Given("Open any Browser")
    public void open_any_browser() throws IOException {
    	log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("browser got Launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to Application URL");
    }

    @And("Navigate to Login page")
    public void navigate_to_login_page() {
    	LandingPage landingpage = new LandingPage(driver);
    	landingpage.myAccountdropdown().click();
    	log.debug("CLicked on My Account Drop-down");
    	landingpage.loginbutton().click();
    	log.debug("Clicked on Login Button");
    }

    @When("User enters username as {string} and password as {string} into the fields")
    public void user_enters_credentials(String username, String password) {
    	
    	LoginPage loginpage = new LoginPage(driver);
    	loginpage.Emailaddressfield().sendKeys(username);
    	log.debug("Entered Email");
    	loginpage.PasswordField().sendKeys(password);
    	log.debug("Entered Password");
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
    	LoginPage loginpage = new LoginPage(driver);
    	loginpage.logginbutton().click();
    	log.debug("clicked on Login Button");
    }

    @Then("Verify user is able to successfully login")
    public void verify_user_is_able_to_successfully_login() {
    	MyAccountPage myaccountpage = new MyAccountPage(driver);
    	Assert.assertTrue(myaccountpage.EditYourAccountInformationLink().isDisplayed());
    	log.info("Successfully Logged-in");
    }
    @After
    public void closure() {
    	driver.quit();
    }
}
