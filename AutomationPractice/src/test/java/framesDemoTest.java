import base.BaseTestSetup;
import org.testng.annotations.Test;
import pages.framesDemoPage;

public class framesDemoTest extends BaseTestSetup {

    @Test(suiteName = "Frames1", groups = {"smoke"})
    public void switchToParentFrame(){
        framesDemoPage framePage = new framesDemoPage();
        framePage.locateParentFrame();
    }
    @Test(suiteName = "Frames1", groups = {"smoke"})
    public void switchToChildFrame(){
        framesDemoPage framePage = new framesDemoPage();
        framePage.locateChildFrame();

    }
}
