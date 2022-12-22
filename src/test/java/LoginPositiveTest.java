import lombok.extern.log4j.Log4j2;
import model.User;
import org.testng.Assert;
import steps.LoginStep;
import org.testng.annotations.Test;

@Log4j2
public class LoginPositiveTest extends BaseTest {
    private LoginStep loginStep = new LoginStep();

    @Test
    void testLogin() {
        String expectedDataUser = "Anastasiya (oanastasia058)";

        log.info("Test login");
        loginStep.logIn(new User());
        Assert.assertEquals(loginStep.getActualUserDate(),expectedDataUser,"User's data does not match the data entered during login");
    }
}
