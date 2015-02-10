package algorithm.count;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Francisco Yllera.
 */
public abstract class CountInversionTest {

    private int[] arrayWithInversions = {1,3,5,2,4,6};
    private int[] arrayReversed = {6,5,4,3,2,1};
    private int[] arrayOrdered = {1,2,3,4,5,6};
    private int[] arrayOneElement = {5};
    public abstract CountInversion getCountInversion();

    @Test
    public void whenCountingAnArrayWithInversionsThenCountCorrectly() {
        assertEquals(3, getCountInversion().count(arrayWithInversions));
    }

    @Test
    public void whenCountingAnArrayReversedThenCountCorrectly() {
        assertEquals(15, getCountInversion().count(arrayReversed));
    }

    @Test
    public void whenCountingAnArrayOrderedThenCountWillBe0() {
        assertEquals(0, getCountInversion().count(arrayOrdered));
    }

    @Test
    public void whenCountingAnArrayWithOneElementThenCountWillBe0() {
        assertEquals(0, getCountInversion().count(arrayOneElement));
    }
}
