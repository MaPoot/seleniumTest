package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

import java.time.Duration;
import java.util.Set;

public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public void waitAndClick(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean waitIsVisible(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        }catch (Exception e){
            return false;
        }

        return true;
    }

    public void closeExtraWindows(){
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        if(windows.size() > 1){
            windows.remove(mainWindow);
            for(String window : windows){
                driver.switchTo().window(window);
                driver.close();
            }

            driver.switchTo().window(mainWindow);
        }

    }
}
