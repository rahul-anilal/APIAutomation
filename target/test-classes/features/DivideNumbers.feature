Feature: Divide two numbers

    Scenario Outline: Validate if adding functionality works correctly
        Given I have two integers <x> and <y>
        When I divide <x> with <y>
        Then I should get the quotient of <x> with <y>

        Examples:
        |x  |  y|
        |1 | 2 |
        |0 | -3|
        |0.5 | 1 |