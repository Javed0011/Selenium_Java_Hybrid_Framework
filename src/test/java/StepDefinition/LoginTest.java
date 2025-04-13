package StepDefinition;

import java.io.IOException;

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
	@BeforeMethod
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void login() throws IOException, InterruptedException {
	LandingPage landingpage = new LandingPage(driver);
	landingpage.myAccountdropdown().click();
	landingpage.loginbutton().click();
	LoginPage loginpage = new LoginPage(driver);
	loginpage.Emailaddressfield().sendKeys(prop.getProperty("email"));
	loginpage.PasswordField().sendKeys(prop.getProperty("password"));
	loginpage.logginbutton().click();
	Thread.sleep(10000);
	MyAccountPage myaccountpage = new MyAccountPage(driver);
	Assert.assertTrue(myaccountpage.EditYourAccountInformationLink().isDisplayed());
	}
	@AfterMethod
	public void closure() {
		driver.quit();
	}
}
