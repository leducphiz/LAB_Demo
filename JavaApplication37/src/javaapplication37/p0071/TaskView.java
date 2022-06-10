package j1.s.p0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskView {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    TaskController tC = new TaskController();
    Validation validate = new Validation();
    Date date;

    public void enteredTaskInformation(){
        int taskType = 0;
        String requirementName;
        String dateString;
        String assignee;
        String reviewer;
        float planFrom = 0;
        float planTo = 0;
        boolean isDateValid;
        boolean isPlanTimeValid;

        System.out.println("-------------Add task-------------");
        System.out.println("Requirement name:");
        requirementName = sc.nextLine();

        do {
            try {
                System.out.println("Task Type(1.Code, 2.Test, 3.Design, 4.Review):");
                taskType = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number!");
                sc.next();
            }

        } while (taskType < 1 || taskType > 4);
        sc.nextLine();

        do {
            try {
                System.out.println("Date:");
                dateString = sc.nextLine();
                formatter.setLenient(false);
                date = formatter.parse(dateString);
                isDateValid = true;
            } catch (ParseException e) {
                System.out.println("Please follow this format dd-MM-yyyy!");
                isDateValid = false;
            }
        } while (!isDateValid);

        do {
            try {
                System.out.println("From:");
                planFrom = sc.nextFloat();
                System.out.println("To:");
                planTo = sc.nextFloat();
                if (validate.checkPlanTime(planFrom, planTo)) {
                    isPlanTimeValid = true;
                } else {
                    System.out.println("Your planFrom must be less than planTo and planTo and planFrom within 8 -> 17.5. Please try again!");
                    isPlanTimeValid = false;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number!");
                isPlanTimeValid = false;
                sc.next();
            }
        } while (!isPlanTimeValid);
        sc.nextLine();

        System.out.println("Assignee:");
        assignee = sc.nextLine();
        System.out.println("Reviewer:");
        reviewer = sc.nextLine();
        tC.addTask(taskType, requirementName, date, planFrom, planTo, assignee, reviewer);
    }

    public void deleteTaskView() {
        String ID;
        boolean isValid;
        System.out.println("-------------Delete task-------------");
        if (tC.getList().isEmpty()) {
            System.out.println("There are no task in list.");
            return;
        }
        do {
            System.out.println("ID:");
            ID = sc.nextLine();
            isValid = true;
            if (ID.length() == 0) {
                isValid = false;
                System.out.println("Please enter ID!");
            }
        } while (!isValid);

        tC.deleteTask(ID);

    }

    public void getDataTasks() {
        String[] tasks = {"Code", "Test", "Design", "Review"};
        System.out.println("-----------------------------Task-----------------------------");
        if (tC.getList().isEmpty()) {
            System.out.println("There are no task in list.");
            return;
        }
        System.out.println("ID\t\tName\t\tTask Type\t\tDate\t\tTime\t\tAssignee\t\tReviewer");
        for (Task task : tC.getList()) {
            System.out.println(task.getID() 
                    + "\t\t" + task.getRequirementName() 
                    + "\t\t" + tasks[task.getTaskID() - 1]
                    + "\t\t" + formatter.format(task.getDate()) 
                    + "\t\t"+ (task.getPlanTo() - task.getPlanFrom())
                    + "\t\t" + task.getAssignee() 
                    + "\t\t" + task.getReviewer());
        }
    }
}
