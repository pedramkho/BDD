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

  Scenario Outline: sqr and rvs performance.
    Given Input value <first>, and the operation "<second>"
    When I do operation
    Then I expect the result <result>
    Examples:
      | first | second | result             |
      | 1     | rvs    | 1                  |
      | -1    | rvs    | -1                 |
      | 8     | rvs    | 0.125              |
      | -10   | rvs    | -0.1               |
      | 4     | sqr    | 2                  |
      | 1024  | sqr    | 32                 |
      | 8     | sqr    | 2.8284271247461903 |