
import java.util.*;
public class Coordinates {
    final int x;
    final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean equals(Object obj) {
        if(obj == null || ! (obj instanceof Coordinates))
            return false;

        Coordinates coordinates = (Coordinates) obj;
        return coordinates.getX() == this.x && coordinates.getY() == this.y;
    }
}