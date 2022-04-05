Feature: This feature will test rest_api__ieva_valuniene


  Scenario: create click up folder
    When I create clickup folder
    Then I create a list in the folder
    And I check if List name is correct and added to correct folder
    Then In the List I create one Task with automatically generated and unique name
    And I check if Task name is correct
    Then I remove the task




