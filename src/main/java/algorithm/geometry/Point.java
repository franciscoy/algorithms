package algorithm.geometry;

/**
 * Created by Francisco Yllera.
 */
public class Point extends Object{
    private int X;
    private int Y;

    public Point(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    @Override
    public String toString() {
        return "Point{" + " X=" + X + ", Y=" + Y +'}';
    }
}
