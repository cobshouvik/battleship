import java.util.Random;

public class RandomFiringStrategy implements FiringStrategy {
    Random random;

    public RandomFiringStrategy() {
        random = new Random();
    }

    public Coordinates fire(int minX, int maxX) {
        int xVal = random.nextInt(maxX-minX) + minX;
        int yVal = random.nextInt(maxX-minX);
        return new Coordinates(xVal, yVal);
    }
}