package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LandingPage;
import pages.WorkspaceSettingPage;

public class WorkspaceSettingsStepDefinitions {

    WorkspaceSettingPage workspaceSettingPage = new WorkspaceSettingPage();

    @Then("validate user lands on the workspace setting page")
    public void validateLandedOnTheWorkspaceSettingsPage() {
        workspaceSettingPage.validateLandedOnWorkspaceSettingsPage();
    }

    @And("adds a new workspace logo")
    public void addsANewWorkspaceLogo() {
        workspaceSettingPage.uploadLogo();
    }

    @Then("validate the logo is successfully added")
    public void validateTheLogoIsSuccessfullyAdded() {
        workspaceSettingPage.validateLogoAdded();
    }

    @And("delete the workspace logo")
    public void removeWorkspaceLogo() {
        workspaceSettingPage.deleteLogo();
    }

    @And("validate the logo is successfully removed")
    public void validateTheLogoIsSuccessfullyRemoved() {
        workspaceSettingPage.validateLogoRemoved();
    }
}
