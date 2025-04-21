Feature: Add two numbers

    Scenario Outline: Validate if adding functionality works correctly
        Given I have two integers <x> and <y>
        When I add <x> and <y>
        Then I should get the sum of <x> and <y>

        Examples:
        |x  |  y|
        |1 | 2 |
        |0 | -3|
        |0.5 | 1 |