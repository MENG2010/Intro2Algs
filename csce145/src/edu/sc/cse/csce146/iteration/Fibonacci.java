package edu.sc.cse.csce146.iteration;

/**
 * Created by meng on 1/5/17.
 */
public class Fibonacci {
    private Fibonacci() {

    }

    public static int fib(int n) {
        return new Fibonacci().calculate(n);
    }

    private int calculate(int n) {
        int pre1 = 1;
        int pre2 = 1;
        int result = 0;

        if (n <= 1) {
            result = pre2;
        } else if (n == 2) {
            result = pre1;
        } else {
            while (n > 2) {
                result = pre1 + pre2;
//                System.out.println(n + ": " + result + ", " + pre1 + ", " + pre2);
                pre2 = pre1;
                pre1 = result;
                --n;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 20;

        System.out.println("fib(" + n + ") = " + Fibonacci.fib(n));
    }
}
