package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.Hooks;

/**
 * LoginPage class represents the login page of the application.
 */
public class LoginPage extends Hooks {

    /**
     * WebElement representing the login with Klaar button.
     */
    @FindBy(css = "[data-cy=login-with-klaar-button]")
    public WebElement loginWithKlaar;

    /**
     * WebElement representing the email input field.
     */
    @FindBy(id = "email-field")
    public WebElement inputEmail;

    /**
     * WebElement representing the password input field.
     */
    @FindBy(id = "password-field")
    public WebElement inputPassword;

    /**
     * WebElement representing the login button.
     */
    @FindBy(id = "login-btn")
    public WebElement logInButton;

    /**
     * WebElement representing the remember me checkbox.
     */
    @FindBy(css = "input[type='checkbox']")
    public WebElement rememberMe;

    /**
     * WebElement representing the error message for invalid username.
     */
    @FindBy(xpath = "//div[contains(text(), 'Please enter valid email or phone number')]")
    public WebElement errorMessageUserName;

    /**
     * WebElement representing the error message for missing password.
     */
    @FindBy(xpath = "//div[text()='Please enter your password here']")
    public WebElement errorMessagePassword;

    /**
     * WebElement representing the reset password button.
     */
    @FindBy(css = "[data-cy=login-forgot-password-link]")
    public WebElement resetPasswordButton;

    /**
     * WebElement representing the error message for reset password attempt.
     */
    @FindBy(css = "div[class*='helpMotion ng-star-inserted']")
    public WebElement errorMessageResetPassword;

    /**
     * WebElement representing the attempts left message.
     */
    @FindBy(css = "[data-cy=login-page-alert-error-message]")
    public WebElement attemptsLeftMessage;

    /**
     * WebElement representing the reset password email button.
     */
    @FindBy(css = "[data-cy=reset-password-email-text-field]")
    public WebElement resetEmailButton;

    /**
     * WebElement representing the send reset password email button.
     */
    @FindBy(css = "[data-cy=send-password-reset-email-button]")
    public WebElement sendResetEmailButton;

    /**
     * WebElement representing the phone number field.
     */
    @FindBy(css = "[data-cy=reset-password-email-text-field")
    public WebElement phoneNumberField;

    /**
     * WebElement representing the back to login button in the reset password flow.
     */
    @FindBy(css = "div[class='backBtn']")
    public WebElement backToLogInButton;

    /**
     * WebElement representing the back to login button in other options.
     */
    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ng-star-inserted']")
    public WebElement backToLoginOtherOptionsButton;

    /**
     * Initializes a new instance of the LoginPage class.
     */
    public LoginPage() {
        PageFactory.initElements(Hooks.getWebDriver(), this);
    }

    /**
     * Performs a login action with provided username and password.
     *
     * @param userName Username to be entered.
     * @param password Password to be entered.
     */
    public void clickLoginWithKlaar(String userName, String password) {
        loginWithKlaar.click();
        inputEmail.sendKeys(userName);
        inputPassword.sendKeys(password);
        logInButton.click();
        rememberMe.isDisplayed();
    }

    /**
     * Retrieves the error message for invalid username.
     *
     * @return Error message for invalid username.
     */
    public String getUserNameErrorMessage() {
        BasePage.waitForElementVisibility(errorMessageUserName, 50);
        return errorMessageUserName.getText();
    }

    /**
     * Retrieves the error message for missing password.
     *
     * @return Error message for missing password.
     */
    public String getPasswordErrorMessage() {
        BasePage.waitForElementVisibility(errorMessagePassword, 50);
        return errorMessagePassword.getText();
    }

    /**
     * Retrieves the attempts left message.
     *
     * @return Attempts left message.
     */
    public String getAttemptsLeftMessage() {
        BasePage.waitForElementVisibility(attemptsLeftMessage, 20);
        return attemptsLeftMessage.getText();
    }

    /**
     * Retrieves the error message for reset password attempt.
     *
     * @return Error message for reset password attempt.
     */
    public String getResetPasswordMessage() {
        BasePage.waitForElementVisibility(errorMessageResetPassword, 20);
        return errorMessageResetPassword.getText();
    }

    /**
     * Initiates the reset password flow without entering an email.
     */
    public void resetPasswordWithoutEnteringEmail() {
        loginWithKlaar.click();
        resetPasswordButton.click();
        sendResetEmailButton.click();
    }

    /**
     * Enters a phone number in the reset password flow.
     */
    public void enterPhoneNumber() {
        loginWithKlaar.click();
        resetPasswordButton.click();
        BasePage.waitForElementVisibility(phoneNumberField, 50);
        phoneNumberField.sendKeys("2345");
    }

    /**
     * Clicks the reset password link.
     */
    public void clickResetPasswordLink() {
        loginWithKlaar.click();
        resetPasswordButton.click();
        phoneNumberField.sendKeys("sffffffrr");
    }

    /**
     * Clicks the back button in the reset password flow.
     */
    public void backButton() {
        backToLogInButton.click();
    }

    /**
     * Clicks the back to login button in other options.
     */
    public void backToOtherOptionsButton() {
        BasePage.waitForElementVisibility(backToLoginOtherOptionsButton, 40);
        backToLoginOtherOptionsButton.click();
    }
}
