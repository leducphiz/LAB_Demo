
import java.util.ArrayList;

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

    static int ID = 1;

    public static void addTask(ArrayList<Task> list) {
        System.out.println("--------------Add Task------------");
        String Name = Validate.InputString("Name: ");
        String TaskType = Validate.InputTaskType("Task Type: ");
        String Date = Validate.InputDate("Date: ");
        double PlanFrom = Validate.InputPlan("From: ", 8.0);
        double Planto = Validate.InputPlan("To: ", PlanFrom);
        String Assignee = Validate.InputString("Assignee: ");
        String Reviewer = Validate.InputString("Reviewer: ");
        list.add(new Task(ID, Name, TaskType, Date, PlanFrom, Planto, Assignee, Reviewer));
        ID++;
        System.out.println("Add successful !");
    }

    public static void delTask(ArrayList<Task> list) {
        System.out.println("---------Del Task----------");
        while (true) {
            int xID = Validate.InputInt("Enter ID: ");
            Task task = Validate.getTaskByID(list, xID);
            if (task == null) {
                System.err.println("ID does not exist.");
                continue;
            } else {
                list.remove(task);
                System.out.println("Delete successful!");
                
                break;
            }
        }
    }

    public static void getDataTasks(ArrayList<Task> list) {
        System.out.println("-----------------------------------Task--------------------------------------");
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        } else {
            System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
            for (Task t : list) {
                System.out.printf(
                        "%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                        t.getID(), t.getName(), t.getTaskTypeID(), t.getDate(), t.getTime(), t.getAssignee(), t.getReviewer());
            }
        }
    }
}
