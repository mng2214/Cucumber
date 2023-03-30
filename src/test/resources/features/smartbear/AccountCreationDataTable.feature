@regression2
Feature: Testing account creation and validation from SmartBear

  Scenario:
    When User login with  username  and passwod  and click order button and click Order Page
      | username | Tester |
      | password | test   |
    And User provides Product Info
      | product  | MyMoney |
      | quantity | 10      |
    And User provides Personal Info
      | name    | Artur1      |
      | address | 112 Lake St |
      | city    | Chicago     |
      | state   | IL          |
      | zip     | 60707       |
    And User provides Payment Info
      | cartType   | visa      |
      | cardNumber | 123456789 |
      | expDate    | 04/29     |

    And User click Process and Validates message
      | successfully added |


 #  When User goes to View All Order page and validates added product: '<name>', '<product>', '<quantity>', '<address>', '<city>', '<state>', '<zip>', '<cartType>','<cardNumber>','<expDate>'

 #   Examples:
 #     | product     | quantity | name   | address      | city     | state | zip   | cartType        | cardNumber | expDate | message            |
  #    | MyMoney     | 10       | Artur1 | 112 Lake St  | Chicago  | IL    | 60707 | visa            | 123456789  | 04/29   | successfully added |
