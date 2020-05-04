package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ExpediaFlights extends PageObject {
    private String idSortDropdown = "sortDropdown";
    @FindBy(xpath = "//span[@data-test-id='listing-price-dollars']")
    private List<WebElement> prices;

    public ExpediaFlights(WebDriver driver) {
        super(driver);
    }

    public void selectFromDropdown(String selection){
        Select dropDown = new Select(driver.findElement(By.id(idSortDropdown)));
        dropDown.selectByVisibleText(selection);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getPrices(){
        List<Integer> price_list = new ArrayList<>();
        for(WebElement price : prices){
            Integer price_u = Integer.parseInt(price.getText().trim().replace("$","").replace(",", ""));
            price_list.add(price_u);
        }

        return price_list;
    }
}
