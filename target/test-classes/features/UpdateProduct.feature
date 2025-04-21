Feature: Update product using PUT API

  Scenario Outline: Validate if PUT product API status code works correctly
    Given I hit the url of post products api endpoint
    When I pass the url of products in the request with <ProductNumber>
    Then I receive the response code as 200
    Examples:
      | ProductNumber |
      | 7    |
