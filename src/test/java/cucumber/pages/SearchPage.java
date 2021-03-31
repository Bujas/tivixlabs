package cucumber.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    private static WebDriver driver;

    @FindBy(id = "country")
    WebElement countryDropDownList;

    @FindBy(id = "city")
    WebElement cityDropDownList;

    @FindBy(id = "model")
    WebElement model;

    @FindBy(id = "pickup")
    WebElement pickUpDate;

    @FindBy(id = "dropoff")
    WebElement dropOffDate;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUpCountry(String country) {
        selectFromDropDown(countryDropDownList, country);
    }

    public void fillUpCity(String city) {
        selectFromDropDown(cityDropDownList, city);
    }

    public void fillUpModel(String model) {
        this.model.sendKeys(model);
    }

    public void fillUpPickUpDate(String pickupDate) {
        this.pickUpDate.sendKeys(pickupDate);
    }

    public void fillUpDropOffDate(String dropOffDate) {
        this.dropOffDate.sendKeys(dropOffDate);
    }

    public void submit() {
        this.dropOffDate.sendKeys(Keys.ENTER);
    }

    private void selectFromDropDown(WebElement element, String country) {
        Select select = new Select(element);
        select.selectByVisibleText(country);
    }
}
