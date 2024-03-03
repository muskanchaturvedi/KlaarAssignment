package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class LinkedInStepDefinitions {
    @Given("user logs in with klaar website")
    public void userLogsInWithKlaarWebsite() {
        Hooks.launchUrl("https://dev.klaarhq.com/");
    }


//    @When("I enter my username and password")
//    public void iEnterMyUsernameAndPassword() {
//        // Replace the following with your actual LinkedIn credentials
//        String username = "aa";
//        String password = "password@1";
//
//        WebElement usernameInput = se.findElement(By.id("username"));
//        WebElement passwordInput = BaseTest..findElement(By.id("password"));
//
//        usernameInput.sendKeys(username);
//        passwordInput.sendKeys(password);
//    }
//
//    @When("I click the login button")
//    public void iClickTheLoginButton() {
//        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Sign in']")); // Adjust the XPath accordingly
//        loginButton.click();
//    }
//
//    @Then("I should be logged in to my LinkedIn account")
//    public void iShouldBeLoggedInToMyLinkedInAccount() {
//        // Example: Verify if the user is on the dashboard or any other element that indicates successful login
//        WebElement dashboardElement = driver.findElement(By.xpath("//div[@class='dashboard']")); // Adjust the XPath accordingl
//
//        // Close the browser after the test
//        driver.quit();
//    }
}
