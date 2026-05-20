public final class Fraction extends RZTFactor {

    private int numerator;
    private int denominator;

    private Fraction(int numerator, int denominator) {
        super(0);
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction with(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("The denominator of a fraction cannot be zero.");
        return new Fraction(numerator, denominator);
    }

    public static Fraction of(int number) {
        return new Fraction(number, 1);
    }

    public int numerator() {
        return numerator;
    }

    public int denominator() {
        return denominator;
    }

    public Fraction add(Fraction frac) {
        int newNumerator = 0,  newDenominator = 0;
        if (denominator() == frac.denominator()) {
            newDenominator = denominator();
            newNumerator = numerator() +  frac.numerator();
        }
        else {
            newDenominator = denominator() * frac.denominator();
            newNumerator = numerator() * frac.denominator()
                    + frac.numerator() * denominator();
        }
        return Fraction.with(newNumerator, newDenominator).simplify();
    }

    public Fraction multiply(Fraction frac) {
        return Fraction.with(
                frac.numerator() * numerator(),
                frac.denominator() * denominator()
        ).simplify();
    }

    private Fraction simplify() {
        int gcd = MathUtility.gcd(numerator(), denominator());
        return Fraction.with(numerator() / gcd, denominator() / gcd);
    }

    public double toDouble() {
        return (double) numerator() / denominator();
    }

}
