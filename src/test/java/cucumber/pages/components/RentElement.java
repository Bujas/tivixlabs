package cucumber.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentElement {
    public WebElement tableSelector;
    public int id;
    public String company;
    public String models;
    public String licensePlate;
    public String price;
    public String pricePerDay;
    public WebElement button;

    public RentElement(int position, WebDriver driver) {
        tableSelector = driver.findElements(By.xpath("//tbody/tr")).get(position);
        this.id = Integer.parseInt(tableSelector.findElement(By.xpath("th")).getText());
        this.company = tableSelector.findElements(By.xpath("td")).get(0).getText();
        this.models = tableSelector.findElements(By.xpath("td")).get(1).getText();
        this.licensePlate = tableSelector.findElements(By.xpath("td")).get(2).getText();
        this.price = tableSelector.findElements(By.xpath("td")).get(3).getText();
        this.pricePerDay = tableSelector.findElements(By.xpath("td")).get(4).getText();
        this.button = tableSelector.findElement(By.xpath("td/a"));
    }

    public void clickRentButton() {
        this.button.click();
    }


    //For debugging
    @Override
    public String toString() {
        return ", id=" + id +
                ", company='" + company + '\'' +
                ", models='" + models + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", price='" + price + '\'' +
                ", pricePerDay='" + pricePerDay + '\'';
    }
}
