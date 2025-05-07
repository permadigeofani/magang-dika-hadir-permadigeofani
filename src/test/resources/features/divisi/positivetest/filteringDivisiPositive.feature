Feature: Filtering Divisi - Positive Case

  Background:
    Given User is on the Management Divisi page

  Scenario: Successfully search for an existing divisi
    When User searches for divisi with name "Marketing Strategy"
    And User clicks the search button
    Then Divisi with name "Marketing Strategy" should be found

  Scenario: Reset divisi filter
    When User searches for divisi with name "Application Processing"
    And User clicks the search button
    And User clicks the reset button
    Then Divisi with name "Application Processing" should not be found

  Scenario: Select number of rows of rows per page
    When User selects "5" rows per page
    Then The number of rows displayed should be "5"
