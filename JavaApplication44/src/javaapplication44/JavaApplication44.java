/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication44;

/**
 *
 * @author PhiLe
 */
public class JavaApplication44 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fun(10);
    }

    static void fun(int n) {
        int m = n / 2;
        int k = n % 2;
        if (m > 0) {
            fun(m);
        }
        System.out.print(k + " ");
    }

}
