package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    protected static final int IMPLICIT_WAIT = 8;

    public static WebDriver getInstance() {
        if (driver == null) {
            ChromeOptions opt = new ChromeOptions();
            //opt.addArguments("−−lang=en-US");
            opt.addArguments("--lang=en-US");
            //opt.addArguments("--accept-lang=en_US");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(opt);
            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT)); // это здесь надо?
        }
        return driver;
    }

    public static void navigateMainPage() {
        String BASE_URL = "https://trello.com/home";
        getInstance().navigate().to(BASE_URL);
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
