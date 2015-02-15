package algorithm.geometry.Impl;

import algorithm.geometry.ClosestPairOfPoints;
import algorithm.geometry.PairOfPoints;
import algorithm.geometry.Point;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static algorithm.utils.ArrayUtils.copyArray;
import static algorithm.utils.ArrayUtils.copyArrayOfPoints;
import static algorithm.utils.ArrayUtils.fullCopy;

/**
 * Created by Francisco Yllera.
 */
public class ClosestPairOfPointsDivideAndConquer extends AbstractClosestPairOfPoints implements ClosestPairOfPoints{

    ClosestPairOfPointsNaive closestPairOfPointsNaive = new ClosestPairOfPointsNaive();

    /**
     * Find the closest pair of points using divide and conquer.
     * @param pointsArray
     * @return the smallest distance PairOfPoints
     */
    @Override
    public PairOfPoints findClosestPairs(Point[] pointsArray) {
        Point[] pointsOrderedByY = sortByY(pointsArray);
        Point[] pointsOrderedByX = sortByX(fullCopy(pointsArray));

        return findClosestByDivideAndConquer(pointsOrderedByX, pointsOrderedByY);
    }

    /**
     *  The divide part, find the closest pair dividing on each side of the arrays. T(n) = 2(n/2). (divide part)
     *  If the elements are a small subarray use brute force T(n) = 3n. (brute force)
     * @param pointsOrderedByX
     * @param pointsOrderedByY
     * @return
     */
    private PairOfPoints findClosestByDivideAndConquer(Point[] pointsOrderedByX, Point[] pointsOrderedByY) {
        int length = pointsOrderedByY.length;
        if (length < 3) {
            return closestPairOfPointsNaive.findClosestPairs(pointsOrderedByY);
        }

        int N = (length / 2) + (length % 2);
        Point[] leftPointsY = copyArrayOfPoints(pointsOrderedByY, 0, N);
        Point[] rightPointsY = copyArrayOfPoints(pointsOrderedByY, N, pointsOrderedByY.length);
        Point[] leftPointsX = copyArrayOfPoints(pointsOrderedByX, 0, N);
        Point[] rightPointsX = copyArrayOfPoints(pointsOrderedByX, N, pointsOrderedByX.length);

        PairOfPoints leftPair = findClosestByDivideAndConquer(leftPointsX, leftPointsY);
        PairOfPoints rightPair = findClosestByDivideAndConquer(rightPointsX, rightPointsY);

        PairOfPoints smallestDistancePair = leftPair.getTheLowest(rightPair);

        return closestSplitPair(pointsOrderedByX, leftPointsY, smallestDistancePair);
    }

    /**
     * Check if there is a closest point smaller than the one found, containing one point on each side.
     * T(n) = 7n.
     * @param pointsOrderedByX
     * @param leftPointsY
     * @param smallestDistancePair
     * @return the smaller distance pair of points
     */
    private PairOfPoints closestSplitPair(Point[] pointsOrderedByX, Point[] leftPointsY, PairOfPoints smallestDistancePair) {
        double delta = smallestDistancePair.getDistance();
        double center = leftPointsY[leftPointsY.length - 1].getY();
        Point[] pointsXInsideDelta = filterArrayByDelta(pointsOrderedByX, center, delta);
        PairOfPoints minimumDistPair = new PairOfPoints(smallestDistancePair);

        for (int i = 0; i < pointsXInsideDelta.length - 7; i++) {
            for (int j = i + 1; j < i + 7; j++) {
                if(Math.abs(pointsXInsideDelta[i].getY() - pointsXInsideDelta[j].getY()) > minimumDistPair.getDistance() ) break;
                double tmpDist = calculateDistance(pointsXInsideDelta[i], pointsXInsideDelta[j]);
                if (tmpDist < minimumDistPair.getDistance()) {
                    minimumDistPair.reloadPoints(pointsXInsideDelta[i], pointsXInsideDelta[j], tmpDist);
                }
            }
        }

        return minimumDistPair;
    }

    /**
     * Ugly implementation for filtering an array, T(n) = 2n.
     * @param pointsOrderedByX
     * @param center
     * @param delta
     * @return
     */
    protected Point[] filterArrayByDelta(Point[] pointsOrderedByX, double center, double delta) {
        ArrayList<Point> yFiltered = new ArrayList<>();
        for (int i = 0; i < pointsOrderedByX.length; i++) {
            if (Math.abs(center - pointsOrderedByX[i].getY()) < delta) {
                yFiltered.add(pointsOrderedByX[i]);
            }
        }
        Point[] filteredArray = new Point[yFiltered.size()];
        for (int i = 0; i < yFiltered.size(); i++) {
            filteredArray[i] = yFiltered.get(i);
        }

        return filteredArray;
    }

    protected Point[] sortByX(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
                    public int compare(Point point1, Point point2) {
                        if (point1.getX() < point2.getX())
                            return -1;
                        if (point1.getX() > point2.getX())
                            return 1;
                        return 0;
                    }
                }
        );
        return points;
    }

    protected Point[] sortByY(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
                    public int compare(Point point1, Point point2) {
                        if (point1.getY() < point2.getY())
                            return -1;
                        if (point1.getY() > point2.getY())
                            return 1;
                        return 0;
                    }
                }
        );
        return points;
    }

    public static void main(String[] args) {
        ClosestPairOfPointsDivideAndConquer cp = new ClosestPairOfPointsDivideAndConquer();

        Point a = new Point(4,5);
        Point b = new Point(2,4);
        Point c = new Point(1,1);
        Point d = new Point(3,1);
        Point e = new Point(2,2);
        Point f = new Point(2,3);

        Point[] points = {e,a,b,c,d,f};

        System.out.println(cp.findClosestPairs(points));

    }
}
