import java.util.Objects;

public class SingleVarSimplifiedBinomial extends RZTFactor {

    private SingleVarMonomial leadingTerm;
    private SingleVarMonomial constant;
    private Fraction rationalZero;

    private SingleVarLinearFactor(int linearCoefficient, int constant) {
        super();
        this.linearCoefficient = linearCoefficient;
        this.constant = constant;
        this.rationalZero = Fraction.with(constant, linearCoefficient);
    }

    public static SingleVarLinearFactor with(int linearCoefficient, int constant) {
        if (linearCoefficient == 0) throw new IllegalArgumentException("The linear coefficient cannot be 0.");
        return new SingleVarLinearFactor(linearCoefficient, constant);
    }

    public static SingleVarLinearFactor with(Fraction rationalZero) {
        Objects.requireNonNull(rationalZero);
        return with(rationalZero.denominator(), rationalZero.numerator());
    }

    public int linearCoefficient() {
        return linearCoefficient;
    }

    public int constant() {
        return constant;
    }

    public Fraction rationalZero() {
        return rationalZero;
    }

    @Override
    public String toString() {
        if (constant() == 0) return "x";
        String sign = (constant() > 0) ? "-" : "+";
        String coeff = (linearCoefficient() == 1) ? "" : Integer.toString(linearCoefficient());
        return coeff + "x" + sign + rationalZero().numerator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SingleVarLinearFactor that = (SingleVarLinearFactor) obj;
        return rationalZero() == that.rationalZero();
    }
}
