public class ShipPlacementValidator {

    public static boolean isShipPlacementValid(Player player, int gridSize, int newShipX, int newShipY) {
        if(newShipX >=player.getMinX() &&  newShipX <= player.getMaxX() && newShipY >= 0 && newShipY < gridSize)
            return false;
        return !player.getBlockedCoordinates().contains(new Coordinates(newShipX, newShipY));
    }
}