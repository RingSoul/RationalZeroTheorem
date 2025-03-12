public class Factor {
    private Fraction solution;

    public Fraction getSolution() {
        return solution;
    }

    public void setSolution(Fraction solution) {
        this.solution = solution;
    }

    public String toString() {
        if (getSolution().denominator() == 1) {
            return "()";
        } else {
            return "(";
        }
    }
}
