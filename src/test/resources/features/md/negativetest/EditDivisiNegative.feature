Feature: Negative Edit Divisi Test Cases

  Background:
    Given User is on the Management Divisi page

  Scenario: Edit division name to empty
    And User searches for divisi with name "Public Relations"
    And User clicks the search button
    When User clicks the three dot button for divisi "Public Relations"
    And User clicks the "Edit" button
    And User edits the divisi name to ""
    And User clicks the "Simpan" button
    Then A validation message should appear for empty divisi name

  Scenario: Edit division name to already existing one
    And User searches for divisi with name "Public Relations"
    And User clicks the search button
    When User clicks the three dot button for divisi "Public Relations"
    And User clicks the "Edit" button
    And User edits the divisi name to "Public Relations"
    And User clicks the "Simpan" button
    Then The success message after editing should display "Berhasil Edit Divisi"
    And An error message should appear indicating the name already exists
