package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginStepDefinition {
    private LoginPage loginPage = new LoginPage();
    @When("logs in with username {string} and password {string}")
    public void logsInWithUsernameAndPassword(String userName, String password) {
        loginPage.clickLoginWithKlaar(userName,password);

    }

    @Given("the user launches the Klaar website")
    public void theUserLaunchesTheKlaarWebsite() {
        Hooks.launchUrl("https://dev.klaarhq.com/");
    }

    @When("the user enters an incorrect email {string} and password {string} and clicks on login")
    public void theUserEntersAnIncorrectEmailAndPasswordAndClicksOnLogin(String email, String password) {
        loginPage.clickLoginWithKlaar(email, password);
    }

    @When("the user enters a valid email {string} but an incorrect password {string} and clicks on login")
    public void theUserEntersAValidEmailButAnIncorrectPasswordAndClicksOnLogin(String email, String password) {
        loginPage.clickLoginWithKlaar(email, password);
    }

    @When("the user clicks on login button without entering username and password")
    public void theUserClicksOnLoginButtonWithoutEnteringUsernameAndPassword() {
        loginPage.clickLoginWithKlaar("", "");
    }

    @When("the user enters an invalid email {string} format and clicks on login")
    public void theUserEntersAnInvalidEmailFormatAndClicksOnLogin(String invalidEmail) {
        loginPage.clickLoginWithKlaar(invalidEmail, "somePassword");
    }

    @And("verify error message about minimum attempts left should be displayed")
    public void verifyErrorMessageAboutMinimumAttemptsLeftShouldBeDisplayed() {
        String expectedAttemptsLeftMessage = "Sorry! It seems like your user details are not added in Klaar. Please contact your HR.";
        String actualAttemptsLeftMessage = loginPage.getAttemptsLeftMessage();
        assertEquals(expectedAttemptsLeftMessage, actualAttemptsLeftMessage);
    }

    @When("the user sets a password {string} that does not meet the requirements and clicks on login")
    public void theUserSetsAPasswordThatDoesNotMeetTheRequirementsAndClicksOnLogin(String invalidPassword) {
        loginPage.clickLoginWithKlaar("validEmail@example.com", invalidPassword);
    }

    @When("the user clicks on reset email button without entering email")
    public void theUserClicksOnResetEmailButtonWithoutEnteringEmail() {
        loginPage.resetPasswordWithoutEnteringEmail();
    }

    @Then("verify error message about the required email should be displayed")
    public void verifyErrorMessageAboutTheRequiredEmailShouldBeDisplayed() {
        String expectedErrorMessage = "Please enter your email or Phone number here"; // Update this with your expected error message
        String actualErrorMessage = loginPage.getResetPasswordMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @And("the user clicks on the back to login button")
    public void theUserClicksOnTheBackToLoginButton() {
       loginPage.backButton();
    }

    @When("the user enters a phone number that does not meet the requirements")
    public void theUserEntersAPhoneNumberThatDoesNotMeetTheRequirements() {
        loginPage.enterPhoneNumber();
    }


    @When("the user clicks on the reset password link and enters an email that does not meet the requirements")
    public void theUserClicksOnTheResetPasswordLinkAndEntersAnEmailThatDoesNotMeetTheRequirements() {
        loginPage.clickResetPasswordLink();
    }

    @Then("verify username error message should be displayed")
    public void verifyUsernameErrorMessageShouldBeDisplayed() {
        String expectedErrorMessage = "Please enter valid email or phone number";
        String actualErrorMessage = loginPage.getUserNameErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @And("verify password error message should be displayed")
    public void verifyPasswordErrorMessageShouldBeDisplayed() {
        String expectedErrorMessage = "Please enter your password here";
        String actualErrorMessage = loginPage.getPasswordErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @And("the user clicks on the back to other options login button")
    public void theUserClicksOnTheBackToOtherOptionsLoginButton() {
        loginPage.backToOtherOptionsButton();
    }
}
