Feature: Selenium Assignment


  Background:
    Given the user launches the Klaar website
    When logs in with username "deepa.nayak@gamma.klaar.team" and password "Klaar2021"
    And navigate to settings module

  Scenario: Workspace Settings Scenario
    Then validate user lands on the workspace setting page
    And adds a new workspace logo
    Then validate the logo is successfully added
    And delete the workspace logo
    Then validate the logo is successfully removed







