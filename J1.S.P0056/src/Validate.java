
import java.util.ArrayList;
import java.util.Scanner;

public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    public static String InputString(String m) {
        while (true) {
            System.out.print(m);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            }
            return result;
        }
    }

    public static int checkRangeInt(int min, int max, String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }
    
    public static double checkRangeDouble(double min, double max, String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    static Worker getWorker(ArrayList<Worker> wList, String code) {
        for (Worker w : wList) {
            if (code.equalsIgnoreCase(w.getCode())) {
                return w;
            }
        }
        return null;
    }
    
    
}
