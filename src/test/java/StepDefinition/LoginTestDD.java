package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import resources.base;

public class LoginTestDD extends base{
	WebDriver driver;
	@BeforeMethod
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider = "getLoginData")
	public void login(String email, String pass, String expectedstatus) throws IOException, InterruptedException {
	LandingPage landingpage = new LandingPage(driver);
	landingpage.myAccountdropdown().click();
	landingpage.loginbutton().click();
	LoginPage loginpage = new LoginPage(driver);
	loginpage.Emailaddressfield().sendKeys(email);
	loginpage.PasswordField().sendKeys(pass);
	loginpage.logginbutton().click();
	Thread.sleep(10000);
	MyAccountPage myaccountpage = new MyAccountPage(driver);
	String actualResult = null;
	try {
	if(myaccountpage.EditYourAccountInformationLink().isDisplayed()) {
	actualResult = "Success";
	}
	}
	catch(Exception e) {
		actualResult = "Failure";
	}
	Assert.assertEquals(actualResult,expectedstatus);
	}
	@AfterMethod
	public void closure() {
		driver.quit();
		
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"javed.nadaf@gmail.com","123456789","Success"},{"dummy@gamil.com","123456789","Failure"}};
		return data;
	}
}
