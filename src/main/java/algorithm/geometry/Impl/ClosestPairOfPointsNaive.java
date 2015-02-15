package algorithm.geometry.Impl;

import algorithm.geometry.ClosestPairOfPoints;
import algorithm.geometry.PairOfPoints;
import algorithm.geometry.Point;

/**
 * Created by Francisco Yllera.
 */
public class ClosestPairOfPointsNaive extends AbstractClosestPairOfPoints implements ClosestPairOfPoints{

    /**
     * Find the closest pair of points in an array.
     * It does it naively/brute-force.
     * @param pointsArray
     * @return PairOfPoints
     */
    @Override
    public PairOfPoints findClosestPairs(Point[] pointsArray) {
        if (pointsArray.length < 2) {
            return null;
        }
        double currentDistance;
        PairOfPoints closestPair = new PairOfPoints(pointsArray[0], pointsArray[1], Double.MAX_VALUE);

        for (int i = 0; i < pointsArray.length - 1; i++) {
            for (int j = i + 1; j < pointsArray.length; j++) {
                currentDistance = calculateDistance(pointsArray[i], pointsArray[j]);
                if (currentDistance < closestPair.getDistance()) {
                    closestPair.reloadPoints(pointsArray[i], pointsArray[j], currentDistance);
                }
            }
        }

        return closestPair;
    }
}
