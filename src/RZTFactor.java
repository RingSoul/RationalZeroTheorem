public sealed class RZTFactor permits SingleVarMonomial, SingleVarPolynomial  {

    private int degree;

    protected RZTFactor(int degree) {
        this.degree = degree;
    }

    protected int getDegree() {
        return degree;
    }

    protected void setDegree(int degree) {
        this.degree = degree;
    }
}
