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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Task> list = new ArrayList<>();
        while (true) {
            System.out.println("========= Task Program ========");
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Your Option: ");
            int option = Validate.InputInRange(1, 4);
            switch (option) {
                case 1:
                    Manager.addTask(list);
                    break;
                case 2:
                    Manager.delTask(list);
                    break;
                case 3:
                    Manager.getDataTasks(list);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
