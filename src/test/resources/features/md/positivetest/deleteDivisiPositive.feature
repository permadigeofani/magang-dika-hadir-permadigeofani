Feature: Delete Divisi - Positive Case


  Background:
    Given User is on the Management Divisi page
  Scenario: Successfully delete a Divisi
    And User searches for divisi with name "Research & Development"
    And User clicks the search button
    When User clicks the three dot button for the divisi "Research & Development"
    And User selects the delete option from the menu
    Then A confirmation popup for deleting divisi should appear with message containing "Research & Development"
    And User confirms deletion by clicking Ya
    Then Divisi with name "Research & Development" should be deleted successfully
