package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommProductDetlPage {
    WebDriver driver;
    public EcommProductDetlPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@id='productTitle']")
    private WebElement productTitle;

    @FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
    private WebElement addToCartButton;

    @FindBy(xpath="//h1[contains(text(),'Added to cart')]")
    private WebElement addedToCartConfirmationText;

    @FindBy(xpath = "//a[@class='a-button-text' and @data-csa-c-type='button']")
    private WebElement goToCartButton;

    public WebElement addToCartButton() { return addToCartButton;  }
    public WebElement productTitle() { return productTitle;  }
    public WebElement addedToCartConfirmationText() { return addedToCartConfirmationText;  }
    public WebElement goToCartButton() { return goToCartButton;  }
}
