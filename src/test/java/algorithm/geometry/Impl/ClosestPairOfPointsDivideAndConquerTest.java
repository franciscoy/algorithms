package algorithm.geometry.Impl;

import algorithm.geometry.ClosestPairOfPoints;

public class ClosestPairOfPointsDivideAndConquerTest extends AbstractClosestPairOfPointsTest{

    @Override
    public ClosestPairOfPoints getClosestPairOfPointsAlgorithm() {
        return new ClosestPairOfPointsDivideAndConquer();
    }
}