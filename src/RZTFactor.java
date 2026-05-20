public sealed abstract class RZTFactor
        permits Fraction, SingleVarMonomial, SingleVarLinearFactor, SingleVarPolynomial  {

    private int degree;

    public RZTFactor(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
