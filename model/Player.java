import Java.util.*;

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

    public Coordinates fire() {
        return firingStrategy.fire(minX, maxX);
    }

    public Optional<Ship> defend(Coordinates attackedCoordinates) {
        for(Ship ship: ships) {
            if(ship.getCoordinatesSet.contains(attackedCoordinates)) {
                ship.markDestroyed();
                return Optional.of(ship);
            }
        }
        return Optional.empty();
    }

    public Set<Coordinates> getBlockedCoordinates() {
        return ships.stream()
                    .map(Ship::getCoordinatesSet)
                    .flatmap()
                    .toList();
    }

    public boolean hasLost() {
        return ships.stream().filter(ship -> !ship.isDestroyed()).count() == 0;
    }
}