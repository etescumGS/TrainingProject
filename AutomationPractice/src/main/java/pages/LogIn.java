package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LogIn {
    //private static final String URL = "https://magento.softwaretestingboard.com/customer/account/login/";
    private final WebDriver driver;

    public LogIn()
    {
        this.driver = Browser.getDriver();
    }

    /*public static LogIn logInPage(WebDriver driver) {
        return new LogIn(driver);
    }

    public void goTo(){
        driver.get(URL);
    }
    */

    public void eMail(String value){
        driver.findElement(By.id("email")).sendKeys(value);
    }

    public void password(String value){
        driver.findElement(By.id("pass")).sendKeys(value);
    }
    public void SignIn(){
        driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();

    }

    public void createAccountLink(){
        driver.findElement(By.xpath("//div/a/span[text()='Create an Account']")).click();

    }

    /*public String getErrorMessage(){
       var result = new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(By.id("email-error")));
       return result.getText();*/


    public String requiredEmail(){
        WebElement message = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.id("email-error")));
        return message.getText();
    }

 }

