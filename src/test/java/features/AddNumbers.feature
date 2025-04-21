Feature: Addition of two integers

  As a user
  I want to add two integers
  So that I can get the correct sum

  Scenario Outline: Add two integers
    Given I have two integers <num1> and <num2>
    When I add them
    Then the result should be <sum>

    Examples:
      | num1 | num2 | sum |
      |  2   |  3   |  5  |
      | -1   |  4   |  3  |
      |  0   |  0   |  0  |
      |  10  | -5   |  5  |
      | -7   | -8   | -15 |