Feature: Calculator division

  As a user
  I want to divide two numbers
  So that I get a valid result or a meaningful error message

  Scenario Outline: Valid floating-point division
    Given I enter floats <num1> and <num2> into the calculator
    When I request float division
    Then I should get the float result <result>

    Examples:
      | num1 | num2 | result |
      | 10.0 |  2.0 |  5.0   |
      | 7.0  |  2.0 |  3.5   |
      | -8.0 |  4.0 | -2.0   |
      | 0.0  |  3.0 |  0.0   |

  Scenario: Float division by zero
    Given I enter floats 7.0 and 0.0 into the calculator
    When I request float division
    Then I should get the error message "Cannot divide by zero"
