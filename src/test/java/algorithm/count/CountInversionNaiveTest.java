package algorithm.count;

public class CountInversionNaiveTest extends CountInversionTest{

    @Override
    public CountInversion getCountInversion() {
        return new CountInversionNaive();
    }
}