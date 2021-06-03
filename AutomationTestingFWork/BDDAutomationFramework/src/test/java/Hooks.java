import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonFunctions;

public class Hooks  {

    CommonFunctions commonFunctions = new CommonFunctions();

    @Before
    public void beforeTest() {
        commonFunctions.openBrowser();
    }

    @After
    public void afterTest() {
        commonFunctions.closeBrowser();
    }
}


