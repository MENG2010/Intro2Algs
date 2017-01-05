package edu.sc.cse.csce146.recursion;

/**
 * Created by meng on 1/4/17.
 */
public class Factorial {
    private Factorial() {

    }

    public static int fac(int n) {
        return new Factorial().generator(n);
    }

    private int generator(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return n * generator(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(n + "! = " + Factorial.fac(n));
    }
}
