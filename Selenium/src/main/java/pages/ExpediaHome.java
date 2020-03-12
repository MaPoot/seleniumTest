package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ExpediaHome extends PageObject {

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightButton;
    @FindBy(id = "flight-origin-hp-flight")
    private WebElement fromInput;
    @FindBy (id = "flight-destination-hp-flight")
    private WebElement destinationInput;
    @FindBy (id = "flight-departing-hp-flight")
    private WebElement departureDate;
    @FindBy (id = "flight-returning-hp-flight")
    private WebElement returningDate;
    @FindBy (xpath = "//span[contains(text(), 'Search')]")
    private WebElement searchButton;

    public ExpediaHome(WebDriver driver) {
        super(driver);
    }

    public void clickFlightButton(){
        flightButton.click();
    }

    public void sendFromImput(String from){
        fromInput.sendKeys(from);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fromInput.sendKeys(Keys.TAB);
    }

    public void sendDestinationInput(String destination){
        destinationInput.sendKeys(destination);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        destinationInput.sendKeys(Keys.TAB);
    }

    public void sendDepartureDate(String date) {
        departureDate.sendKeys(date);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        departureDate.sendKeys(Keys.TAB);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendReturningDate(String date){
        returningDate.sendKeys(date);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        returningDate.sendKeys(Keys.TAB);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickSearchButton(){
        returningDate.sendKeys(Keys.ENTER);
    }
}
