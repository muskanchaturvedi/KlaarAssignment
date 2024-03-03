package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinitions.Hooks;

import java.time.Duration;

public class BasePage {

    public static void waitForElementVisibility(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementStaleness(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public static void waitForElementInVisibility(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void scrollToElement(WebElement element) {
        WebDriver driver = Hooks.getWebDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll to the element using JavaScript
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

        // Wait for the scroll to complete (optional)
        try {
            Thread.sleep(500); // You can adjust the sleep duration based on your application's responsiveness
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
