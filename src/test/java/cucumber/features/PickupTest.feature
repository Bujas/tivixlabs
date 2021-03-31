Feature: Pickup tests

  Scenario Outline: Scenario: User can choose pickup country, city, model and dates
    Given User is on "http://qalab.pl.tivixlabs.com/" side
    When User fill up country with <country>
    And User fill up city with <city>
    And User fill up model with <model>
    And User fill up pick up date with <pick-up-date>
    And User fill up drop off date with <drop-off date>
    And User click submit button
    And Close browser
    Examples:
      | country | city  | model | pick-up-date | drop-off date |
      | France  | Paris | 1     | 03122020     | 31012021      |
      | Germainy  | Berlin | 2     | 03122020     | 31012021      |
      | Poland  | Cracow | 3     | 03122020     | 31012021      |
      | Poland  | Wroclaw | 13     | 03122020     | 31012021      |

  Scenario Outline: Scenario: User can choose pickup country, city, model and dates
    Given User is on "http://qalab.pl.tivixlabs.com/" side
    When User fill up country with <country>
    And User fill up city with <city>
    And User fill up model with <model>
    And User fill up pick up date with <pick-up-date>
    And User fill up drop off date with <drop-off date>
    And User click submit button
    Examples:
      | country | city | model | pick-up-date | drop-off date |
      | France  | Paris | 1     | 03122020     | 31012021      |