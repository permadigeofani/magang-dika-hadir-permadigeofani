Feature: Add Divisi - Positive Case

  Background:
    Given User is on the Management Divisi page
  Scenario: Successfully add a new Divisi
    When User clicks on the Tambahkan button to add divisi
    And User inputs "Research and Development" into the Nama Divisi field
    And User clicks on the Tambah button
    And The success message after add new divisi should display "Berhasil Menambahkan Divisi"
    Then The divisi "Research and Development" should be added successfully
