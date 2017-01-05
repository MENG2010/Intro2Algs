package edu.sc.cse.csce146.recursion;

/**
 * Created by meng on 1/4/17.
 */
public class GCD {
    private GCD() {

    }

    public static int gcd(int a, int b) {
        return new GCD().calculate(Math.max(a, b), Math.min(a, b));
    }

    private int calculate(int a, int b) {
        if (b <= 0) {
            return a;
        } else {
            return calculate(b, a % b);
        }
    }

    public static void main(String[] args) {
        int a = 24;
        int b = 10;

        System.out.println("GCD(" + a + ", " + b + ") = " + GCD.gcd(a, b));
    }
}
