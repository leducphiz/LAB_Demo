/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication41;

/**
 *
 * @author PhiLe
 */
public class JavaApplication41 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] a = {2,4,6,8,10,12,14, 16};
        fun(33);
    }
    
    public static void fun(int n){
        if (n > 0) {
            System.out.println(" " + n%5);
            fun(n);
        }
    }

    int binarySearch(int[] a, int x, int low, int high) {
        int t, k;

        if (low > high) {
            return (-1);
        }

        k = (low + high) / 2;

        if (a[k] == x) {
            return (k);
        }

        if (x < a[k]) {
            return binarySearch(a, x, low, k - 1);
        } else {
            return binarySearch(a, x, k + 1, high);
        }

    }

}
