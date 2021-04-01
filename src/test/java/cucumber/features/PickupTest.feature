Feature: Pickup tests

  Scenario: There is all elements on home page
    Given User is on "http://qalab.pl.tivixlabs.com/" side
    When On page should be all elements
    Then User close browser

  Scenario Outline: Scenario: User can choose country, city, model and dates
    Given User is on "http://qalab.pl.tivixlabs.com/" side
    When User fill up country with <country>
    And User fill up city with <city>
    And User fill up model with <model>
    And User fill up pick up date with <pick-up-date>
    And User fill up drop off date with <drop-off date>
    Then User click submit button
    And List is not empty
    Then User close browser
    Examples:
      | country  | city    | model | pick-up-date | drop-off date |
      | France   | Paris   | 1     | 03122020     | 31012021      |
      | Germainy | Berlin  | 2     | 03122020     | 31012021      |
      | Poland   | Cracow  | 3     | 03122020     | 31012021      |
      | Poland   | Wroclaw | 13    | 03122020     | 31012021      |

  Scenario Outline: Scenario: User can click on a rent first car
    Given User is on "http://qalab.pl.tivixlabs.com/" side
    When User fill up country with <country>
    And User fill up city with <city>
    And User fill up model with <model>
    And User fill up pick up date with <pick-up-date>
    And User fill up drop off date with <drop-off date>
    And User click submit button
    And User can rent a car on <position>
    Then Check a data renting cars form <position> with <country> and <city>
    Then User close browser

    Examples:
      | country | city  | model | pick-up-date | drop-off date | position|
      | France  | Paris | 12     | 03122020     | 31012021      | 1      |