package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDefinition {
    private LoginPage loginPage = new LoginPage();
    @When("logs in with username {string} and password {string}")
    public void logsInWithUsernameAndPassword(String userName, String password) {
        loginPage.clickLoginWithKlaar(userName,password);

    }

    @Given("Given the user launches the Klaar website")
    public void givenTheUserLaunchesTheKlaarWebsite() {
        Hooks.launchUrl("https://dev.klaarhq.com/");
    }
}
