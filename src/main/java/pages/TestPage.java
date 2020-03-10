package pages;

import driveManager.DriverManager;
import org.junit.gen5.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class TestPage extends PageObject {

    @FindBy(id = "user-message")
    private WebElement inputUser;
    @FindBy(xpath = "//button[contains(text(), 'Show Message')]")
    WebElement buttonShow;

    private HashMap<String, By> elements;

    String message;

    public TestPage(WebDriver driver) {
        super(driver);
        elements = new HashMap<String, By>();
        elements.put("Display", By.xpath("//span[@id='display']"));
    }

    public void sentMessage(String message){
        this.message = message;
        inputUser.sendKeys(message);
    }

    public void clickButtonShow(){
        buttonShow.click();
    }

    public void validateMessage(){
        WebElement display = driver.findElement(elements.get("Display"));
        String text = display.getText();
        try{
            // Expected, actual, message
            Assertions.assertEquals(message, text, "Assertion Failed");
        }catch (AssertionError e){
            DriverManager.close();
            e.printStackTrace();
            System.out.println("Closing");
        }
    }
}
