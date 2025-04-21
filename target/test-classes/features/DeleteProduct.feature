Feature: Delete product using DELETE API

  Scenario Outline: Validate if DELETE product API status code works correctly
    Given I hit the url of delete products api endpoint
    When I pass the url of products in the delete request with <ProductNumber>
    Then I receive the response code as 200
    Examples:
      | ProductNumber |
      | 7    |
