package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommSearchedProductPage {
    WebDriver driver;
    public EcommSearchedProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//h2[@aria-label])[1]")
    private WebElement searchedProductTitle1;


    public WebElement searchedProductTitle1() { return searchedProductTitle1;  }
}


