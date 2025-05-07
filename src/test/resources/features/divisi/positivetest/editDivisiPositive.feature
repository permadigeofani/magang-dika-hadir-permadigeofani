Feature: Edit Divisi - Positive Case

  Background:
    Given User is on the Management Divisi page
  Scenario: Successfully edit an existing Divisi
    And User searches for divisi with name "Public Relations"
    And User clicks the search button
    When User clicks the three dot button for divisi "Public Relations"
    And User clicks the "Edit" button
    And User edits the divisi name to "PR"
    And User clicks the "Simpan" button
    Then The success message after editing should display "Berhasil Edit Divisi"

