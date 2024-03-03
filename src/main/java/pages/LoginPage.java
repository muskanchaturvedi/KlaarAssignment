package pages;

import jdk.jpackage.internal.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.Hooks;

public class LoginPage extends Hooks {

    @FindBy(css = "[data-cy=login-with-klaar-button]")
    public WebElement loginWithKlaar;

    @FindBy(id = "email-field")
    public WebElement inputEmail;

    @FindBy(id = "password-field")
    public WebElement inputPassword;

    @FindBy(id = "login-btn")
    public WebElement logInButton;
    public LoginPage() {
        PageFactory.initElements(Hooks.getWebDriver(), this);
    }

    public void clickLoginWithKlaar(String userName, String password) {
        loginWithKlaar.click();
        inputEmail.sendKeys(userName);
        inputPassword.sendKeys(password);
        logInButton.click();
    }
}
