Feature: Delete Divisi - Positive Case


  Background:
    Given User is on the Management Divisi page
  Scenario: Successfully delete a Divisi
    And User searches for divisi with name "Aplication"
    And User clicks the search button
    When User clicks the three dot button for the divisi "Aplication"
    And User selects the delete option from the menu
    Then A confirmation popup for deleting divisi should appear with message containing "Aplication"
    And User confirms deletion by clicking Ya
    Then Divisi with name "Aplication" should be deleted successfully
