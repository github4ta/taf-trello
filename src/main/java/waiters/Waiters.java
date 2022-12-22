package waiters;

import driver.Driver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class Waiters {
    public static final int WAIT_TIMEOUT_SECONDS = 5;

    public static void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(8));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        log.info("page is load");
    }

    public static WebElement waitForElementToBeClickable(WebElement webElement) {
        return new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions
                .elementToBeClickable(webElement));
    }

    public static WebElement waitForVisibilityOfElement(WebElement webElement) {
        return new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions
                .visibilityOf(webElement));
    }
}
