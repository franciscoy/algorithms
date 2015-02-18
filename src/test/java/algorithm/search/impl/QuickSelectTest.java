package algorithm.search.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSelectTest {

    private int[] testArray = {6,5,2,3,1,7,4,8};

    @Test
    public void whenSearchingMedianElementReturnCorrect() {
        QuickSelect quickSelect = new QuickSelect();
        assertEquals(4, quickSelect.findKthOrderStatistic(testArray, 3));
    }

    @Test
    public void whenSearchingLowestOrderStatisticElementReturnCorrect() {
        QuickSelect quickSelect = new QuickSelect();
        assertEquals(1, quickSelect.findKthOrderStatistic(testArray, 0));
    }

    @Test
    public void whenSearchingBiggestOrderStatisticElementReturnCorrect() {
        QuickSelect quickSelect = new QuickSelect();
        assertEquals(8, quickSelect.findKthOrderStatistic(testArray, 7));
    }
}