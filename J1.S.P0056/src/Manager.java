
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PhiLe
 */
public class Manager {

    private static final String date = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

    static int Menu() {
        System.out.println("========= Worker Management ==========");
        System.out.println("1. Add ");
        System.out.println("2. Up");
        System.out.println("3. Down");
        System.out.println("4. Display");
        System.out.println("5. Exit");
        int option = Validate.checkRangeInt(1, 5, "Your option: ", "Please input 1 -> 5");
        return option;
    }

    static void addWorker(ArrayList<Worker> wList) {
        String code = "";
        while (true) {
            code = Validate.InputString("Code: ");
            if (Validate.getWorker(wList, code) == null) {
                break;
            } else {
                System.out.println("Code exist");
            }
        }
        String name = Validate.InputString("Name: ");
        int age = Validate.checkRangeInt(18, 50, "Age: ", "Age from 18 to 50. ");
        double salary = Validate.checkRangeDouble(0, Double.MAX_VALUE, "Salary: ", "Invalid");
        String location = Validate.InputString("Work location: ");
        wList.add(new Worker(code, name, age, salary, location));
        System.out.println("Add successful!");
    }

    static void updateWorker(ArrayList<Worker> wList, ArrayList<SalaryHistory> shList, int mode) {
        if (wList.isEmpty()) {
            System.err.println("List empty.");
        } else {
            String code = "";
            Worker w = null;
            double update = 0;
            code = Validate.InputString("Code: ");
            w = Validate.getWorker(wList, code);
            if (w != null) {
                if (mode == 1) {
                    //Up salary
                    update = Validate.checkRangeDouble(0, Double.MAX_VALUE, "Salary: ", "Must be greater than current salary.");
                    w.setSalary(update + w.getSalary());
                    shList.add(new SalaryHistory(w.getCode(), w.getName(), w.getAge(), w.getSalary(), "UP", date, w.getLocation()));
                    System.out.println("[UP} Done");
                } else if (mode == 2) {
                    //Down salary
                    update = Validate.checkRangeDouble(0, w.getSalary(), "Salary: ", "Must be smaller than current salary.");
                    w.setSalary(w.getSalary() - update);
                    shList.add(new SalaryHistory(w.getCode(), w.getName(), w.getAge(), w.getSalary(), "DOWN", date, w.getLocation()));
                    System.out.println("[DOWN] Done");
                };

            } else {
                System.out.println("code doesn't exist!");
            }
        }
    }

    static void display(ArrayList<SalaryHistory> shList) {
        if (shList.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-5s%-15s%-10s%-10s%-10s%-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
            Collections.sort(shList);
            for (SalaryHistory s : shList) {
                System.out.printf("%-5s%-15s%-10d%-10.1f%-10s%-20s\n", s.getCode(),
                        s.getName(), s.getAge(), s.getSalary(),
                        s.getStatus(), s.getDate());
            }
        }
    }
}
