package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepdefinitions.Hooks;

/**
 * WorkspaceSettingPage class represents the workspace settings page of the application.
 */
public class WorkspaceSettingPage extends Hooks {

    /**
     * WebElement representing the workspace settings heading.
     */
    @FindBy(css = "[data-cy=workspace-settings-heading]")
    public WebElement workspaceSettingHeading;

    /**
     * WebElement representing the upload logo field.
     */
    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadLogoField;

    /**
     * WebElement representing the label for other applications.
     */
    @FindBy(css = "div[class='ant-col ant-col-18']")
    public WebElement lblOtherSApps;

    /**
     * WebElement representing the save logo button.
     */
    @FindBy(css = "[data-cy=settings-workspace-logo-save-upload-button]")
    public WebElement saveLogoButton;

    /**
     * WebElement representing the added logo.
     */
    @FindBy(css = "img.orgShortLogo")
    public WebElement logoAdded;

    /**
     * WebElement representing the image cropper.
     */
    @FindBy(tagName = "image-cropper")
    public WebElement imageCropper;

    /**
     * WebElement representing the delete logo button.
     */
    @FindBy(css = "[data-cy=settings-workspace-logo-delete-button]")
    public WebElement btnDeleteLogo;

    /**
     * WebElement representing the confirm delete logo button.
     */
    @FindBy(css = "[data-cy=settings-workspace-logo-confirm-delete-button]")
    public WebElement btnConfirmDeleteLogo;

    /**
     * WebElement representing the choose file button.
     */
    @FindBy(css = "[data-cy=settings-choose-workspace-logo-button]")
    public WebElement chooseFile;

    /**
     * Initializes a new instance of the WorkspaceSettingPage class.
     */
    public WorkspaceSettingPage() {
        PageFactory.initElements(Hooks.getWebDriver(), this);
    }

    /**
     * Validates if landed on the workspace settings page.
     */
    public void validateLandedOnWorkspaceSettingsPage() {
        BasePage.waitForElementVisibility(workspaceSettingHeading, 30);
        workspaceSettingHeading.isDisplayed();
        String currentUrl = Hooks.getWebDriver().getCurrentUrl();
        Assert.assertEquals("https://dev.klaarhq.com/settings/workspace/details", currentUrl);
    }

    /**
     * Uploads a logo and saves it.
     */
    public void uploadLogo() {
        BasePage.scrollToElement(lblOtherSApps);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        uploadLogoField.sendKeys(System.getProperty("user.dir") + "//src//test//resources//logo.jpeg");
        BasePage.scrollToElement(lblOtherSApps);
        BasePage.waitForElementVisibility(saveLogoButton, 60);
        saveLogoButton.click();
        BasePage.waitForElementInVisibility(imageCropper, 50);
    }

    /**
     * Validates if the logo has been added.
     */
    public void validateLogoAdded() {
        BasePage.waitForElementVisibility(logoAdded, 30);
        BasePage.scrollToElement(lblOtherSApps);
        Assert.assertTrue(logoAdded.isDisplayed());
    }

    /**
     * Deletes the logo.
     */
    public void deleteLogo() {
        BasePage.waitForElementVisibility(btnDeleteLogo, 30);
        btnDeleteLogo.click();
        BasePage.waitForElementVisibility(btnConfirmDeleteLogo, 30);
        btnConfirmDeleteLogo.click();
    }

    /**
     * Validates if the logo has been removed.
     */
    public void validateLogoRemoved() {
        BasePage.scrollToElement(lblOtherSApps);
        BasePage.waitForElementVisibility(chooseFile, 20);
    }
}
