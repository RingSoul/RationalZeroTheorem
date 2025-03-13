public record SingleVarLinearFactor(Fraction rationalZero) implements Comparable<SingleVarLinearFactor> {
    public String toString() {
        int numerator = rationalZero().numerator();
        int denominator = rationalZero().denominator();
        if (numerator == 0) return "x";
        String sign = (numerator > 0) ? "-" : "+";
        String coeff = (denominator == 1) ? "" : Integer.toString(denominator);
        return "(" + coeff + "x " + sign + " " + rationalZero().numerator() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SingleVarLinearFactor that = (SingleVarLinearFactor) obj;
        return rationalZero() == that.rationalZero();
    }

    @Override
    public int compareTo(SingleVarLinearFactor o) {
        double difference = rationalZero().toDouble() - o.rationalZero().toDouble();
        return (int) Math.ceil(difference);
    }
}
