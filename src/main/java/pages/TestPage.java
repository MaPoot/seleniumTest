package pages;

import driveManager.DriverManager;
import org.junit.gen5.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class TestPage extends PageObject {

    @FindBy(id = "name")
    private WebElement inputUser;
    @FindBy(id = "alertbtn")
    private WebElement buttonAlert;
    @FindBy(id = "confirmbtn")
    private WebElement buttonConfirm;
    private Alert simpleAlert;

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

    public void clickButtonAlert(){
        buttonAlert.click();
    }

    public void switchToAlert(){
        simpleAlert = driver.switchTo().alert();
    }

    public void acceptAlert(){
        simpleAlert.accept();
    }

    public void clickConfirmButton(){
        buttonConfirm.click();
    }

    public void cancelAlert(){
        simpleAlert.dismiss();
    }

    public void validateMessage(){
        String expected = String.format("Hello %s, share this practice page and share your knowledge", message);
        String actual = simpleAlert.getText();
        try{
            // Expected, actual, message
            Assertions.assertEquals(expected, actual, "Assertion Failed");
            System.out.println(String.format("%s = %s", expected, actual));
        }catch (AssertionError e){
            e.printStackTrace();
        }
    }
}
