import base.BaseTestSetup;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home;
import pages.LogIn;
import pages.registerPage;

import java.util.Random;

public class registerPageTest extends BaseTestSetup {

    @Test(suiteName="Suite1", groups={"smoke"})
    public void testRegisterFromLogin(){
        Home home = new Home();
        home.signIn().click();
        LogIn logIn = new LogIn();
        logIn.createAccountLink();
    }

    @Test(suiteName="Suite1",groups={"smoke.register"})
    public void testRegisterPage(){
        Random random = new Random();
        String randomtext = RandomStringUtils.randomAlphabetic(5);
        Home home = new Home();
        home.createAccountLink().click();
        registerPage regpage = new registerPage();
        regpage.firstName("Noctis"+randomtext);
        regpage.lastName("Lucis"+randomtext);
        regpage.emailAddress(randomtext+"@mailinator.com");
        regpage.password("test1234X");
        regpage.confirmPassword("test1234X");
        regpage.createButton();
    }

    @Test(suiteName="Suite1",groups={"regression"})
    public void testRegisterPageAllRequiredFields(){
        Home home = new Home();
        home.createAccountLink().click();
        registerPage regpage = new registerPage();
        regpage.createButton();
        Assert.assertTrue(regpage.areAllRequiredFieldsDisplayed());

    }

    @Test
    public void testValidEmail(){
        Home home = new Home();
        home.createAccountLink().click();
        registerPage regpage = new registerPage();
        regpage.emailAddress("wer");
        regpage.isEmailValidMessageDisplayed();
        regpage.createButton();
        Assert.assertTrue(regpage.isEmailValidMessageDisplayed());
    }
}
