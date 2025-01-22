package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.Browser;
import pages.Home;

import static factory.DriverFactory.newChromeDriver;
import static factory.DriverFactory.newFirefoxDriver;

public class BaseTestSetup {

    //protected WebDriver driver;
    //String BrowserName = "Chrome";
    //private static final String URL = "https://magento.softwaretestingboard.com/";
    @Parameters({"BrowserName", "URL"})
    @BeforeMethod(alwaysRun = true)
    public void Start(String BrowserName, String URL) {
        Browser.setDriver(BrowserName);
        Browser.goToURL(URL);
        Home home = new Home();
        home.closeAds();
    }

    @AfterMethod(alwaysRun = true)
    public void End(){
        Browser.close();
    }



}
