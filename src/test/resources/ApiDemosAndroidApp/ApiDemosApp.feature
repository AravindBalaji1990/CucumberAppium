@EndtotEnd
Feature: this is just to check the Api Demo App

#  Background:
#    Given User opens the Android App Api Demos

  Scenario: check the Api Demo App has section Views
    When User scrolls and checks for the option Views
    Then User clicks on the views menu

    @testsanity
  Scenario: Enter the data form a step
    When User scrolls and checks for the option Views
    Then User clicks on the views menu
    And User clicks the section textfields
    Then User enters the data "datatext"

  @testsmoke @testregression
  Scenario: Enter the multiple data form a step
    When User scrolls and checks for the option Views
    Then User clicks on the views menu
    And User clicks the section textfields
    Then User enters the multiple set of data <data>
      | data      |
      | datatext1 |
      | datatext2 |

    @testregression
    Scenario Outline: Check the Api Demo App for the text field
      When User scrolls and checks for the option Views
      Then User clicks on the views menu
      And User clicks the section textfields
      Then User enters different dataset <firstname> and <lastname>

      Examples:
        | firstname | lastname |
        | fname1    | lname1   |
        | fname2    | lname2   |
        | fname3    | lname3   |