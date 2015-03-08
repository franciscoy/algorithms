package algorithm.online;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianMaintenanceTest {

    @Test
    public void whenStreamIsBalancedReturnCorrect() {
        MedianMaintenance medianMaintenance = new MedianMaintenance();

        medianMaintenance.insert(10);
        medianMaintenance.insert(30);
        assertEquals(20d, medianMaintenance.getMedian(), 0.001d);
        medianMaintenance.insert(1);
        medianMaintenance.insert(50);
        assertEquals(20d, medianMaintenance.getMedian(), 0.001d);
        medianMaintenance.insert(5);
        medianMaintenance.insert(40);
        assertEquals(20d, medianMaintenance.getMedian(), 0.001d);
    }

    @Test
    public void whenStreamIsEvenReturnCorrect() {
        MedianMaintenance medianMaintenance = new MedianMaintenance();

        medianMaintenance.insert(10);
        medianMaintenance.insert(30);
        medianMaintenance.insert(5);
        assertEquals(10d, medianMaintenance.getMedian(), 0.001d);
    }

    @Test
    public void whenStreamIsUnbalancedLowerThanTheMedianReturnCorrect() {
        MedianMaintenance medianMaintenance = new MedianMaintenance();

        medianMaintenance.insert(10);
        medianMaintenance.insert(30);
        assertEquals(20d, medianMaintenance.getMedian(), 0.001d);
        medianMaintenance.insert(1);
        medianMaintenance.insert(7);
        assertEquals(8.5d, medianMaintenance.getMedian(), 0.001d);
        medianMaintenance.insert(2);
        assertEquals(7d, medianMaintenance.getMedian(), 0.001d);
    }

    @Test
    public void whenStreamIsUnbalancedBiggerThanTheMedianReturnCorrect() {
        MedianMaintenance medianMaintenance = new MedianMaintenance();

        medianMaintenance.insert(10);
        medianMaintenance.insert(30);
        assertEquals(20d, medianMaintenance.getMedian(), 0.001d);
        medianMaintenance.insert(40);
        medianMaintenance.insert(80);
        assertEquals(35d, medianMaintenance.getMedian(), 0.001d);
        medianMaintenance.insert(50);
        assertEquals(40d, medianMaintenance.getMedian(), 0.001d);
    }

    @Test
    public void whenStreamIsUnbalancedToBothSidesThanTheMedianReturnCorrect() {
        MedianMaintenance medianMaintenance = new MedianMaintenance();

        medianMaintenance.insert(10);
        medianMaintenance.insert(30);
        assertEquals(20d, medianMaintenance.getMedian(), 0.001d);
        medianMaintenance.insert(1);
        medianMaintenance.insert(7);
        assertEquals(8.5d, medianMaintenance.getMedian(), 0.001d);
        medianMaintenance.insert(40);
        medianMaintenance.insert(80);
        assertEquals(20d, medianMaintenance.getMedian(), 0.001d);
    }

}