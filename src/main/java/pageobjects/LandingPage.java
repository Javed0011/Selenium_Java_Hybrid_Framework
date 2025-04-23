package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
		WebDriver driver;
		public LandingPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
			
		}
		@FindBy(xpath="//a[@title='My Account']")
		private WebElement myAccountdropdown;
		
		@FindBy(xpath="//a[text()='Login']")
		private WebElement loginbutton;
		
		@FindBy(xpath="//input[@class='Pke_EE']")
		private WebElement SearchField;
		
		@FindBy(xpath="//button[@class='_2iLD__']")
		private WebElement SearchButton;
		
		@FindBy(xpath="//span[@class='BUOuZu']")
		private WebElement SearchResultText;
		
		@FindBy(xpath="//div[@class='KzDlHZ']")
		private List<WebElement> displayedProductslist;
		
		@FindBy(xpath="//span[text()='Fashion']")
		private WebElement FashionDropdown;
		
		@FindBy(xpath="//a[text()=\"Men's Top Wear\"]")
		private WebElement MensTopwearLink;
		
		public WebElement myAccountdropdown() {
			return myAccountdropdown;
		}
		public WebElement loginbutton() {
			return loginbutton;
		}
		
		public WebElement SearchField() {
			return SearchField;
		}
		
		public WebElement SearchButton() {
			return SearchButton;
		}
		public WebElement SearchResultText() {
			return SearchResultText;
		}
		public List<WebElement> displayedProductslist(){
			return displayedProductslist;
		}
		public WebElement FashionDropdown() {
			return FashionDropdown;
		}
		public WebElement MensTopwearLink() {
			return MensTopwearLink;
		}
		
}
