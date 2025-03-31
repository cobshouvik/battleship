public class BattleField {
    int size;
    List<Player> players;
    GameStatus status;

    public BattleField(int size, List<Player> players, GameStatus status) {
        this.size = size;
        this.players = players;
        this.status = status;
    }

    public Optional<Player> checkWinner() {
        if(players.get(0).hasLost()) {
            return Optional.of(players.get(1));
        }
        if(players.get(1).hasLost()) {
            return Optional.of(players.get(0));
        } 
        return Optional.empty();
    }

    public GameStatus getGameStatus() {
        return this.status;
    }

    public void viewBattleField() {
        //TBD
    }

    



}