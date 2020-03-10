package steps;

import driveManager.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.TestPage;

public class DemoInputField {
    private WebDriver driver;
    private TestPage page;


    public void showMessage(){
        driver = DriverManager.launchBrowser();
        page = new TestPage(driver);

        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        page.sentMessage("Manuel Poot");
        page.clickButtonShow();

        page.validateMessage();
        System.out.println("Event send it ok");
    }

    public void close(){
        DriverManager.close();
    }
}
