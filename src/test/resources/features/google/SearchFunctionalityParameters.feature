Feature: Testing Google Search Func

  Scenario: Happy Path(positive) Testing Search
    Given User navigates to the 'https://www.google.com/'
    When User searches for 'codefish'
    Then User gets more then 10 links

  Scenario: Happy Path(positive) Testing Search
    Given User navigates to the 'https://www.google.com/'
    When User searches for 'Kyrgyz Food in USA'
    Then User validates the result is more then  1000000
