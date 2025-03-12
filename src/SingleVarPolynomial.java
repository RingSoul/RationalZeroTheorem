import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class SingleVarPolynomial {
    private SortedSet<SingleVarMonomial> terms;
    private int polyDegree;

    public SingleVarPolynomial() {
        this.terms = new TreeSet<>(Comparator.reverseOrder());
        this.polyDegree = 0;
    }

    private SortedSet<SingleVarMonomial> getTerms() {
        return terms;
    }

    private int getPolyDegree() {
        return polyDegree;
    }

    private void setPolyDegree(int polyDegree) {
        this.polyDegree = polyDegree;
    }

    public void add(SingleVarMonomial term) {
        int higherDegree = Math.max(term.getDegree(), getPolyDegree());
        setPolyDegree(higherDegree);
        getTerms().add(term);
    }

    public void add(SingleVarPolynomial poly) {
        int higherDegree = Math.max(poly.getPolyDegree(), getPolyDegree());
        setPolyDegree(higherDegree);
        for (SingleVarMonomial term : poly.getTerms()) {
            getTerms().add(term);
        }
    }

    public List<SingleVarMonomial> condensedForm() {
        List<SingleVarMonomial> polynomial = new ArrayList<>(getPolyDegree() + 1);
        int tracker = getPolyDegree();
        SingleVarMonomial temp = SingleVarMonomial.with(0, tracker);
        for (SingleVarMonomial term : getTerms()) {
            if (term.getDegree() == tracker) temp = temp.add(term);
            else {
                polynomial.add(temp);
                temp = SingleVarMonomial.with(0, --tracker);
            }
        }
        return polynomial;
    }
}
