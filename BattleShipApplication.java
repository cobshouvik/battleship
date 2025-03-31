public class BattleShipApplication{
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.initGame(6);
        gameService.addShip("ship-1", 2, 0, 0, 3, 3);
        gameService.startGame();
    }
}