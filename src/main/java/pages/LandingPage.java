package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.Hooks;

/**
 * LandingPage class represents the landing page of the application.
 */
public class LandingPage extends Hooks {

    /**
     * WebElement representing the settings option button.
     */
    @FindBy(css = "button[data-cy=settings-nav-menu-button]")
    public WebElement settingsOption;

    /**
     * Initializes a new instance of the LandingPage class.
     */
    public LandingPage() {
        PageFactory.initElements(Hooks.getWebDriver(), this);
    }

    /**
     * Clicks on the settings option after waiting for its visibility.
     */
    public void clickOnSettings() {
        BasePage.waitForElementVisibility(settingsOption, 30);
        settingsOption.click();
    }
}
