package driveManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class DriverManager {
    public static WebDriver driver;

    /**
    Launch browser
     */
    public static WebDriver launchBrowser(){
        ClassLoader classLoader = DriverManager.class.getClassLoader();
        File file = new File(classLoader.getResource("WebDrivers/chromedriver.exe").getFile());

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
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
