import Java.util.*;

public class Ship {
    String name;
    boolean destroyed;
    Set<Coordinates> coordinatesSet;
    int size;

    public Ship(String name, int coordX, int coordY, int size) {
        this.name = name;
        this.size = size;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                coordinatesSet.add(new Coordinates(coordX + i, coordY + j));
            }
        }
    }

    public Set<Coordinates>> getCoordinatesSet() {
        return coordinatesSet;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void markDestroyed() {
        this.isDestroyed = true;
    }
}