import java.util.ArrayList;

public class StringUtility {
    // static library
    // this method is a helper method used to extract the terms from a polynomial
    public static ArrayList<String> extractTerms(String polynomial)
    {
        ArrayList<String> terms = new ArrayList<String>();
        String[] expressions = polynomial.split("\\+"); // split by + sign
        String[][] allTerms = new String[expressions.length][];
        for (int i = 0; i < expressions.length; i++)
        {
            allTerms[i] = expressions[i].split("-"); // split by - sign
        }
        int plusIndex = polynomial.indexOf("+");
        int minusIndex = polynomial.indexOf("-");
        for (String[] someTerms : allTerms)
        {
            for (String term : someTerms)
            {

                terms.add(term);
            }
        }
        return terms;
    }

    // this method checks if a polynomial is validly inputted
    // valid = each extracted term contains only numbers, +/- sign, and ^
    public static boolean isValidPolynomial(String polynomial)
    {
        ArrayList<String> terms = extractTerms(polynomial); // extract terms by their +/- signs, then determine if valid
        for (String term : terms)
        {

        }
        return true;
    }


    // this method reorders the polynomial from highest degree to lowest degree
    // precondition: isValidPolynomial(polynomial) == true
    public static String reorderPolynomial(String polynomial)
    {
        String reorderedPolynomial = "";

        return reorderedPolynomial;
    }

    // this method extracts all integer coefficients of a polynomial and returns them
    // precondition: isValidPolynomial(polynomial) == true
    public static int[] extractCoefficients(String polynomial)
    {
        int size = 0;
        int index = polynomial.indexOf("x");
        while (index != -1)
        {
            size++;
            polynomial = polynomial.substring(index+1);
            index = polynomial.indexOf("x");
        }
        int[] coefficients = new int[size];


        return coefficients;
    }
}
