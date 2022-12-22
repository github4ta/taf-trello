package steps;

import model.User;
import page.LoginPage;

public class LoginStep extends LoginPage {
    LoginPage loginPage = new LoginPage();

    public void logIn(User user) {
        loginPage.clickLoginButton()
                .inputEmail(user.getEmail())
                .confirmEmail()
                .inputPassword(user.getPassword())
                .confirmPassword();
    }
    public String getActualUserDate(){
        return getUserDate();
    }

    public String loginErrorMessagePassword() {
        return loginPage.getErrorMessagePassword();
    }

    public String loginIncorrectPasswordMessage() {
        return loginPage.getMessageIncorrectPassword();
    }
}
