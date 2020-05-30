Feature: Query Weather

  Background:
    Given the following weather
      | location | lat | lon | description | temperature |
      | test     | 0.0 | 0.0 | sunny       | 25          |

  Scenario: Valid contract
    Given I purchased a contract
    When I query the weather
    Then I get "Weather in test: sunny at 25 degrees."

  Scenario: No valid contract
    Given I did not purchase a contract
    When I query the weather
    Then I get an error with message "No contract"

  Scenario: Weather API error
    Given I purchased a contract
    And there is an error with the weather API
    When I query the weather
    Then I get an error with message "Weather information not available"