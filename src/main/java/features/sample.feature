Feature: Selenium Assignment


  Background:
    Given Given the user launches the Klaar website
    When logs in with username "deepa.nayak@gamma.klaar.team" and password "Klaar2021"
    And navigate to settings module

  Scenario: Workspace Settings Scenario
    Then validate user lands on the workspace setting page
    And adds a new workspace logo
    Then validate the logo is successfully added
    And delete the workspace logo
    Then validate the logo is successfully removed


#  Scenario: Add and Manage Custom Fields for Users
#    Given navigate to the user list page
#    And navigate to the user fields page
#    And add a new custom field of type date
#    Then validate that the added custom field is reflected in the user company details page
#    And add a future date in the custom field for the user and save
#    Then validate that the future date is saved successfully
#    And add a new custom field of type List with three list options
#    Then validate that the added custom field is reflected in the user company details page
#    And in the user details page, select a list item for the custom field and save
#    Then validate that the selected list item is saved successfully
#    And test the custom field switch on and off toggle
#    Then verify changes are reflected respectively in the user company details page
#    And delete the custom field
#    Then verify that the custom field is no longer visible in the custom field table
#    And verify that the custom field is no longer visible in the user company details page
#




