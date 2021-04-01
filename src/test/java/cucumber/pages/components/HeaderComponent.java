package cucumber.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.*;


public class HeaderComponent {
    WebDriver driver;

    @FindBy(css = "li a")
    WebElement search;

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchTextIsDisplayed() {
        assertNotEquals("", this.search.getText());
    }
}
