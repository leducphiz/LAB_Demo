
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Validate {

    static final Scanner sc = new Scanner(System.in);
    static final String f = "^[0-9]{1,2}.[05][0]*|[0-9]{1,2}$";//[0-9]{1,2}.0

    public static int InputInt(String message) {
        int m;
        while (true) {
            try {
                System.out.print(message);
                m = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input, try again!");
            }
        }
        return m;
    }

    public static String InputString(String m) {
        while (true) {
            System.out.print(m);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else {
                return result;
            }
        }
    }

    public static String InputDate(String msg) {
        Date k;
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        while (true) {
            try {
                System.out.print(msg);
                k = s.parse(sc.nextLine());
                break;
            } catch (ParseException e) {
                System.err.println("Wrong format!");
            }
        }
        return s.format(k);
    }


    public static double InputPlan(String msg, double min) {
        double tmp;
        while (true) {
            try {
                System.out.print(msg);
                String x = sc.nextLine();
                if (x.matches(f)
                        && Double.parseDouble(x) >= min
                        && Double.parseDouble(x) <= 17.5) {
                    tmp = Double.parseDouble(x);
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input, try again!");
            }
        }
        return tmp;
    }

    

    public static int InputInRange(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    public static String InputTaskType(String m) {
        while (true) {
            System.out.print(m);
            int n = InputInRange(1, 4);
            String result = "";
            switch (n) {
                case 1:
                    result = "Code";
                    break;
                case 2:
                    result = "Test";
                    break;
                case 3:
                    result = "Design";
                    break;
                case 4:
                    result = "Review";
                    break;
            }
            return result;
        }
    }

    static Task getTaskByID(ArrayList<Task> list, int ID) {
        for (Task t : list) {
            if (t.getID() == ID) {
                return t;
            }
        }
        return null;
    }

}
