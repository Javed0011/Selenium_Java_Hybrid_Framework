package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
		WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
			
		}
		@FindBy(xpath="//input[@id='input-email']")
		WebElement Emailaddressfield;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement PasswordField;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement logginbutton;
		
		public WebElement Emailaddressfield() {
			return Emailaddressfield;
		}
		public WebElement PasswordField() {
			return PasswordField;
		}
		public WebElement logginbutton() {
			return logginbutton;
		}
		
		
		
		
}
