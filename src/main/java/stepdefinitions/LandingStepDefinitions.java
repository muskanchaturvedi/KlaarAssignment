package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LandingPage;
import pages.LoginPage;

public class LandingStepDefinitions {

    LandingPage landingPage = new LandingPage();

    @And("navigate to settings module")
    public void clickSettings() {
        landingPage.clickOnSettings();

    }
}
