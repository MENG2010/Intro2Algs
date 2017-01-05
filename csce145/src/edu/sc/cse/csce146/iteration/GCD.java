package edu.sc.cse.csce146.iteration;

/**
 * Created by meng on 1/5/17.
 */
public class GCD {

    private GCD() {

    }

    public static int gcd(int a, int b) {
        return new GCD().calculate(Math.max(a, b), Math.min(a, b));
    }

    private int calculate(int a, int b) {
        int tmp;

        while (b > 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }

    public static void main(String[] args) {
        int a = 21;
        int b = 63;

        System.out.println("GCD(" + a + ", " + b + ") = "
                + GCD.gcd(a, b));
    }
}
