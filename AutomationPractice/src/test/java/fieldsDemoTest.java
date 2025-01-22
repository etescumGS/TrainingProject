import base.BaseTestSetup;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.fieldsDemoPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class fieldsDemoTest extends BaseTestSetup {


    @Test(suiteName = "Fields1", groups = {"smoke"})
    public void testFormFill(){
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");
        hobbies.add("Music");
        Random random = new Random();
        String randomtext = RandomStringUtils.randomAlphabetic(5);
        fieldsDemoPage fieldsPage = new fieldsDemoPage();
        fieldsPage.firstName("Test"+randomtext);
        fieldsPage.lastName("Auto"+randomtext);
        fieldsPage.emailAddress(randomtext+"@mailinator.com");
        fieldsPage.selectGender("Female");
        fieldsPage.mobileNumber("5214783690");
        fieldsPage.dateOfBirth("6", "1986", 1);
        fieldsPage.selectHobby(hobbies);
        fieldsPage.currentAddress("123 test st");
        fieldsPage.stateField("Haryana");
        fieldsPage.cityField("Karnal");
        fieldsPage.submitButton();
        Assert.assertTrue(fieldsPage.isThankYouPageDisplayed());

    }

    @Test(suiteName = "Fields1", groups = {"regression"})
    public void areCheckBoxesAndRadioButtonsMaintained(){
        List<String> hobbiesSelected = new ArrayList<>();
        hobbiesSelected.add("Sports");
        List<String> hobbiesNotSelected = new ArrayList<>();
        hobbiesNotSelected.add("Reading");
        hobbiesNotSelected.add("Music");
        fieldsDemoPage fieldsPage = new fieldsDemoPage();
        fieldsPage.selectGender("Female");
        fieldsPage.selectHobby(hobbiesSelected);
        fieldsPage.stateField("NCR");
        fieldsPage.cityField("Noida");
        fieldsPage.submitButton();
        Assert.assertTrue(fieldsPage.isGenderRadioButtonSelected("Female"));
        Assert.assertTrue(fieldsPage.areHobbyCheckboxesSelected(hobbiesSelected));
        Assert.assertTrue(fieldsPage.areHobbyCheckboxesNotSelected(hobbiesNotSelected));

    }

}



