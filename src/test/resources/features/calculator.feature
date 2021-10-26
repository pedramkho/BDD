@tag
Feature: Calculator

  Scenario: square root
    Given Input value 9, and the operation "sqr"
    When I do operation
    Then I expect the result 3

  Scenario: reverse
    Given Input value 5, and the operation "rvs"
    When I do operation
    Then I expect the result 0.2

  Scenario: negative square root
    Given Input value -10, and the operation "sqr"
    When I do operation
    Then I expect exception, negative square root

  Scenario: division by zero
    Given Input value 0, and the operation "rvs"
    When I do operation
    Then I expect exception, division by zero