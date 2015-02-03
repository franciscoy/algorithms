package algorithms.shuffle.Impl;

import algorithm.shuffle.Impl.FisherYatesShuffle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Francisco Yllera.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Random.class, FisherYatesShuffle.class})
public class FisherYatesShuffleTest{

    Random mockedRandom;

    @Before
    public void setUp() throws Exception {
        mockedRandom = PowerMockito.mock(Random.class);
        PowerMockito.whenNew(Random.class).withNoArguments().thenReturn(mockedRandom);
    }

    @Test
    public void testSomethingRandom() {
        FisherYatesShuffle fisherYatesShuffle = new FisherYatesShuffle(this.mockedRandom);
        PowerMockito.doReturn(2).when(this.mockedRandom).nextInt(0);
        PowerMockito.doReturn(1).when(this.mockedRandom).nextInt(2);
        PowerMockito.doReturn(0).when(this.mockedRandom).nextInt(1);

        int[] toShuffle = {1,2,3};
        int[] expectedShuffledArray = {3,2,1};

        assertArrayEquals(fisherYatesShuffle.shuffle(toShuffle), expectedShuffledArray);
    }
}
