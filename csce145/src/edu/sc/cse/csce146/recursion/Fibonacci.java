package edu.sc.cse.csce146.recursion;

/**
 * Created by meng on 1/4/17.
 */
public class Fibonacci {
    private Fibonacci() {
    }

    public static int fib(int n) {
        return new Fibonacci().generate(n);
    }

    private int generate(int n) {
        if (n <= 0) {
            System.out.print(n + " ");
            return 0;
        } else if (n <= 2) {
            System.out.print(n + " ");
            return 1;
        } else {
            System.out.print(n + " ");
            return generate(n - 1) + generate(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 9;

        System.out.println("\nfib(" + n + ") = " + Fibonacci.fib(n));
    }
}
