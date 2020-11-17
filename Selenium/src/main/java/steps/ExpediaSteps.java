package steps;

import driveManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ExpediaFlights;
import pages.ExpediaHome;

import java.util.List;

public class ExpediaSteps {

    public List<Integer> runExpediaPage(){
        WebDriver driver = DriverManager.launchBrowser();
        driver.get("https://www.expedia.com/");

        ExpediaHome expediaHome = new ExpediaHome(driver);
        expediaHome.waitForLoad();

        boolean alert = true;

        while(alert){
            expediaHome.clickFlightButton();
            expediaHome.sendFromImput("Mex");
            expediaHome.sendDestinationInput("Cun");
            expediaHome.openDatePicker();
            expediaHome.sendReturningDate("10");
            expediaHome.sendDepartureDate("18");
            expediaHome.clickDoneButton();
            expediaHome.clickSearchButton();
            if(alert = expediaHome.checkForIncompleteAlert()){
                System.out.println("Retying");
            }else{
                System.out.println("Continue to next page...");
            }
        }

        ExpediaFlights expediaFlights = new ExpediaFlights(driver);
        expediaFlights.waitForLoad();
        expediaFlights.selectFromDropdown("Price (Highest)");
        List<Integer> prices = expediaFlights.getPrices();

        System.out.println(prices);

        return prices;
    }
}
