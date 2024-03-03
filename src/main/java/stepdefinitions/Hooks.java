package stepdefinitions;

import Runner.TestRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends TestRunner {
    static WebDriver driver;

    @Before
    public static void initializeDriver() {
        driver = new ChromeDriver();
//        // Maximize the browser window
        driver.manage().window().maximize();
    }

    public static WebDriver getWebDriver() {
        if (driver == null){
            initializeDriver();
        }
        return driver;
    }

    public static void launchUrl(String url) {
        getWebDriver().get(url);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
