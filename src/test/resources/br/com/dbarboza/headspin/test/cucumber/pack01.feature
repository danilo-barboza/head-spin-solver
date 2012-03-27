Feature: Pack 01
  Background:
	Given the level has 1 possible moves
	
  Scenario: Solve pack 1 level 1
    Given the left upper head has the face turned "DOWN" and the ear turned "FRONT"
    And the right upper head has the face turned "FRONT" and the ear turned "UP"
    And the left lower head has the face turned "DOWN" and the ear turned "FRONT"
    And the right lower head has the face turned "FRONT" and the ear turned "UP"
    When I ask for the solution
    Then I should have a list of moves with the same size of the possible moves
     
  Scenario: Solve pack 1 level 2
    Given the left upper head has the face turned "FRONT" and the ear turned "UP"
    And the right upper head has the face turned "FRONT" and the ear turned "UP"
    And the left lower head has the face turned "RIGHT" and the ear turned "UP"
    And the right lower head has the face turned "RIGHT" and the ear turned "UP"
    When I ask for the solution
    Then I should have a list of moves with the same size of the possible moves 
