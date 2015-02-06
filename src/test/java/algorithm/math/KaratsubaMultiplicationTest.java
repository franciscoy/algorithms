package algorithm.math;

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Francisco Yllera.
 */
public class KaratsubaMultiplicationTest {

    @Test
    public void testMultiplyEvenDigitsNumbers() {
        KaratsubaMultiplication karatsubaMultiplication = new KaratsubaMultiplication();
        BigInteger x = BigInteger.valueOf(123456);
        BigInteger y = BigInteger.valueOf(123456);
        BigInteger expectedResult = new BigInteger("15241383936");

        assertEquals(karatsubaMultiplication.multiply(x, y), expectedResult);
    }

    @Test
    public void testMultiplyOddDigitsNumbers() {
        KaratsubaMultiplication karatsubaMultiplication = new KaratsubaMultiplication();
        BigInteger x = BigInteger.valueOf(12345);
        BigInteger y = BigInteger.valueOf(12345);
        BigInteger expectedResult = new BigInteger("152399025");

        assertEquals(karatsubaMultiplication.multiply(x, y), expectedResult);
    }

    @Test
    public void testMultiplyOddAndEvenDigitNumbers() {
        KaratsubaMultiplication karatsubaMultiplication = new KaratsubaMultiplication();
        BigInteger x = BigInteger.valueOf(12345);
        BigInteger y = BigInteger.valueOf(123456);
        BigInteger expectedResult = new BigInteger("1524064320");

        assertEquals(karatsubaMultiplication.multiply(x, y), expectedResult);
    }
}
