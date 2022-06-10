/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1.s.p0071;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author PiPi
 */
public class J1SP0071 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        TaskView tV = new TaskView();
        TaskController tC = new TaskController();
        int choice;
        
        while (true) {
            do {
                System.out.println("==============Task program==============");
                System.out.println("1. Add task");
                System.out.println("2. Delete task");
                System.out.println("3. Display task");
                System.out.println("4. Exit");
                System.out.print("Enter your choice:");
                choice = sc.nextInt();
            } while (choice < 1 || choice > 4);

            switch (choice) {
                case 1:
                    tV.enteredTaskInformation();
                    break;
                case 2:
                    tV.deleteTaskView();
                    break;
                case 3:
                    tV.getDataTasks();
                    break;
                case 4:
                    break;
            }
            if (choice == 4) {
                return;
            }
        }
    }
    
}
