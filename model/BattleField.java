import java.util.*;

public class BattleField {
    int size;
    List<Player> players;
    GameStatus status;

    public BattleField(int size, List<Player> players, GameStatus status) {
        this.size = size;
        this.players = players;
        this.status = status;
    }

    public int getSize() {
        return size;
    }

    public GameStatus getGameStatus() {
        return this.status;
    }

    public void setGameStatus(GameStatus status) {
        this.status = status;
    }

    public String[][] viewBattleField() {
        String[][] gridView = new String[size][size];
        for(int i=0;i<size;i++) {
            Arrays.fill(gridView[i], "######");
        }
        for(Ship ship: players.get(0).getShips()) {
            for(Coordinates coordinates : ship.getCoordinatesSet()) {
                gridView[coordinates.getX()][coordinates.getY()] = "A:" + ship;
            }
        }

        for(Ship ship: players.get(1).getShips()) {
            for(Coordinates coordinates : ship.getCoordinatesSet()) {
                gridView[coordinates.getX()][coordinates.getY()] = "B:" + ship;
            }
        }

        return gridView;
    }

    



}