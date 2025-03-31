Practice battleship

BattleShip Game
This is a command-line-based implementation of the classic BattleShip game. The game is designed for two players who take turns firing missiles at each other's ships, with the goal of destroying all of the opponent's ships.

Game Features
Playable in a grid-based battlefield of size NxN.
Each player controls half of the battlefield, and the number of ships for both players is equal.
Players take turns firing missiles at random coordinates on the opponent's field.
The game ends when one player's entire fleet is destroyed.
Requirements
Battlefield Setup:
The battlefield is an NxN grid.
Players each control NxN/2 grids.
Ship size and locations are provided by the players.
Ships are square-shaped and cannot overlap, but they can touch boundaries.
Gameplay:
Each player fires one missile at a random coordinate in the opponent’s field.
A missile may either hit or miss an opponent's ship.
The game ends when all ships of one player are destroyed.
API Functions:
initGame(N): Initializes a battlefield of size NxN.
addShip(id, size, xA, yA, xB, yB): Adds a ship of a given size at specified coordinates for both players.
startGame(): Begins the game with PlayerA firing the first missile.
viewBattleField() (Optional): Displays the battlefield grid and shows ship positions.
Usage
Initializing the Game
Start by initializing the game with the size of the battlefield:

>> initGame(6)
>> addShip("SH1", 2, 1, 5, 4, 4)
>> startGame()
PlayerA's turn: Missile fired at (3, 0): "Miss"
PlayerB's turn: Missile fired at (1, 1): "Miss"
PlayerA's turn: Missile fired at (5, 3): "Hit" B-SH2 destroyed
GameOver. PlayerA wins.


-----------------------------------------------------------------------------------------------------------------

Implementation details : 

1. N*N grid
2. N*N/2 per player
3. Fire missiiles at random coordinates at each turn . may also be specified by the player or some other way.
4. game ends when one person's fleet/ ships are destroyed
5. Ship size and location are given by the players - validation
6. Ships are square and cannot overlap but can touch boundaries - validation 
7. After firing, missiles either hit or miss 
8. initgame
9. addShip(id, size, xA, yA, xB, yB)
10. startGame() - playerA firing 
11. view battlefield() 


Classes

Main class - to take in commands and execute through game service

Models

Ship - 
    vars: name, coordinates (store all coordinates derived from inputs), isDestroyed,
    methods - @Data, get coordinates 
    resonsibility - hold data and check if ship is hit with coordinates , 

Player -
    vars: - Ships, gridAreaStart, gridAreaEnd, firingStrategy\
    methods - @Data, NextAttackCoordinate - return coordinate, handleAttack -> return ship name if hit, else empty
    responsibility - return attack coordinates on attack, report result when attacked

BattleField - 
    vars - grid[][], map - player, ships

    responsibilities - check if valid ship placement and place ships, check game status, check if it's a hit and act

GameService -
    vars - Players, BattleField
    methods - addship, startgame, initgame, 
    responsibilty - creating grid, tracking turns and continuing the game, validate entries

 


