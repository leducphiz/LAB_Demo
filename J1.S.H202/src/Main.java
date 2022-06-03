
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PhiLe
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        if (txt.trim().isEmpty()) {
            System.err.println("empty str");
            return;
        }
        printReverse(txt);
    }
    public static void printReverse(String txt) {
        String r = "";
        for (int i = 0; i < txt.length(); i++) {
            r = txt.charAt(i) + r;
        }
        System.out.println(r);
    }
}
