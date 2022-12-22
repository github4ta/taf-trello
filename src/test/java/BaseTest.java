import driver.Driver;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    public void openPage(){
        Driver.navigateMainPage();
    }

    @AfterMethod
    public void closeWebDriver(){
        Driver.closeDriver();
    }
}
