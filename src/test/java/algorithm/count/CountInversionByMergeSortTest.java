package algorithm.count;

/**
 * Created by Francisco Yllera.
 */
public class CountInversionByMergeSortTest extends CountInversionTest {

    @Override
    public CountInversion getCountInversion() {
        return new CountInversionByMergeSort();
    }
}
