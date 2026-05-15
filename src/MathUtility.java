import java.util.ArrayList;
import java.util.List;

public final class MathUtility {

    public static int gcd(int a, int b) {
        return 0;
    }

    public static List<Integer> factorsOf(int num)
    {
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0) factors.add(i);
        factors.add(num);
        return factors;
    }

    public static Object syntheticDivision()
    {
        return null;
    }

}
