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
    @FindBy (xpath = "(//button[@type='submit' and @class = 'btn-primary btn-action gcw-submit'])[1]")
    private WebElement searchButton;

    public ExpediaHome(WebDriver driver) {
        super(driver);
    }

    public void clickFlightButton(){
        flightButton.click();
    }

    public void sendFromImput(String from){
        fromInput.sendKeys(from);
        fromInput.sendKeys(Keys.TAB);
    }

    public void sendDestinationInput(String destination){
        destinationInput.sendKeys(destination);
        destinationInput.sendKeys(Keys.TAB);
    }

    public void sendDepartureDate(String date) {
        departureDate.sendKeys(date);
        destinationInput.sendKeys(Keys.TAB);
    }

    public void sendReturningDate(String date){
        returningDate.sendKeys(date);
    }

    public void clickSearchButton(){
        searchButton.click();
    }
}
