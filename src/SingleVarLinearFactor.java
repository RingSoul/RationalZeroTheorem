import java.util.Objects;

public final class SingleVarLinearFactor extends RZTFactor {

    private SingleVarMonomial linearTerm;
    private SingleVarMonomial constant;
    private Fraction rationalZero;

    private SingleVarLinearFactor(SingleVarMonomial linearTerm, SingleVarMonomial constant) {
        super(1);
        this.linearTerm = linearTerm;
        this.constant = constant;
        this.rationalZero = Fraction.with(-1 * constant.getCoefficient(), linearTerm.getCoefficient());
    }

    public static SingleVarLinearFactor with(SingleVarMonomial linearTerm, SingleVarMonomial constant) {
        if (linearTerm.getDegree() != 1) throw new IllegalArgumentException
                ("The degree of the linear term must be 1.");
        if (constant.getDegree() != 0) throw new IllegalArgumentException
                ("The degree of the constant term must be 0.");
        return new SingleVarLinearFactor(linearTerm, constant);
    }

    public static SingleVarLinearFactor with(int linearCoefficient, int constant) {
        if (linearCoefficient == 0) throw new IllegalArgumentException
                ("The linear coefficient cannot be 0, else this factor is just an integer.");
        if (constant == 0) throw new IllegalArgumentException
                ("The constant term cannot be 0, else this factor just indicates a root of 0.");
        SingleVarMonomial linearTerm = SingleVarMonomial.with(linearCoefficient, 1),
                constantMonomial = SingleVarMonomial.with(constant, 0);
        return new SingleVarLinearFactor(linearTerm, constantMonomial);
    }

    public static SingleVarLinearFactor with(Fraction rationalZero) {
        Objects.requireNonNull(rationalZero);
        return with(rationalZero.denominator(), -1 * rationalZero.numerator());
    }

    public SingleVarMonomial getLinearTerm() {
        return linearTerm;
    }

    public SingleVarMonomial getConstant() {
        return constant;
    }

    public Fraction getRationalZero() {
        return rationalZero;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SingleVarLinearFactor that = (SingleVarLinearFactor) obj;
        return getRationalZero() == that.getRationalZero();
    }


}
