package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommLandingPage {
    WebDriver driver;
    public EcommLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="twotabsearchtextbox")
    private WebElement searchField;
    @FindBy(id="nav-search-submit-text")
    private WebElement searchButton;
    @FindBy(id="nav-logo-sprites")
    private WebElement logo;

    public WebElement logo() { return logo;  }
    public WebElement searchField() { return searchField;    }
    public WebElement searchButton() { return searchButton;    }
}
