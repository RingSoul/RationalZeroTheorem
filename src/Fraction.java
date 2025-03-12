public record Fraction(int numerator, int denominator) {

    public Fraction add(Fraction frac) {
        return null;
    }

    public Fraction multiply(Fraction scalar) {
        return null;
    }

    public double toDouble() {
        return (double) numerator() / denominator();
    }
}
