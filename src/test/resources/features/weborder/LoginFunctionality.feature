Feature: Testing Login Func of WebOrder Page
  Scenario: Happy Path (correct username + correct login)
    #Given
    When User provides 'guest1@microworks.com' and 'Guest1!' for WebOrder
    Then User validates 'ORDER DETAILS - Weborder' from homepage

    Scenario: Testing negative login (correct username + wrong password)
      When User provides 'guest1@microworks.com' and 'wrong' for WebOrder
      Then User validates message 'Sign in Failed'

  Scenario: Testing negative login (wrong username + correct password)
    When User provides 'wrong@microworks.com' and 'Guest1' for WebOrder
    Then User validates message 'Sign in Failed'

  Scenario: Testing negative login (wrong username + wrong password)
    When User provides 'wrong@microworks.com' and 'wrong' for WebOrder
    Then User validates message 'Sign in Failed'

  Scenario: Testing negative login (empty username + empty password)
    When User provides '' and '' for WebOrder
    Then User validates message 'Sign in Failed'