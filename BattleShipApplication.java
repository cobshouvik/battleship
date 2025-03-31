public class BattleShipApplication{
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.initGame(6);
        gameService.addShip("sh-1", 2, 0, 0, 3, 0);
        gameService.addShip("sh-2", 1, 2, 2, 5, 5);
        gameService.addShip("sh-3", 2, 0, 3, 3, 3);
        gameService.addShip("sh-4", 1, 0, 5, 5, 0);
        gameService.addShip("sh-5", 5, 0, 5, 5, 0);
        gameService.viewBattleField();
        gameService.startGame();
    }
}