package algorithm.geometry.Impl;

import algorithm.geometry.ClosestPairOfPoints;
import algorithm.geometry.Point;

/**
 * Created by Francisco Yllera.
 */
public class ClosestPairOfPointsNaive implements ClosestPairOfPoints{

    /**
     * Find the closest pair of points in an array.
     * It does it naively/brute-force.
     * @param pointsArray
     * @return
     */
    @Override
    public Point[] findClosestPairs(Point[] pointsArray) {
        if (pointsArray.length < 2) {
            throw new IllegalArgumentException("Points array should contain 2 or more.");
        }
        double minimumDistance = Double.MAX_VALUE;
        double currentDistance;
        Point[] closest = {pointsArray[0], pointsArray[1]};

        for (int i = 0; i < pointsArray.length - 1; i++) {
            for (int j = i + 1; j < pointsArray.length; j++) {
                currentDistance = calculateDistance(pointsArray[i], pointsArray[j]);
                if (currentDistance < minimumDistance) {
                    minimumDistance = currentDistance;
                    closest[0] = pointsArray[i];
                    closest[1] = pointsArray[j];
                }
            }
        }

        return closest;
    }

    /**
     * Calculate the euclidean distance from 2 points.
     * @param a first point
     * @param b second point
     * @return euclidean distance of the points.
     */
    protected double calculateDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2d) + Math.pow(b.getY() - a.getY(), 2d));
    }

    public static void main(String[] args) {
        ClosestPairOfPointsNaive closestPairOfPoints = new ClosestPairOfPointsNaive();

        Point a = new Point(-2,-3);
        Point b = new Point(-4,4);
        Point c = new Point(1, 1);
        Point d = new Point(0, -2);

        Point[] points = {a,b,c,d};
//
//        System.out.println(closestPairOfPoints.calculateDistance(a, b));

        System.out.println(closestPairOfPoints.findClosestPairs(points));
    }
}
