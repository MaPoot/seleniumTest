package steps;

import driveManager.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.TestPage;

public class DemoInputField {
    private WebDriver driver;
    private TestPage page;


    public void showMessage() throws Exception {
        driver = DriverManager.launchBrowser();
        page = new TestPage(driver);

        try{
            driver.get("https://learn.letskodeit.com/p/practice");

            page.sentMessage("Manuel Poot");
            page.clickButtonAlert();
            Thread.sleep(5000);
            page.switchToAlert();
            page.validateMessage();
            page.acceptAlert();
            System.out.println("Event send it ok");
            page.clickConfirmButton();
            page.switchToAlert();
            page.acceptAlert();
            System.out.println("Accept Alert");
            page.clickConfirmButton();
            page.switchToAlert();
            page.cancelAlert();
            System.out.println("Cancel Alert");

            

            DriverManager.close();
            System.out.println("Closing");
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public void close(){
        DriverManager.close();
    }
}
