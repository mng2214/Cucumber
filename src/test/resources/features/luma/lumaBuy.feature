Feature: Luma cart functionality
  Scenario: Testing add to cart functionality
    When User select Men-Tops-Jackets
    And User select to cart 'Montana Wind Jacket'
    Then User validates 'added Montana Wind Jacket'