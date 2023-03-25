Feature: Testing Google Search Functionality
  #this is comment
  Scenario: Happy Path (positive) Testing for Search
    #its all about test case
    Given User navigates to Google
    When User searches for CodeFish
    Then User gets more then ten links on the first page

    Scenario:  Kyrgyz Food Search Results Validation
      Given  User navigates to Google
      When  User Searches for Kyrgyz food in USA
      Then  Validates search results > then 180m

  Scenario: Happy Path(positive) Testing timeResult from Search
    Given User navigates to Google
    When User searches for turkish baklava
    Then User gets result less than one second