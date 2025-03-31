import java.util.*;
import java.util.stream.Collectors;

public class Player{
    int minX;
    int maxX;
    FiringStrategy firingStrategy;
    List<Ship> ships;

    public Player(int minX, int maxX, FiringStrategy strategy) {
        this.minX = minX;
        this.maxX = maxX;
        this.firingStrategy = strategy;
        this.ships = new ArrayList<>();
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {  
        return maxX;
    }
    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public Coordinates fire(int minX, int maxX) {
        return firingStrategy.fire(minX, maxX);
    }

    public Optional<Ship> defend(Coordinates attackedCoordinates) {
        for(Ship ship: ships) {
            if(!ship.isDestroyed() && ship.getCoordinatesSet().contains(attackedCoordinates)) {
                ship.markDestroyed();
                return Optional.of(ship);
            }
        }
        return Optional.empty();
    }

    public List<Ship> getShips() {
        return this.ships;
    }

    public Set<Coordinates> getBlockedCoordinates() {
        return ships.stream()
                    .filter(ship -> !ship.isDestroyed())
                    .flatMap(ship -> ship.getCoordinatesSet().stream())
                    .collect(Collectors.toSet());
    }

    public boolean hasLost() {
        return ships.stream().filter(ship -> !ship.isDestroyed()).count() == 0;
    }
}