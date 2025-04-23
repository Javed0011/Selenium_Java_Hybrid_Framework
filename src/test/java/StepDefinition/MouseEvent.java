package StepDefinition;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import resources.base;

public class MouseEvent extends base{
	LandingPage landingpage = new LandingPage(driver);
	@When("i move the cursor to Fashion Section and Select Men Topwear")
	public void i_move_the_cursor_to_Fashion_Section_and_Select_Men_Topwear() throws InterruptedException {
		action.moveToElement(landingpage.FashionDropdown()).click().perform();
		wait.until(ExpectedConditions.textToBePresentInElement(landingpage.MensTopwearLink(),landingpage.MensTopwearLink().getText()));
		action.moveToElement(landingpage.MensTopwearLink()).click().perform();
	}
	@Then("I should be Nevigated to Mens Topwear Page")
	public void I_should_be_Nevigated_to_Mens_Topwear_Page() {
		wait.until(ExpectedConditions.titleContains("Topwear For Men"));
		Assert.assertTrue(driver.getTitle().contains("Topwear For Men"));
	}
}
