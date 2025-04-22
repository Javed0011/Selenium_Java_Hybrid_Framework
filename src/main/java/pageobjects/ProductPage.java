package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//button[@class='QqFHMw vslbG+ In9uk2']")
	private WebElement AddtoKartButton;

	@FindBy(xpath="//button[@class='QqFHMw vslbG+ In9uk2 JTo6b7']")
	WebElement AddToKartButton2;
	
	public WebElement AddtoKartButton() {
		return AddtoKartButton;
	}
	public WebElement AddToKartButton2() {
		return AddToKartButton2;
	}
}
