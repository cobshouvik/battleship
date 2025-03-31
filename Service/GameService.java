import Java.util.*;

public class GameService {
    ShipPlacementValidator ShipPlacementValidator;
    List<Player> players;
    BattleField battleField;

    public void initGame(int size) {
        if(size%2==1){
            System.out.println("Error : grid size should be even");
            return;
        }
        FiringStrategy firingStrategy = new RandomFiringStrategy();
        Player player1 = new Player(0, size/2 -1, firingStrategy);
        Player player2 = new Player(size/2, size, firingStrategy);
        this.players = List.of(player1, player2);
        this.battleField = new BattleField(size, this.players, GameStatus.INITITATED);
    }

    public void startGame() {
        if(battleField == null || battleField.getGameStatus != INITITATED) {
            System.out.println("Error : game status is not appropriate, status is " + battleField.getGameStatus);
            return;
        }

        int currentAttacker = 0;
        int currentDefender = 1;
        int winningPlayer = -1;

        while(winningPlayer == -1) {
            Coordinates attackedCoordinates = players.get(currentAttacker).fire();
            Optional<Ship> attackedShip = players.get(currentDefender).defend(attackedCoordinates);
            String attackResult = String.format("Player%s's turn: Missile fired at (%s, %s): %s", 
                (char)(currentAttacker + 'A'), attackedCoordinates.getX(), attackedCoordinates.getY(), attackedShip.isEmpty()? 
                "\"Miss\"" : "\"Hit\ " +  attackedShip.get() + " destroyed");

            if(players.get(currentDefender).hasLost()) {
                winningPlayer = currentAttacker;
            } else {
                currentAttacker = (currentAttacker+1)%2;
                currentDefender = (currentDefender+1)%2;
            }
        }

        System.out.println("Game over : winner is %s", (char)(winningPlayer + 'A'));
    }
}