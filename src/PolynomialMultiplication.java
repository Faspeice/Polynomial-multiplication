import java.util.ArrayList;
import java.util.List;

public class PolynomialMultiplication {

    public static List<Integer> multiplyPolynomials(List<Integer> poly1, List<Integer> poly2) {
        int degree1 = poly1.size();
        int degree2 = poly2.size();
        List<Integer> result = new ArrayList<>(degree1 + degree2 - 1);

        for (int i = 0; i < degree1 + degree2 - 1; i++) {
            result.add(0);
        }

        for (int i = 0; i < degree1; i++) {
            for (int j = 0; j < degree2; j++) {
                result.set(i + j, result.get(i + j) + poly1.get(i) * poly2.get(j));
            }
        }
        return result;
    }

    public static void printPolynomial(List<Integer> poly) {
        int n = poly.size();
        for (int i = 0; i < n; i++) {
            int coeff = poly.get(i);
            if (coeff == 0) continue;

            if (i != 0 && coeff > 0) System.out.print(" + ");

            if (i == 0 || coeff != 1) {
                System.out.print(coeff);
            }

            if (i > 0) {
                System.out.print("x");
                if (i > 1) System.out.print("^" + i);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> poly1 = List.of(2, 3, 4);

        List<Integer> poly2 = List.of(1, 2);

        List<Integer> result = multiplyPolynomials(poly1, poly2);

        System.out.println("First polynomial is:");
        printPolynomial(poly1);
        System.out.println("Second polynomial:");
        printPolynomial(poly2);
        System.out.println("Product polynomial:");
        printPolynomial(result);
    }
}
