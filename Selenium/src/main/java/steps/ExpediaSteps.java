package steps;

import driveManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ExpediaFlights;
import pages.ExpediaHome;

import java.util.List;

public class ExpediaSteps {

    private WebDriver driver;

    public List<Integer> runExpediaPage(){
        driver = DriverManager.launchBrowser();
        driver.get("https://www.expedia.com/");

        ExpediaHome expediaHome = new ExpediaHome(driver);

        expediaHome.waitForLoad();
        expediaHome.clickFlightButton();
        expediaHome.sendFromImput("Mex");
        expediaHome.sendDestinationInput("Cun");
        expediaHome.sendReturningDate("05/17/2020");
        expediaHome.sendDepartureDate("05/14/2020");
        expediaHome.clickSearchButton();

        ExpediaFlights expediaFlights = new ExpediaFlights(driver);
        expediaFlights.waitForLoad();
        expediaFlights.selectFromDropdown("Price (Highest)");
        List<Integer> prices = expediaFlights.getPrices();

        System.out.println(prices);

        return prices;
    }
}
