/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fibonacci;

/**
 *
 * @author PhiLe
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci");
        fibo(45, 1, 0);
    }

    public static int fibo(int term, int lower, int higher) {
        if (term < 1) {
            return higher;
        }
        System.out.print(higher + " ");
        return fibo(term - 1 , higher, higher + lower);
    }
}
