package com.kbm.java.practise.recursion;

/**
 * Recursive implementation of factorial function
 * @author Keyur Mahajan
 */
public class Factorial {


    public static void main(String[] args) {
        System.out.println(fact(4));
    }

    public static int fact(int n) {
        if ( n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
