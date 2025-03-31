import java.util.*;

public class GameService {
    static final int max_turns = 100;
    ShipPlacementValidator ShipPlacementValidator;
    List<Player> players;
    BattleField battleField;

    public void addShip(String shipId, int size, int ax, int ay, int bx, int by) {
        Ship playerAShip = new Ship(shipId, ax, ay, size);
        Ship playerBShip = new Ship(shipId, bx, by, size);
        if(ShipPlacementValidator.isShipPlacementValid(players.get(0), playerAShip, battleField) && 
            ShipPlacementValidator.isShipPlacementValid(players.get(1), playerBShip, battleField)) { 
                players.get(0).addShip(playerAShip);
                players.get(1).addShip(playerBShip);
            }
    }

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
        if(battleField == null || battleField.getGameStatus() != GameStatus.INITITATED) {
            System.out.println("Error : game status is not appropriate, status is " + battleField.getGameStatus());
            return;
        }

        int currentAttacker = 0;
        int currentDefender = 1;
        int winningPlayer = -1;

        int turnCount = 0;

        while(winningPlayer == -1 && ++turnCount<=max_turns) {
            Coordinates attackedCoordinates = players.get(currentAttacker).fire(players.get(currentDefender).getMinX(), 
                players.get(currentDefender).getMaxX());
            Optional<Ship> attackedShip = players.get(currentDefender).defend(attackedCoordinates);
            String attackResult = String.format("Player%s's turn: Missile fired at (%s, %s): %s", 
                (char)(currentAttacker + 'A'), attackedCoordinates.getX(), attackedCoordinates.getY(), attackedShip.isEmpty()? 
                "\"Miss\"" : "\"Hit\" " +  attackedShip.get() + " destroyed");

            System.out.println(attackResult);

            if(players.get(currentDefender).hasLost()) {
                winningPlayer = currentAttacker;
            } else {
                currentAttacker = (currentAttacker+1)%2;
                currentDefender = (currentDefender+1)%2;
            }
        }
        if(winningPlayer!= -1){
            battleField.setGameStatus(GameStatus.OVER);
        }

        System.out.println("Game over : winner is " + (char)(winningPlayer + 'A') + String.format(" after %s turns", turnCount));

        viewBattleField();
    }

    public void viewBattleField() {
        String[][] gridView = battleField.viewBattleField();
        for(int i=0;i<gridView.length;i++) {
            for(int j=0;j<gridView.length;j++) {
                System.out.print(gridView[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Above is the current grid view");
        System.out.println("-------------------------------------------------------");
    }
}