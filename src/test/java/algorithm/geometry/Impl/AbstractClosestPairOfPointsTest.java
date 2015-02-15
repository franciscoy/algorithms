package algorithm.geometry.Impl;

import algorithm.geometry.ClosestPairOfPoints;
import algorithm.geometry.PairOfPoints;
import algorithm.geometry.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractClosestPairOfPointsTest {

    public abstract ClosestPairOfPoints getClosestPairOfPointsAlgorithm();
    ClosestPairOfPoints closestPairOfPoints = getClosestPairOfPointsAlgorithm();
    Point a = new Point(4,5);
    Point b = new Point(2,4);
    Point c = new Point(1,1);
    Point d = new Point(3,1);
    Point e = new Point(2,2);
    Point f = new Point(2,3);
    Point g = new Point(10,3);
    Point h = new Point(2,53);

    @Test
    public void whenClosestPairInArrayThenReturnThem() throws Exception {
        Point[] points = {a,b,c,d};
        PairOfPoints expectedPair = new PairOfPoints(c,d,2d);

        assertEquals(expectedPair.getDistance(), closestPairOfPoints.findClosestPairs(points).getDistance(), 0);
        assertEquals(expectedPair.getB(), closestPairOfPoints.findClosestPairs(points).getB());
        assertEquals(expectedPair.getA(), closestPairOfPoints.findClosestPairs(points).getA());

    }

    @Test
    public void whenTwoElementInArrayThenReturnThem() throws Exception {
        Point[] points = {c,d};
        PairOfPoints expectedPair = new PairOfPoints(c,d,2d);

        assertEquals(expectedPair.getDistance(), closestPairOfPoints.findClosestPairs(points).getDistance(), 0);
        assertEquals(expectedPair.getB(), closestPairOfPoints.findClosestPairs(points).getB());
        assertEquals(expectedPair.getA(), closestPairOfPoints.findClosestPairs(points).getA());
    }

    @Test
    public void whenBiggerElementArrayThenReturnCorrect() throws Exception {
        Point[] points = {e,a,b,c,d,f,g,h};
        PairOfPoints expectedPair = new PairOfPoints(e,f,1d);

        assertEquals(expectedPair.getDistance(), closestPairOfPoints.findClosestPairs(points).getDistance(), 0);
        assertEquals(expectedPair.getB(), closestPairOfPoints.findClosestPairs(points).getB());
        assertEquals(expectedPair.getA(), closestPairOfPoints.findClosestPairs(points).getA());
    }

    @Test
    public void whenOneElementInArrayThenThrowException() throws Exception {
        Point[] points = {c};
        assertEquals(null, closestPairOfPoints.findClosestPairs(points));
    }
}