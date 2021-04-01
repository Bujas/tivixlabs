package cucumber.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RentComponent {
    WebDriver driver;
    public WebElement rentTable;
    public String id;
    public String company;
    public String models;
    public String licensePlate;
    public String price;
    public String pricePerDay;

    public RentComponent(WebDriver driver) {
        this.driver = driver;
        this.rentTable = driver.findElement(By.xpath("//thead/tr"));
        this.id = rentTable.findElements(By.xpath("//td")).get(0).getText();
        this.company = rentTable.findElements(By.xpath("//td")).get(1).getText();
        this.models = rentTable.findElements(By.xpath("//td")).get(2).getText();
        this.licensePlate = rentTable.findElements(By.xpath("//td")).get(3).getText();
        this.price = rentTable.findElements(By.xpath("//td")).get(4).getText();
        this.pricePerDay = rentTable.findElements(By.xpath("//td")).get(5).getText();
    }

    public ArrayList<RentElement> getCarToRentList() {
        ArrayList<RentElement> carToRentList = new ArrayList<>();
        int sizeOfCarToRentList = driver.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 0; i < sizeOfCarToRentList; i++) {
            carToRentList.add(new RentElement(i, this.driver));
        }
        return carToRentList;
    }

    public void listNotShouldBeEmpty() {
        ArrayList<RentElement> carToRentList = new ArrayList<>();
        int sizeOfCarToRentList = driver.findElements(By.xpath("//tbody/tr")).size();
        assertTrue(sizeOfCarToRentList > 0);
    }


}
