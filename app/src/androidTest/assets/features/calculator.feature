Feature: Calculator

  Scenario Outline: Display number
    Given a clear input field
    When click "<expectedValue>" button
    Then "<expectedValue>" is displayed in input field

    Examples:
      | expectedValue |
      | 0             |
      | 1             |
      | 2             |
      | 3             |
      | 4             |
      | 5             |
      | 6             |
      | 7             |
      | 8             |
      | 9             |

  Scenario Outline: Calculate sum
    Given a clear input field
    When click "<firstNumber>" button
    And click decimal button
    And click "<secondNumber>" button
    And click plus button
    And click "<thirdNumber>" button
    And click equal button
    Then "<sumResult>" is displayed in input field

    Examples:
      | firstNumber | secondNumber | thirdNumber | sumResult |
      | 2           | 5            | 3           | 5.5       |

  Scenario Outline: Calculate subtract
    Given a clear input field
    When click "<firstNumber>" button
    And click decimal button
    And click "<secondNumber>" button
    And click minus button
    And click "<thirdNumber>" button
    And click lead to negative button
    And click equal button
    Then "<sumResult>" is displayed in input field

    Examples:
      | firstNumber | secondNumber | thirdNumber | sumResult |
      | 5           | 5            | 3           | 8.5       |

  Scenario Outline: Calculate multiply
    Given a clear input field
    When click "<firstNumber>" button
    And click decimal button
    And click "<secondNumber>" button
    And click multiply button
    And click "<thirdNumber>" button
    And click equal button
    Then "<sumResult>" is displayed in input field

    Examples:
      | firstNumber | secondNumber | thirdNumber | sumResult |
      | 3           | 5            | 3           | 10.5      |

  Scenario Outline: Calculate division
    Given a clear input field
    When click "<firstNumber>" button
    And click decimal button
    And click "<secondNumber>" button
    And click divide button
    And click "<thirdNumber>" button
    And click lead to negative button
    And click equal button
    Then "<sumResult>" is displayed in input field

    Examples:
      | firstNumber | secondNumber | thirdNumber | sumResult |
      | 8           | 5            | 2           | -4.25     |
