package StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import resources.base;

public class LoginTest extends base {
	
	WebDriver driver;
	Logger log;
	@BeforeMethod
	public void setup() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("browser got Launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to Application URL");
	}
	@Test
	public void login() throws IOException, InterruptedException {
		
	
	LandingPage landingpage = new LandingPage(driver);
	landingpage.myAccountdropdown().click();
	log.debug("CLicked on My Account Drop-down");
	landingpage.loginbutton().click();
	log.debug("Clicked on Login Button");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.Emailaddressfield().sendKeys(prop.getProperty("email"));
	log.debug("Entered Email");
	loginpage.PasswordField().sendKeys(prop.getProperty("password"));
	log.debug("Entered Password");
	loginpage.logginbutton().click();
	log.debug("clicked on Login Button");
	Thread.sleep(10000);
	MyAccountPage myaccountpage = new MyAccountPage(driver);
	Assert.assertTrue(myaccountpage.EditYourAccountInformationLink().isDisplayed());
	log.info("Successfully Logged-in");
	}
	@AfterMethod
	public void closure() {
		driver.quit();
		log.debug("Browser Closed");
	}
}
