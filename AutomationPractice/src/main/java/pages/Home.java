package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home {
    private static final String URL = "https://magento.softwaretestingboard.com/";
    private final WebDriver driver;
    private final By signInButton = By.linkText("Sign In");
    private final By createAccountLink = By.linkText("Create an Account");

    public Home() {
        this.driver = Browser.getDriver();
    }

    public void closeAds(){
        List<WebElement> closeIcons = driver.findElements(By.xpath("//div[@role='button']"));
        for (WebElement icon : closeIcons)
        {
            icon.click();
        }
    }

    /* public static Home homePage(WebDriver driver) {
        return new Home(driver);
    }


    public void goTo(){
        driver.get(URL);
    }
*/
    public WebElement signIn(){
        return driver.findElement(signInButton);

    }

    public WebElement createAccountLink(){
        return driver.findElement(createAccountLink);
    }
}
