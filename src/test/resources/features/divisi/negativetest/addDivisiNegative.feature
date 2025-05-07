Feature: Negative Add Divisi Test Cases

  Background:
    Given User is on the Management Divisi page

  Scenario: Add new divisi with empty divisi name
    When User clicks on the Tambahkan button to add divisi
    And User inputs "   " into the Nama Divisi field
    And User clicks on the Tambah button
    Then A validation message should appear for empty divisi name
    And The divisi "   " should not be added

  Scenario: Add a new division with the same division name
    And The divisi "Application Processing" already exists in the system
    When User clicks on the Tambahkan button to add divisi
    And User inputs "Application Processing" into the Nama Divisi field
    And User clicks on the Tambah button
    Then An error message should appear indicating the divisi "Application Processing" already exists
    And The divisi "Application Processing" should not be added


  Scenario: Add new division with special characters in division name
    When User clicks on the Tambahkan button to add divisi
    And User inputs "@@@>###" into the Nama Divisi field
    And User clicks on the Tambah button
    Then The success message after add new divisi should display "Berhasil Menambahkan Divisi"



  Scenario: User inputs with numbers and letter in Nama Divisi
    When User clicks on the Tambahkan button to add divisi
    And User inputs "=-07{[RrQMil%^5?$$<,$/" into the Nama Divisi field
    And User clicks on the Tambah button
    Then The success message after add new divisi should display "Berhasil Menambahkan Divisi"

