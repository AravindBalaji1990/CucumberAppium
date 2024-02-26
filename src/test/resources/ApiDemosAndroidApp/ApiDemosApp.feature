Feature: this is just to check the Api Demo App

  Background:
    Given User opens the Android App Api Demos

  Scenario: check the Api Demo App has section Views
    When User scrolls and checks for the option Views
    Then User clicks on the views menu

    Scenario Outline: Check the Api Demo App for the text field
      When User scrolls and checks for the option Views
      Then User clicks on the views menu
      And User clicks the section textfields
      Then User enters the data <firstname> and <lastname>

      Examples:
        | firstname | lastname |
        | fname1    | lname1   |
        | fname2    | lname2   |
        | fname3    | lname3   |