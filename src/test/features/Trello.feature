@trello
Feature: Trello API Testing > Create Board, Create List, Create and update card. Then delete board.

  Scenario: Create a new Board
    * set "boards" path parameters
    * set name of board as "New Board"
    * save the response to create a new board
    * verify status code successfully
    And wait for display

  Scenario: Create a list on the Board
    * set "lists" path parameters
    * set name of list as "Test List"
    * save the response to create a new list
    * verify status code successfully
    And wait for display

  Scenario: Create first Card on the List
    * set "cards" path parameters
    * set name of card as "A Card"
    * save the response to create a new card
    * verify status code successfully
    And wait for display

  Scenario: Create second Card on the List
    * set "cards" path parameters
    * set name of card as "B Card"
    * save the response to create a new card
    * verify status code successfully
    And wait for display


  Scenario: Randomly select a card and update it
    * randomly choose an id of cards and set path parameters
    * set new and description of card
    * update choosen card
    * verify status code successfully
    And wait for display

  Scenario: Delete first card
    * set the path of card to be deleted
    * delete card
    * verify status code successfully
    And wait for display

  Scenario: Delete second card
    * set the path of card to be deleted
    * delete card
    * verify status code successfully
    And wait for display

  Scenario: Delete board
    * set path of board to be deleted
    * delete board
    * verify status code successfully




