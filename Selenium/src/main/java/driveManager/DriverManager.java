package driveManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class DriverManager {
    public static WebDriver driver;

    /**
    Launch browser
     */
    public static WebDriver launchBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abelardo.canche\\Documents\\GitHub\\seleniumTest\\Selenium\\src\\main\\resources\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void close(){
        String cmd;
        try{
            if(driver!=null){
                driver.quit();
            }

        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
    }
}
