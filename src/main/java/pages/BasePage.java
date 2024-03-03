package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinitions.Hooks;

import java.time.Duration;

/**
 * BasePage class contains common utility methods used across different pages.
 */
public class BasePage {

    /**
     * Waits for the visibility of the given WebElement.
     *
     * @param element WebElement to wait for visibility.
     * @param timeout Timeout duration in seconds.
     */
    public static void waitForElementVisibility(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the staleness of the given WebElement.
     *
     * @param element WebElement to wait for staleness.
     * @param timeout Timeout duration in seconds.
     */
    public static void waitForElementStaleness(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    /**
     * Waits for the invisibility of the given WebElement.
     *
     * @param element WebElement to wait for invisibility.
     * @param timeout Timeout duration in seconds.
     */
    public static void waitForElementInVisibility(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Scrolls to the specified WebElement using JavaScript.
     *
     * @param element WebElement to scroll into view.
     */
    public static void scrollToElement(WebElement element) {
        WebDriver driver = Hooks.getWebDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500); // You can adjust the sleep duration based on your application's responsiveness
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
