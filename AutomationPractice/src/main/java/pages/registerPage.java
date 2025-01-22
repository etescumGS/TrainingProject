package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class registerPage {

    private final WebDriver driver;

    public registerPage(){
        this.driver = Browser.getDriver();
    }

    //Personal Information section
    public void firstName(String value){
        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(value);
    }

    public void lastName(String value){
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(value);
    }

    //Sign In Information section
    public void emailAddress(String value){
        driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(value);
    }
    public void password(String value){
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(value);
    }
    public void confirmPassword(String value){
        driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys(value);
    }

    public void createButton(){
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();

    }

    //Error Handling section
    public boolean isFirstNameRequiredMessageDisplayed(){
        try{
            WebElement message = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.id("firstname-error")));
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public boolean isLastNameRequiredMessageDisplayed(){
        try{
            WebElement message = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.id("lastname-error")));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isEmailRequiredMessageDisplayed(){
        try{
            WebElement message = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.xpath("//div[@id='email_address-error' and text()='This is a required field.']")));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isPasswordRequiredMessageDisplayed(){
        try{
            WebElement message = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.id("password-error")));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isConfirmPasswordRequiredMessageDisplayed(){
        try{
            WebElement message = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.id("password-confirmation-error")));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isEmailValidMessageDisplayed(){
        try{
            WebElement message = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.xpath("//div[@id='email_address-error' and text()='Please enter a valid email address (Ex: johndoe@domain.com).']")));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isPasswordValidMessageDisplayed(){
        try{
            WebElement message = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.id("password-error")));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isConfirmPasswordValidMessageDisplayed(){
        try{
            WebElement message = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.id("password-confirmation-error")));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean areAllRequiredFieldsDisplayed (){
       return isFirstNameRequiredMessageDisplayed() && isLastNameRequiredMessageDisplayed() && isEmailRequiredMessageDisplayed() && isPasswordRequiredMessageDisplayed() && isConfirmPasswordRequiredMessageDisplayed();

    }

}
