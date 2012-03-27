Feature: Pack 02
  Background:
	Given the level has 2 possible moves
	
  Scenario: Solve pack 2 level 1
    Given the left upper head has the face turned "UP" and the ear turned "BACK"
    And the right upper head has the face turned "UP" and the ear turned "BACK"
    And the left lower head has the face turned "UP" and the ear turned "BACK"
    And the right lower head has the face turned "UP" and the ear turned "BACK"
    When I ask for the solution
    Then I should have a list of moves with the same size of the possible moves
    
  Scenario: Solve pack 2 level 2
    Given the left upper head has the face turned "LEFT" and the ear turned "BACK"
    And the right upper head has the face turned "LEFT" and the ear turned "UP"
    And the left lower head has the face turned "UP" and the ear turned "BACK"
    And the right lower head has the face turned "FRONT" and the ear turned "UP"
    When I ask for the solution
    Then I should have a list of moves with the same size of the possible moves