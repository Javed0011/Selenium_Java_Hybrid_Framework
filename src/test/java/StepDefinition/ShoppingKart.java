package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.ProductPage;
import pageobjects.ShoppingKartPage;
import resources.base;

public class ShoppingKart extends base {
	static WebElement firstproduct;
	static String firstproductname = "";
	LandingPage landingpage = new LandingPage(driver);
	ProductPage productpage = new ProductPage(driver);
	ShoppingKartPage shoppingkartpage = new ShoppingKartPage(driver);
	@Then("Open the {string}")
	public void Open_the_Product(String Product) throws InterruptedException {
		firstproduct = landingpage.displayedProductslist().get(0);
		if(firstproduct.getText().toLowerCase().contains(Product.toLowerCase())) {
			firstproductname = firstproduct.getText();
			firstproduct.click();
		}else {
			Assert.assertTrue(firstproduct.getText().toLowerCase().contains(Product.toLowerCase()));
		}
		String Title = firstproduct.getText()+" Online at Best Price On Flipkart.com";
		SwitchToPageByTitle(Title);
		
	}
	@When("Add the product to Kart and verify the Product")
	public void Add_the_product_to_Kart_and_verify_the_Product() throws InterruptedException {
		try {
		productpage.AddtoKartButton().click();
		}
		catch(Exception e) {
			productpage.AddToKartButton2().click();
		}
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("Shopping Cart | Flipkart.com"));
		Assert.assertTrue(shoppingkartpage.ProductName().getText().equals(firstproductname));
	}
	
}
