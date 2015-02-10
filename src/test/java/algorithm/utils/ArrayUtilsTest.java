package algorithm.utils;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Francisco Yllera.
 */
public class ArrayUtilsTest {

    private int[] inputArray = {4,8,15,16,23,42,50,108};

    @Test
    public void testCopyArray() {
        int startIndex = 0;
        int lastIndex = inputArray.length - 2;
        int[] copiedArray = ArrayUtils.copyArray(inputArray, startIndex, lastIndex);
        int[] expectedArray = {4,8,15,16,23,42};

        assertArrayEquals(copiedArray, expectedArray);
    }
}
