package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.Hooks;

public class LandingPage extends Hooks {

    @FindBy(css = "button[data-cy=settings-nav-menu-button]")
    public WebElement settingsOption;

    public LandingPage() {
        PageFactory.initElements(Hooks.getWebDriver(), this);
    }

    public void clickOnSettings() {
        BasePage.waitForElementVisibility(settingsOption, 30);
        settingsOption.click();
    }
}
