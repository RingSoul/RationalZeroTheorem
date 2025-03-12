public record SingleVarPolyFactor(Fraction rationalZero) implements Comparable<SingleVarPolyFactor> {
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public String toString() {
        int numerator = rationalZero().numerator();
        int denominator = rationalZero().denominator();
        if (numerator == 0) return "x";
        String sign = (numerator > 0) ? "-" : "+";
        String coeff = (denominator == 1) ? "" : Integer.toString(denominator);
        return "(" + coeff + "x " + sign + " " + rationalZero().numerator() + ")";
    }

    @Override
    public int compareTo(SingleVarPolyFactor o) {
        double difference = rationalZero().toDouble() - o.rationalZero().toDouble();
        return (int) Math.ceil(difference);
    }
}
