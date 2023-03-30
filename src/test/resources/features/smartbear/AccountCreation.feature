@regression
Feature: Testing account creation and validation from SmartBear

  Scenario Outline:
    When User login with  username 'Tester' and passwod 'test' and click order button and click Order Page
    And User provides Product Info :  '<product>' , '<quantity>',
    And User provides Personal Info : '<name>', '<address>','<city>','<state>','<zip>',
    And User provides Payment Info '<cartType>', '<cardNumber>' , '<expDate>'
    And User click Process and Validates '<message>'
    When User goes to View All Order page and validates added product: '<name>', '<product>', '<quantity>', '<address>', '<city>', '<state>', '<zip>', '<cartType>','<cardNumber>','<expDate>'

    Examples:
      | product     | quantity | name   | address      | city     | state | zip   | cartType        | cardNumber | expDate | message            |
      | MyMoney     | 10       | Artur1 | 112 Lake St  | Chicago  | IL    | 60707 | visa            | 123456789  | 04/29   | successfully added |
      | FamilyAlbum | 5        | Artur2 | 1752 Lake St | Brooklyn | Ny    | 12455 | MasterCard      | 987645342  | 04/28   | successfully added |
      | ScreenSaver | 7        | Artur3 | 9856 Lake St | Dallas   | TX    | 7585  | americanexpress | 2542782782 | 04/25   | successfully added |