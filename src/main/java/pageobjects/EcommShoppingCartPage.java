package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommShoppingCartPage {
    WebDriver driver;
    public EcommShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "sc-active-items-header")
    private WebElement cartPageTitle;

    @FindBy(xpath="//span[@class='a-truncate-cut']")
    private WebElement cartProductText1;

    public WebElement cartPageTitle() { return cartPageTitle;  }
    public WebElement cartProductText1() { return cartProductText1;  }
}
