Feature: Negative Add Divisi Test Cases

  Background:
    Given User is on the Management Divisi page

  Scenario: Add new divisi with empty divisi name
    When User clicks on the Tambahkan button to add divisi
    And User leaves divisi name empty
    And User clicks on the Tambah button
    Then A validation message should appear for empty divisi name

  Scenario: Add a new division with the same division name
    And The divisi "Accounting" already exists in the system
    When User clicks on the Tambahkan button to add divisi
    And User inputs "Accounting" into the Nama Divisi field
    And User clicks on the Tambah button
    Then The success message after add new divisi should display "Berhasil Menambahkan Divisi"
    Then The divisi "Accounting" should not be added
    And An error message should appear indicating the divisi "Accounting" already exists


  Scenario: Add new division with special characters in division name
    When User clicks on the Tambahkan button to add divisi
    And User inputs "@@@###" into the Nama Divisi field
    And User clicks on the Tambah button
    Then The success message after add new divisi should display "Berhasil Menambahkan Divisi"
    And The divisi "@@@###" should not be added
    And An error or validation message should appear for invalid characters


  Scenario: User inputs only numbers in Nama Divisi
    When User clicks on the Tambahkan button to add divisi
    And User inputs "123456" into the Nama Divisi field
    And User clicks on the Tambah button
    Then The success message after add new divisi should display "Berhasil Menambahkan Divisi"
    And The divisi "123456" should not be added
    And An error or validation message should appear for invalid name format
