package algorithm.geometry;

/**
 * Created by Francisco Yllera.
 * DTO for containing two points and their distance, it's used in the closest pair of points problems.
 */
public class PairOfPoints {
    Point a;
    Point b;
    double distance;

    public PairOfPoints(Point a, Point b, double distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    public PairOfPoints(PairOfPoints otherPairOfPoints) {
        this.a = otherPairOfPoints.getA();
        this.b = otherPairOfPoints.getB();
        this.distance = otherPairOfPoints.getDistance();
    }

    public void reloadPoints(Point a, Point b, double distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    public PairOfPoints getTheLowest(PairOfPoints otherPair) {
        return (otherPair != null && otherPair.getDistance() < this.distance) ? otherPair : this;
    }

    public double getDistance() {
        return this.distance;
    }

    public Point getA() {
        return this.a;
    }

    public Point getB() {
        return this.b;
    }

    @Override
    public String toString() {
        return "PairOfPoints{" + "a=" + a + ", b=" + b + ", distance=" + distance + '}';
    }
}
