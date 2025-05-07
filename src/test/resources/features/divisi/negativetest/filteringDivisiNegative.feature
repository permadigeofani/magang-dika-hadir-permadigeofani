Feature: Negative Filtering Divisi Test Cases

  Background:
    Given User is on the Management Divisi page

  Scenario: searches for divisi with invalid characters
    When User searches for divisi with character name "!@#$%"
    And User clicks the search button
    Then No divisi should be found

  Scenario: selects invalid number of rows per page
    When User selects "-5" rows per page
    Then System should ignore or show validation message
