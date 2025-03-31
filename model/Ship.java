import java.util.*;

public class Ship {
    String name;
    boolean destroyed;
    Set<Coordinates> coordinatesSet;
    int size;

    public Ship(String name, int coordX, int coordY, int size) {
        this.name = name;
        this.size = size;
        coordinatesSet = new HashSet<>();
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                coordinatesSet.add(new Coordinates(coordX + i, coordY + j));
            }
        }
    }

    public Set<Coordinates> getCoordinatesSet() {
        return destroyed? Set.of() : coordinatesSet;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void markDestroyed() {
        this.destroyed = true;
    }

    public String toString() {
        return this.name;
    }
}