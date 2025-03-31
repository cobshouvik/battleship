
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

    public int hashcode() {
        return Objects.hashcode(x, y);
    }

    public boolean equals(Coordinates coordinates) {
        if(coordinates == null)
            return false;
        
        return coordinates.getX == this.x && coordinates.getY == this.y;
    }
}