package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepdefinitions.Hooks;

public class WorkspaceSettingPage extends Hooks {

    @FindBy(css = "[data-cy=workspace-settings-heading]")
    public WebElement workspaceSettingHeading;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadLogoField;

    @FindBy(css = "div[class='ant-col ant-col-18']")
    public WebElement lblOtherSApps;

    @FindBy(css = "[data-cy=settings-workspace-logo-save-upload-button]")
    public WebElement btnSaveLogo;

    @FindBy(css = "img.orgShortLogo")
    public WebElement logoAdded;

    @FindBy(tagName = "image-cropper")
    public WebElement imageCropper;
    @FindBy(css = "[data-cy=settings-workspace-logo-delete-button]")
    public WebElement btnDeleteLogo;

    @FindBy(css = "[data-cy=settings-workspace-logo-confirm-delete-button]")
    public WebElement btnConfirmDeleteLogo;

    @FindBy(css = "[data-cy=settings-choose-workspace-logo-button]")
    public WebElement chooseFile;

    public WorkspaceSettingPage() {
        PageFactory.initElements(Hooks.getWebDriver(), this);
    }

    public void validateLandedOnWorkspaceSettingsPage() {
        BasePage.waitForElementVisibility(workspaceSettingHeading, 30);
        workspaceSettingHeading.isDisplayed();
        String currentUrl = Hooks.getWebDriver().getCurrentUrl();
        Assert.assertEquals("https://dev.klaarhq.com/settings/workspace/details", currentUrl);
    }

    public void uploadLogo() {
        BasePage.scrollToElement(lblOtherSApps);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        uploadLogoField.sendKeys(System.getProperty("user.dir") + "//src//test//resources//logo.jpeg");
        BasePage.waitForElementVisibility(btnSaveLogo, 60);
        BasePage.scrollToElement(lblOtherSApps);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        btnSaveLogo.click();
        BasePage.waitForElementInVisibility(imageCropper, 40);


//        BasePage.waitForElementVisibility(uploadLogoField, 30);

//        // Provide the absolute file path for the image
//        String absolutePath = System.getProperty("user.dir") + "\\src\\test\\resources\\logo.jpeg";
//        // Input the file path into the upload field
//        uploadLogoField.sendKeys(absolutePath);
//        BasePage.waitForElementInVisibility(uploadLogoField,30);

    }
    public void validateLogoAdded(){
        BasePage.waitForElementVisibility(logoAdded, 30);
        BasePage.scrollToElement(lblOtherSApps);
        Assert.assertTrue(logoAdded.isDisplayed());
    }

    public void deleteLogo(){
        BasePage.waitForElementVisibility(btnDeleteLogo, 30);
        btnDeleteLogo.click();
        BasePage.waitForElementVisibility(btnConfirmDeleteLogo, 30);
        btnConfirmDeleteLogo.click();
    }

    public void validateLogoRemoved(){
        BasePage.scrollToElement(lblOtherSApps);
        BasePage.waitForElementVisibility(chooseFile, 20);
    }

}

