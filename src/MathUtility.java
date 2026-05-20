import java.util.ArrayList;
import java.util.List;

/* static library */
public final class MathUtility {

    /**
     * Euclidean algorithm is used to find the Greatest Common Divisor (GCD) between two numbers
     * @param a an integer
     * @param b another integer
     * @return the positive integer representing the GCD of the two input integers
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    /**
     * Return all the factors of a given number
     * @param num the given number to be divided (factored)
     * @return a list of numbers that divides the given number
     */
    public static List<Integer> factorsOf(int num)
    {
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                factors.add(num / i);
            }
        }
        factors.add(num);
        return factors;
    }

    /**
     * Perform synthetic division for one-variable polynomial and return result.
     * @param dividend the polynomial to be divided
     * @param divisor the "linear term + constant term" polynomial for divisor
     * @return a 2-tuple that contains the resulting polynomial and the remainder
     */
    public static SyntheticDivisionResult syntheticDivision(SingleVarPolynomial dividend, SingleVarLinearFactor divisor)
    {
        SingleVarPolynomial poly = null;
        Fraction remainder = null;



        return new SyntheticDivisionResult(poly, remainder);
    }

    /**
     * Store the result of a synthetic division as a 2-tuple.
     * Remainder's numerator equaling 0 implies divisibility!
     * @param poly the polynomial that results from the division
     * @param remainder the remainder (always a number, saved as fraction)
     */
    public record SyntheticDivisionResult(SingleVarPolynomial poly, Fraction remainder) {
        public boolean isDivisible() {
            return remainder().numerator() == 0;
        }
    }

}
