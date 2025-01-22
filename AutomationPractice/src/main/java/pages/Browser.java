package pages;

import org.openqa.selenium.WebDriver;

import static factory.DriverFactory.newChromeDriver;
import static factory.DriverFactory.newFirefoxDriver;

public class Browser {

    static WebDriver driver;


    public static WebDriver getDriver(){
        return driver;
    }
    public static void goToURL(String URL){
        driver.get(URL);
    }

    public static void setDriver(String BrowserName){
        if (BrowserName.equals("Chrome")) {
            driver = newChromeDriver();
        } else {
            driver = newFirefoxDriver();
        }
    }

    public static void close(){
        driver.quit();
    }

}
