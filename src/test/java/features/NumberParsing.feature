Feature: Number Parser

  Scenario: Successfully parse a valid integer string
    Given the input is "123"
    When I parse the input
    Then the result value should be 123

  Scenario: Successfully parse a negative integer string
    Given the input is "-456"
    When I parse the input
    Then the result value should be -456

  Scenario: Successfully parse zero
    Given the input is "0"
    When I parse the input
    Then the result value should be 0

  Scenario: Fail to parse a non-integer string
    Given the input is "abc"
    When I parse the input
    Then a NumberFormatException error should occur

  Scenario: Fail to parse a decimal number
    Given the input is "123.45"
    When I parse the input
    Then a NumberFormatException error should occur

  Scenario: Fail to parse an empty string
    Given the input is ""
    When I parse the input
    Then a NumberFormatException error should occur

  Scenario: Fail to parse a null input
    Given the input is null
    When I parse the input
    Then a NullPointerException error should occur