package page;

import lombok.extern.log4j.Log4j2;
import model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiters;

@Log4j2
public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@data-active='false']//a[contains(text(), 'Log in')]")
    private WebElement loginBtn;
    @FindBy(id = "user")
    private WebElement fieldEmail;
    @FindBy(id = "login")
    private WebElement continueBtn;
    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement fieldPasswd;
    @FindBy(id = "login-submit")
    private WebElement confirmPasswdBtn;
    @FindBy(id = "password-error")
    private WebElement msgErrorPasswd;
    @FindBy(id = "login-error")
    private WebElement msgIncorrectPasswd;
    @FindBy(xpath = "//div[@title='Anastasiya (oanastasia058)']")
    private WebElement userName;

    //    public final String ERROR_MESSAGE_PASSWORD = "Enter your password"; // использую сразу в testLoginEmptyField
    public final String MESSAGE_INCORRECT_PASSWORD = "Incorrect email address and / or password. If you recently migrated your Trello account to an Atlassian account, you will need to use your Atlassian account password. Alternatively, you can get help logging in.";

    public LoginPage clickLoginButton() {
        loginBtn.click();
        log.info("Click button LogIn");
        return this;
    }

    public LoginPage inputEmail(String data) {
        fieldEmail.sendKeys(data);
        log.info("Input Email in the field");
        return this;
    }

    public LoginPage confirmEmail() {
        continueBtn.click();
        log.info("Click button confirm email");
        return this;
    }

    public LoginPage inputPassword(String data) {
        Waiters.waitForVisibilityOfElement(fieldPasswd);
        fieldPasswd.sendKeys(data);
        log.info("Input password in the field");
        return this;
    }

    public LoginPage confirmPassword() {
        Waiters.waitForElementToBeClickable(confirmPasswdBtn);
        confirmPasswdBtn.click();
        log.info("Click button confirm password");
        return this;
    }

    public String getErrorMessagePassword() {
        Waiters.waitForVisibilityOfElement(msgErrorPasswd);
        String messageError = msgErrorPasswd.getText();
        log.info(String.format("Message of error password - %s",messageError));
        return messageError;
    }

    public String getMessageIncorrectPassword() {
        Waiters.waitForVisibilityOfElement(msgIncorrectPasswd);
        String messageIncorrectPassword = msgIncorrectPasswd.getText();
        log.info(String.format("Message of incorrect password - %s",messageIncorrectPassword));
        return messageIncorrectPassword;
    }
    public String getUserDate(){
        Waiters.waitForVisibilityOfElement(userName);
        return userName.getAttribute("title");
    }

}

