/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author PhiLe
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<Doctor>();
        while(true){
            int option = Manager.Menu();
            switch (option){
                case 1:
                    System.out.println("--------- Add Doctor ----------");
                    Manager.addDoctor(ld);
                    break;
                case 2:
                    System.out.println("--------- Update Doctor -------");
                    Manager.updateDoctor(ld);
                    break;
                case 3:
                    System.out.println("--------- Delete Doctor -------");
                    Manager.deleteDoctor(ld);
                    break;
                case 4:
                    System.out.println("---------- Search Doctor --------");
                    Manager.searchDoctor(ld);
                    break;
                case 5:
                    return;
            }
        }
    }
}
