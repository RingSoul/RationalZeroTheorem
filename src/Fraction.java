public class Fraction {

    private int numerator;
    private int denominator;
    private Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction with(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("The denominator of a fraction cannot be zero.");
        return new Fraction(numerator, denominator);
    }

    public int numerator() {
        return numerator;
    }

    public int denominator() {
        return denominator;
    }

    public Fraction add(Fraction frac) {
        int newDenominator = (denominator() == frac.denominator()) ?
                denominator() : denominator() * frac.denominator();
        int newNumerator = (newDenominator == denominator()) ?
                numerator() + frac.numerator() :
                numerator() * frac.denominator() + frac.numerator() * denominator();
        return new Fraction(newNumerator, newDenominator).simplify();
    }

    public Fraction multiply(Fraction scalar) {
        return new Fraction(
                scalar.numerator() * numerator(),
                scalar.denominator() * denominator()
        ).simplify();
    }

    private Fraction simplify() {
        return null;
    }

    public double toDouble() {
        return (double) numerator() / denominator();
    }

}
