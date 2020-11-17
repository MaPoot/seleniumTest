package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class ExpediaHome extends PageObject {

    //
    @FindBy(xpath = "//a[@aria-controls=\"wizard-flight-pwa\"]")
    private WebElement flightButton;
    @FindBy(xpath = "//button[contains(@aria-label, 'Leaving from')]")
    private WebElement fromInput;
    @FindBy (xpath = "//button[contains(@aria-label, 'Going to')]")
    private WebElement destinationInput;
    @FindBy (xpath = "//span[text()='Done']/parent::button")
    private WebElement doneButton;
    @FindBy (xpath = "(//button[@data-stid=\"open-date-picker\"])[1]")
    private WebElement openDatePicker;
    @FindBy (xpath = "//button[@data-testid='submit-button']")
    private WebElement searchButton;
    private final Map<String, String> otherPaths;

    public ExpediaHome(WebDriver driver) {
        super(driver);
        otherPaths = new HashMap<>();

        otherPaths.put("DatePickerDeparting", "//div[@class='uitk-new-date-picker-month'][1]//button[@data-day='%s']");
        otherPaths.put("datePickerReturn", "//div[@class='uitk-new-date-picker-month'][2]//button[@data-day='%s']");
        otherPaths.put("firstOriginResult", "//li[@data-stid=\"location-field-leg1-origin-result-item\" and @data-index='0']");
        otherPaths.put("firstDestinationResult", "//li[@data-stid=\"location-field-leg1-destination-result-item\" and @data-index='0']");
        otherPaths.put("alertIncomplete", "//h3[contains(text(), 'To continue, please correct')]");
    }

    public void clickFlightButton(){
        flightButton.click();
    }

    public void sendFromImput(String from){
        fromInput.sendKeys(from);
        utils.waitAndClick(otherPaths.get("firstOriginResult"));
    }

    public void openDatePicker(){
        openDatePicker.click();
    }

    public void sendDestinationInput(String destination){
        destinationInput.sendKeys(destination);
        utils.waitAndClick(otherPaths.get("firstDestinationResult"));
    }

    public void sendDepartureDate(String day) {
        utils.waitAndClick(String.format(otherPaths.get("DatePickerDeparting"),day));
    }

    public void sendReturningDate(String day){
        utils.waitAndClick(String.format(otherPaths.get("DatePickerDeparting"),day));
    }

    public void clickDoneButton(){
        doneButton.click();
    }
    public void clickSearchButton(){
        searchButton.click();
    }

    public boolean checkForIncompleteAlert(){
        utils.closeExtraWindows();
        return utils.waitIsVisible(otherPaths.get("alertIncomplete"));
    }
}
