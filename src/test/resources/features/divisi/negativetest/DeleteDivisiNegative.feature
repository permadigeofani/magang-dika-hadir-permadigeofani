Feature: Negative Delete Divisi Test Cases

  Background:
    Given User is on the Management Divisi page

  Scenario: Cancels delete a divisi
    And User searches for divisi with name "Public Relations"
    And User clicks the search button
    When User clicks the three dot button for the divisi "Public Relations"
    And User selects the delete option from the menu
    Then A confirmation popup for deleting divisi should appear with message containing "Public Relations"
    And User cancels deletion by clicking Tidak
    Then Divisi "Public Relations" should still be listed
