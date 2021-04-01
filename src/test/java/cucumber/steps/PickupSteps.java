package cucumber.steps;

import cucumber.pages.DetailsPage;
import cucumber.pages.components.RentComponent;
import cucumber.pages.components.RentElement;
import cucumber.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class PickupSteps {
    WebDriver driver;
    public SearchPage searchPage;
    public RentComponent rentComponent;
    public DetailsPage detailsPage;
    ArrayList<RentElement> carToRentList;

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
        rentComponent = new RentComponent(driver);
    }

    @And("User can rent a car on (.*)$")
    public void userCanRentACarOnPosition(String position) {
        carToRentList = rentComponent.getCarToRentList();
        carToRentList.get(Integer.parseInt(position)).clickRentButton();
        detailsPage = new DetailsPage(driver);
    }

    @Then("Check a data renting cars form {int} with {word} and {word}")
    public void checkADataRentingCarsFormPositionWithCountryAndCity(int position, String country, String city) {
        System.out.println(position + country + city);
        RentElement carToRent = carToRentList.get(position);
        assertTrue(detailsPage.models.contains(carToRent.models));
        assertTrue(detailsPage.company.contains(carToRent.company));
        assertTrue(detailsPage.licensePlate.contains(carToRent.licensePlate));
        assertTrue(detailsPage.pricePerDay.contains(carToRent.pricePerDay));
        assertTrue(detailsPage.location.contains(country));
        assertTrue(detailsPage.location.contains(city));
    }

    @And("List is not empty")
    public void listIsNotEmpty() {
        rentComponent.listNotShouldBeEmpty();
    }

    @Then("On page should be all elements")
    public void onPageShouldBeAllElements() {
        searchPage.checkAllElementsAreDisplayed();
    }

    @Then("User close browser")
    public void userCloseBrowser() {
        driver.close();
    }
}
