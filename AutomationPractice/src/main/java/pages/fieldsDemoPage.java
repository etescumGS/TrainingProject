package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class fieldsDemoPage {

    private final WebDriver driver;

    public fieldsDemoPage (){
        this.driver = Browser.getDriver();
    }

    //Student Registration form
    public void firstName(String value){

        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(value);
    }

    public void lastName(String value){

        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(value);
    }
    public void emailAddress(String value){
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys(value);
    }

    public void selectGender(String genderValue){
        String labelLocator = "//div[@class='col-md-9 col-sm-12']//label[text()='"+genderValue+"']";
        String inputLocator = labelLocator + "/preceding-sibling::input";
        WebElement genderRadio = driver.findElement(By.xpath(labelLocator));
        WebElement genderRadioInput = driver.findElement(By.xpath(inputLocator));
        if (!genderRadioInput.isSelected()){
            genderRadio.click();
            }
    }

    public void mobileNumber(String value){
        driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys(value);
    }

    public void dateOfBirth(String month, String year, Integer weekDay){
        driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("react-datepicker")));
        new Select(driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"))).selectByValue(month);
        new Select(driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"))).selectByValue(year);
        String locator = "//div[@class='react-datepicker__month-container']//div[text()=1]";

        if (weekDay>1){
            locator = locator+"following::div[text()="+weekDay+"]";
        }
        WebElement dayElement = driver.findElement(By.xpath(locator));
        dayElement.click();

    }
    public void selectHobby(List<String> hobbyList){
        for (String hobby:hobbyList) {
            String labelLocator = "//div[@id='hobbiesWrapper']//label[text()='"+hobby+"']";
            String inputLocator = labelLocator + "/preceding-sibling::input";
            WebElement hobbyCheckBox = driver.findElement(By.xpath(labelLocator));
            WebElement hobbyCheckBoxInput = driver.findElement(By.xpath(inputLocator));
            if (!hobbyCheckBoxInput.isSelected()){
                hobbyCheckBox.click();
            }
        }

    }
    public void currentAddress(String value){
        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys(value);
    }

    public void stateField(String value ){
        driver.findElement(By.xpath("//*[@id=\"react-select-3-input\"]")).sendKeys(value);
        driver.findElement(By.xpath("//*[@id=\"react-select-3-input\"]")).sendKeys(Keys.ENTER);
    }
    public void cityField(String value){
        driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]")).sendKeys(value);
        driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]")).sendKeys(Keys.TAB);

    }
    public void submitButton(){
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
    }

    public boolean isThankYouPageDisplayed(){
        try{
            WebElement window = new WebDriverWait(driver, Duration.ofSeconds(6)).until(visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isGenderRadioButtonSelected(String genderValue){
        String labelLocator = "//div[@class='col-md-9 col-sm-12']//label[text()='"+genderValue+"']";
        String inputLocator = labelLocator + "/preceding-sibling::input";
        WebElement genderRadio = driver.findElement(By.xpath(labelLocator));
        WebElement genderRadioInput = driver.findElement(By.xpath(inputLocator));
        return genderRadioInput.isSelected();
        }

    public boolean areHobbyCheckboxesSelected(List<String> hobbyList) {
        boolean selectedFlag = true;
        for (String hobby : hobbyList) {
            String labelLocator = "//div[@id='hobbiesWrapper']//label[text()='" + hobby + "']";
            String inputLocator = labelLocator + "/preceding-sibling::input";
            WebElement hobbyCheckBox = driver.findElement(By.xpath(labelLocator));
            WebElement hobbyCheckBoxInput = driver.findElement(By.xpath(inputLocator));
            if(!hobbyCheckBoxInput.isSelected()){
                selectedFlag = false;
                break;
            }

        }
        return selectedFlag;
    }
    public boolean areHobbyCheckboxesNotSelected(List<String> hobbyList) {
        boolean selectedFlag = true;
        for (String hobby : hobbyList) {
            String labelLocator = "//div[@id='hobbiesWrapper']//label[text()='" + hobby + "']";
            String inputLocator = labelLocator + "/preceding-sibling::input";
            WebElement hobbyCheckBox = driver.findElement(By.xpath(labelLocator));
            WebElement hobbyCheckBoxInput = driver.findElement(By.xpath(inputLocator));
            if(hobbyCheckBoxInput.isSelected()){
                selectedFlag = false;
                break;
            }

        }
        return selectedFlag;
    }

}
