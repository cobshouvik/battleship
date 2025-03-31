import java.util.*;

public class ShipPlacementValidator {

    public static boolean isShipPlacementValid(Player player, Ship ship, BattleField battleField) {
        Set<Coordinates> blockCoordinates = player.getBlockedCoordinates();
        for(Coordinates coordinates : ship.getCoordinatesSet()) { 
            if(!(coordinates.getX() >=player.getMinX() &&  coordinates.getX() <= player.getMaxX() && 
                coordinates.getY() >= 0 && coordinates.getY() < battleField.getSize() && !blockCoordinates.contains(coordinates))){
                System.out.println(coordinates.getX() + " " + player.getMinX() + " " + player.getMaxX() + " " + coordinates.getY() + " " + 
                    battleField.getSize());
                System.out.println(String.format("Ship placement is invalid for %s", ship));
                return false;
            }
        }
        return true;
    }
}