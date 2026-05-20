import java.util.*;

public final class SingleVarPolynomial extends RZTFactor {
    private SortedSet<SingleVarMonomial> terms;

    public SingleVarPolynomial() {
        super(0);
        this.terms = new TreeSet<>(Comparator.reverseOrder());
    }

    private SortedSet<SingleVarMonomial> getTerms() {
        return terms;
    }

    private int getPolyDegree() {
        return super.getDegree();
    }

    private void setPolyDegree(int polyDegree) {
        super.setDegree(polyDegree);
    }

    public String toString() {
        return null;
    }

    public void add(SingleVarMonomial term) {
        Objects.requireNonNull(term);
        int higherDegree = Math.max(term.getDegree(), getPolyDegree());
        setPolyDegree(higherDegree);
        getTerms().add(term);
    }

    public void add(SingleVarPolynomial poly) {
        Objects.requireNonNull(poly);
        int higherDegree = Math.max(poly.getPolyDegree(), getPolyDegree());
        setPolyDegree(higherDegree);
        for (SingleVarMonomial term : poly.getTerms()) {
            getTerms().add(term);
        }
    }

    public List<SingleVarMonomial> standardForm() {
        List<SingleVarMonomial> polynomial = new ArrayList<>(getPolyDegree() + 1);
        int current = getPolyDegree();
        SingleVarMonomial temp = SingleVarMonomial.with(0, current);
        for (SingleVarMonomial term : getTerms()) {
            if (term.getDegree() == current) temp = temp.add(term);
            else {
                polynomial.add(temp);
                temp = SingleVarMonomial.with(0, --current);
            }
        }
        return polynomial;
    }

    public List<RZTFactor> factoredForm() {
        return null;
    }

}
