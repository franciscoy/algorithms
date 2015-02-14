package algorithm.geometry.Impl;

import algorithm.geometry.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClosestPairOfPointsNaiveTest {

    ClosestPairOfPointsNaive closestPairOfPointsNaive = new ClosestPairOfPointsNaive();
    Point a = new Point(4,5);
    Point b = new Point(2,4);
    Point c = new Point(1,1);
    Point d = new Point(3,1);

    @Test
    public void whenClosestPairInArrayThenReturnThem() throws Exception {
        Point[] points = {a,b,c,d};
        Point[] expectedPoints = {c,d};

        assertArrayEquals(expectedPoints, closestPairOfPointsNaive.findClosestPairs(points));
    }

    @Test
    public void whenTwoElementInArrayThenReturnThem() throws Exception {
        Point[] points = {c,d};
        Point[] expectedPoints = {c,d};

        assertArrayEquals(expectedPoints, closestPairOfPointsNaive.findClosestPairs(points));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenOneElementInArrayThenThrowException() throws Exception {
        Point[] points = {c};
        closestPairOfPointsNaive.findClosestPairs(points);
    }

    @Test
    public void whenCalculateDistanceThenReturnCorrect() throws Exception {
        assertEquals(2.0d, closestPairOfPointsNaive.calculateDistance(c,d), 0);
    }

    @Test
    public void whenCalculateBiggerDistanceThenReturnCorrect() throws Exception {
        assertEquals(4.12d, closestPairOfPointsNaive.calculateDistance(a,d), 0.01);
    }
}