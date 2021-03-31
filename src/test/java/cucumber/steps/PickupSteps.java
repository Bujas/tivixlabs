package cucumber.steps;

import cucumber.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PickupSteps {
    WebDriver driver;
    public SearchPage searchPage;

    @Given("User is on {string} side")
    public void userIsOnSide(String URLString) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URLString);
        searchPage = new SearchPage(driver);
    }

    @When("User fill up country with (.*)$")
    public void userFillUpCountryWithCountry(String country) {
        searchPage.fillUpCountry(country);
    }

    @And("User fill up city with (.*)$")
    public void userFillUpCityWithCity(String city) {
        searchPage.fillUpCity(city);
    }

    @And("User fill up model with (.*)$")
    public void userFillUpModelWithModel(String model) {
        searchPage.fillUpModel(model);
    }

    @And("User fill up pick up date with (.*)$")
    public void userFillUpPickUpDateWithPickUpDate(String pickUpDate) {
        searchPage.fillUpPickUpDate(pickUpDate);
    }

    @And("User fill up drop off date with (.*)$")
    public void userFillUpDropOffDateWithDropOffDate(String dropOffDate) {
        searchPage.fillUpDropOffDate(dropOffDate);
    }

    @And("User click submit button")
    public void userClickSubmitButton() {
        searchPage.submit();
    }

    @And("Close browser")
    public void closeBrowser() {
        driver.close();
    }



}
