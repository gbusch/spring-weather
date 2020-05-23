Feature: Contract

  Scenario Outline:
    Given the following prices are configured
      | name     | price |
      | default  | 0.1   |
    When I purchase a <model> contract with price <price>
    Then I get the response <status> (<error>)

    Examples:
      | model    | price | status | error                      |
      | default  | 0.1   | 200    | OK                         |
      | default  | 0.05  | 400    | price is not correct       |
      | discount | 0.1   | 400    | price model is not offered |