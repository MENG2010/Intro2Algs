package edu.sc.cse.csce146.iteration;

/**
 * Created by meng on 1/5/17.
 */
public class Factorial {
    private Factorial() {

    }

    public static int factorial(int n) {
        return new Factorial().calculate(n);
    }

    private int calculate(int n) {
        int result = 1;

        while (n > 1) {
            result = result * n;
            --n;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println(n + "! = " + Factorial.factorial(n));
    }
}
