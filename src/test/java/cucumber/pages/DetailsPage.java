package cucumber.pages;

import cucumber.pages.components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage {

    private WebDriver driver;
    HeaderComponent headerComponent;
    public String models;
    public String company;
    public String location;
    public String pricePerDay;
    public String licensePlate;
    public String pickupDate;
    public String dropoffDate;
    public WebElement button;


    public DetailsPage(WebDriver driver) {
        this.driver = driver;
        headerComponent = new HeaderComponent(driver);
        this.models = driver.findElement(By.cssSelector("div[class=card-header]")).getText();
        this.company = driver.findElement(By.cssSelector("div[class=card-body] h5")).getText();
        this.pricePerDay = driver.findElements(By.cssSelector("p[class=card-text]")).get(0).getText();
        this.location = driver.findElements(By.cssSelector("p[class=card-text]")).get(1).getText();
        this.licensePlate = driver.findElements(By.cssSelector("p[class=card-text]")).get(2).getText();
        this.pickupDate = driver.findElements(By.cssSelector("h6")).get(0).getText();
        this.dropoffDate = driver.findElements(By.cssSelector("h6")).get(1).getText();
    }


}
