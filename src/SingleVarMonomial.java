import java.util.Objects;

public class SingleVarMonomial implements Comparable<SingleVarMonomial> {
    private int coefficient;
    private int degree;

    private SingleVarMonomial(int coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public static SingleVarMonomial with(int coefficient, int degree) {
        if (degree < 0) throw new IllegalArgumentException("A monomial's degree cannot be negative.");
        return new SingleVarMonomial(coefficient, degree);
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getDegree() {
        return degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleVarMonomial that = (SingleVarMonomial) o;
        return getDegree() == that.getDegree()
                && getCoefficient() == that.getCoefficient();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoefficient(), getDegree());
    }

    @Override
    public String toString() {
        return getCoefficient() + "x^{" + getDegree() + "}";
    }

    @Override
    public int compareTo(SingleVarMonomial o) {
        return this.getDegree() - o.getDegree();
    }

    public SingleVarMonomial add(SingleVarMonomial o) {
        if (this.compareTo(o) != 0) throw new IllegalArgumentException("Monomials of two different degrees cannot be added together.");
        int newCoeff = getCoefficient() + o.getCoefficient();
        return with(newCoeff, getDegree());
    }
}
