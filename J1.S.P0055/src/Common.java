
import java.util.ArrayList;
import java.util.Scanner;



public class Common {

    private final static Scanner in = new Scanner(System.in);

    //check user input number limit
    public static int checkRange(int min, int max, String m ) {
        //loop until user input correct
        while (true) {
            try {
                System.out.print(m);
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    //check user input string
    public static String checkInputString(String m) {
        //loop until user input correct
        while (true) {
            System.out.print(m);
            String result = in.nextLine().trim();
            return result;
        }
    }
    //check user input string
    public static String checkInputStringNotEmpty(String m) {
        //loop until user input correct
        while (true) {
            System.out.print(m);
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }


    //check user input int
    public static int checkInputInt(String m) {
        //loop until user input correct
        while (true) {
            try {
                System.out.print(m);
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }
    public static String inputIntOrEmpty(String m) {
        //loop until user input correct
        while (true) {
            try {
                 System.out.print(m);
                 String s = in.nextLine().trim();
                 if(s.isEmpty()) return s;
                int result = Integer.parseInt(s);
                return s;
            } catch (NumberFormatException e) {
                System.out.println("Please input int or empty!");
            }
        }
    }



    //check code exist or not
    public static Doctor getDocbyCode(ArrayList<Doctor> ld, String code) {
        //check from first to last list doctor
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return doctor;
            }
        }
        return null;
    }

    //check doctor duplicate
    public static boolean checkDuplicate(ArrayList<Doctor> ld, String code,
            String name, String specialization, int availability) {
        //check from first to last list doctor
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode()) && name.equalsIgnoreCase(doctor.getName()) && specialization.equalsIgnoreCase(doctor.getSpecialization())  && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }

    //check user change information or not
    public static boolean checkChangeInfo(Doctor doctor,
            String name, String specialization, String availability) {
        if ( (doctor.getName().equalsIgnoreCase(name) || name.isEmpty())
                && (doctor.getSpecialization().equalsIgnoreCase(specialization) || specialization.isEmpty())
                && ( availability.isEmpty() || doctor.getAvailability() == Integer.parseInt(availability))) {
            return false;
        }
        return true;
    }

    public static boolean checkCodeExist(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }
}