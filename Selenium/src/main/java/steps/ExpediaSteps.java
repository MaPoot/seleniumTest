package steps;

import driveManager.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.ExpediaFlights;
import pages.ExpediaHome;

import java.util.List;

public class ExpediaSteps {

    private WebDriver driver;

    public void runExpediaPage(){
        driver = DriverManager.launchBrowser();
        driver.get("https://www.expedia.com/");

        ExpediaHome expediaHome = new ExpediaHome(driver);

        expediaHome.clickFlightButton();
        expediaHome.sendDepartureDate("04/14/2020");
        expediaHome.sendReturningDate("04/17/2020");
        expediaHome.sendFromImput("Mex");
        expediaHome.sendDestinationInput("Cun");
        expediaHome.clickSearchButton();

        ExpediaFlights expediaFlights = new ExpediaFlights(driver);
        expediaFlights.selectFromDropdown("Price (Highest)");
        List<Integer> prices = expediaFlights.getPrices();

        System.out.println(prices);
    }
}
