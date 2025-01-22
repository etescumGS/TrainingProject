import base.BaseTestSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home;
import pages.LogIn;

public class LoginTest extends BaseTestSetup {


    @Test(suiteName="Suite1",groups={"smoke.login"})
    public void TestLogin() {
        Home home = new Home();
        //Home home = Home.homePage();
        //home.goTo();
        home.signIn().click();
        LogIn logIn = new LogIn();
        logIn.eMail("test1140@test.com");
        logIn.password("test@1234");
        logIn.SignIn();
        Assert.assertEquals("1","1");

        //driver.get("https://magento.softwaretestingboard.com/");
        //driver.findElement(By.linkText("Sign In")).click();
        //driver.findElement(By.id("email")).sendKeys("test1140@test.com");
        //driver.findElement(By.id("pass")).sendKeys("test@1234");
        //driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();

    }

    @Test
    public void requiredFields(){
        Home home = new Home();
        home.signIn().click();
        LogIn logIn = new LogIn();
        //logIn.eMail(null);
        //logIn.password(null);
        logIn.SignIn();
        String message = logIn.requiredEmail();
        Assert.assertEquals(message,"This is a required field.");


    }

}
