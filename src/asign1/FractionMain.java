package asign1;

/**
 * Created by hampus on 2016-09-09.
 */
public class FractionMain {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(5, 8);
        Fraction f2 = new Fraction(5, 8);

        System.out.println("Printing numerator & denominator!");
        System.out.println("Fraction1 Numerator: " + f1.getNum() + "\nFraction1 Denominator: " + f1.getDen());
        System.out.println("-----------------");
        System.out.println("Fraction2 Numerator: " + f2.getNum() + "\nFraction2 Denominator: " + f2.getDen());

        System.out.println("\nSee if fraction is negative");
        System.out.println("True/False: " + f1.isNegative());

        System.out.println("\nAdd fraction");
        System.out.println(f1.add(f2).toString());

        System.out.println("\nSub fraction");
        System.out.println(f1.subtract(f2).toString());

        System.out.println("\nMultiply fraction");
        System.out.println(f1.multiply(f2).toString());

        System.out.println("\nDivide fraction");
        System.out.println(f1.divide(f2).toString());

        System.out.println("\nEqual fraction");
        System.out.println(f1.isEqualTo(f2));
    }
}
