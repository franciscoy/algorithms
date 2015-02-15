package algorithm.geometry.Impl;

import algorithm.geometry.ClosestPairOfPoints;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClosestPairOfPointsNaiveTest extends AbstractClosestPairOfPointsTest{
    @Override
    public ClosestPairOfPoints getClosestPairOfPointsAlgorithm() {
        return new ClosestPairOfPointsNaive();
    }

    @Test
    public void whenCalculateDistanceThenReturnCorrect() throws Exception {
        assertEquals(2.0d, new ClosestPairOfPointsNaive().calculateDistance(c,d), 0);
    }

    @Test
    public void whenCalculateBiggerDistanceThenReturnCorrect() throws Exception {
        assertEquals(4.12d, new ClosestPairOfPointsNaive().calculateDistance(a, d), 0.01);
    }
}