package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingKartPage {
	WebDriver driver;
	public ShoppingKartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@class='T2CNXf QqLTQ-']")
	WebElement ProductName;
	
	@FindBy(xpath="//input[@class='p6sArZ']")
	WebElement ProductCount;
	
	@FindBy(xpath="//button[@class='LcLcvv' and text() = '+']")
	WebElement IncreaseProductCountButton;
	
	@FindBy(xpath="//span[@class='LAlF6k re6bBo']")
	WebElement ProductPrice;
	
	@FindBy(xpath="//div[@class='_1Y9Lgu']")
	WebElement TotalPrice;
	
	public WebElement ProductName() {
		return ProductName;
	}
	public WebElement ProductCount() {
		return ProductCount;
	}
	public WebElement IncreaseProductCountButton() {
		return IncreaseProductCountButton;
	}
	public WebElement ProductPrice() {
		return ProductPrice;
	}
	public WebElement TotalPrice() {
		return TotalPrice;
	}
}
