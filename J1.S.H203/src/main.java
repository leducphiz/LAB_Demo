
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
public class main {

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
        String[] tmp = txt.split(" ");
        String r = "";
        for (String s : tmp) {
            r = " " + s + r;
        }
        System.out.println(r);
    }

}
