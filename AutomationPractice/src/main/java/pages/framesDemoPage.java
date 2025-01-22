package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class framesDemoPage {
    private final WebDriver driver;
    public framesDemoPage (){
        this.driver = Browser.getDriver();
    }

    public void locateParentFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"frame1\"]")));
        String parentFrameText = driver.findElement(By.xpath("//body[text()='Parent frame']")).getText();
        System.out.println(parentFrameText);

    }
    public void locateChildFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"frame1\"]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@srcdoc=\"<p>Child Iframe</p>\"]")));
        String parentFrameText = driver.findElement(By.xpath("//p")).getText();
        System.out.println(parentFrameText);

    }

}
