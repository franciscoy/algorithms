package algorithm.math;

import java.math.BigInteger;

/**
 * Created by Francisco Yllera.
 */
public class KaratsubaMultiplication {

    /**
     * Multiplies two big numbers efficiently, using 3 multiplications instead of traditional 4.
     * It uses the divide and conquer way of solving algorithms.
     *
     * x = 10^(n/2) b + a
     * y = 10^(n/2) d + c
     *
     * @param x
     * @param y
     * @return the multiplication of both
     */
    public BigInteger multiply(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 100) return x.multiply(y);

        N = (N / 2) + (N % 2);

        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        BigInteger ac = multiply(a, c);
        BigInteger bd = multiply(b, d);
        BigInteger aPlusbTimescPlusd  = multiply(a.add(b), c.add(d));

        return ac.add(aPlusbTimescPlusd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }
}
