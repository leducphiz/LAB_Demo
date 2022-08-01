/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bnsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Quang Anh
 */
public class BNsearch {

    /**
     * @param args the command line arguments
     */
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        BNsearch b = new BNsearch();
        Scanner s = new Scanner(System.in);
        int size;
        do {
            size = checkInt("Enter size: ");
            if (size <= 0) {
                System.out.println("Enter size >0");
            }
        } while (size <= 0);
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = new Random().nextInt(size );
        }
        sort(a);
        displayArray(a, "Sorted array: ");
        int Search = checkInt("Enter search value: ");
        b.BNsearch(a, Search, 0, size - 1);
        b.show(Search);
    }

    public static int checkInt(String message) {
        Scanner s = new Scanner(System.in);
        int m;
        // nhap so nguye m tu ban phim
        while (true) {
            try {
                System.out.println(message);
                m = Integer.parseInt(s.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
        return m;
    }

    public void BNsearch(int[] a, int value, int left, int right) {
        if (left > right) {
            return;
        }
        int middle = (left + right) / 2;
        if (a[middle] == value) {
            list.add(middle);
            int k = middle;
            while (k < a.length - 1 && a[k + 1] == value) {
                list.add(k + 1);
                k++;
            }
            k = middle;
            while (k > 0 && a[k - 1] == value) {
                list.add(k - 1);
                k--;
            }
        } else if (a[middle] > value) {
            BNsearch(a, value, left, middle - 1);
        } else {
            BNsearch(a, value, middle + 1, right);
        }
    }

    public static void displayArray(int[] a, String mess) {
        System.out.print(mess + " [");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length - 1] + "]");
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public void show(int Search) {
        if (list.isEmpty()) {
            System.out.println("Not found " + Search + " in array");
            return;
        }
        System.out.print("Found " + Search + " is index: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
    }
}
