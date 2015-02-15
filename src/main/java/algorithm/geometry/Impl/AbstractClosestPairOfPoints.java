package algorithm.geometry.Impl;

import algorithm.geometry.Point;

/**
 * Created by Francisco Yllera.
 */
public abstract class AbstractClosestPairOfPoints {
    /**
     * Calculate the euclidean distance of 2 points.
     * @param a first point
     * @param b second point
     * @return euclidean distance of the points.
     */
    protected double calculateDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2d) + Math.pow(b.getY() - a.getY(), 2d));
    }
}
