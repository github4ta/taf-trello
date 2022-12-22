import lombok.extern.log4j.Log4j2;
import model.User;
import steps.LoginStep;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.RandomData;

@Log4j2
public class LoginNegativeTest extends BaseTest {
    private LoginStep loginStep;
    private User user = new User();


    @Test
    public void testLoginEmptyField() {
        log.info("Test login with password empty field");
        String expectedErrorMessagePassword = "Enter your password";
        loginStep = new LoginStep();
        user.setPassword("");

        loginStep.logIn(user);

        Assert.assertEquals(loginStep.loginErrorMessagePassword(), expectedErrorMessagePassword,"Password field is not empty");

    }

    @DataProvider(name = "testLogInWithIncorrectPassword")
    public Object[][] dataProvInputIncorrectData() {
        return new Object[][]{
                {" "},
                {RandomData.generateRandomStringLetters()},
                {RandomData.generateRandomStringLettersAndNumbers()},
                {RandomData.generateNumbers()}
        };
    }

    @Test(dataProvider = "testLogInWithIncorrectPassword")
    public void testLogInWithIncorrectPassword(String password) {
        log.info("Test login with incorrect password");
        String expectedIncorrectPasswordMessage = "Incorrect email address and / or password. If you recently migrated your Trello account to an Atlassian account, you will need to use your Atlassian account password. Alternatively, you can get help logging in.";
        loginStep = new LoginStep();
        user.setPassword(password);

        loginStep.logIn(user);

        Assert.assertEquals(loginStep.loginIncorrectPasswordMessage(), expectedIncorrectPasswordMessage,"Password mustn't contains @");

    }
}
