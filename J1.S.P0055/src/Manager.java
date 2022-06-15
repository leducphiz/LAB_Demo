
import java.util.ArrayList;

public class Manager {

    //display menu
    public static int Menu() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
        int option = Common.checkRange(1, 5, "Your option: ");
        return option;
    }

    //add doctor
    public static void addDoctor(ArrayList<Doctor> ld) {
        String Code = "";
        //check exist code
        while (true) {
            Code = Common.checkInputString("Enter Code: ");
            if (Common.checkCodeExist(ld, Code)) {
                break;
            } else {
                System.out.println("Code exist.");
            }
        }

        String Name = Common.checkInputString("Enter Name: ");
        String Specialization = Common.checkInputString("Enter Specialization:");
        int Availability = Common.checkInputInt("Enter Availability: ");

        //check Duplicate
        if (!Common.checkDuplicate(ld, Code, Name, Specialization, Availability)) {
            System.out.println("Duplicate. ");
            return;
        }

        ld.add(new Doctor(Code, Name, Specialization, Availability));
        System.out.println("Add successful");
    }

    //update doctor
    public static void updateDoctor(ArrayList<Doctor> ld) {
        String Code = "";
        Doctor doctor = null;
        while (true) {
            Code = Common.checkInputString("Enter Code: ");
            doctor = Common.getDocbyCode(ld, Code);
            if (doctor != null) {
                break;
            } else {
                System.out.println("Doctor code does not exist.");
            }
        }
        String name = Common.checkInputString("Enter name: ");
        String specialization = Common.checkInputString("Enter specialization: ");
        String availability = Common.checkInputString("Enter availability: ");

        //check change info
        if (!Common.checkChangeInfo(doctor, name, specialization, availability)) {
            System.out.println("No change");
            return;
        }

        //update new doctor
        doctor.setName(name.isEmpty() ? doctor.getName() : name);
        doctor.setSpecialization(specialization.isEmpty() ? doctor.getSpecialization() : specialization);
        doctor.setAvailability(availability.isEmpty() ? doctor.getAvailability() : Integer.parseInt(availability));
        System.out.println("Update successful");

    }

    // delete doctor
    public static void deleteDoctor(ArrayList<Doctor> ld) {
        String code = Common.checkInputString("Enter Code");
        Doctor doctor = getDocByCode(ld, code);
        if (doctor == null) {
            System.out.println("code does not exist Doctor");
            return;
        } else {
            ld.remove(doctor);
        }
        System.out.println("Delete successful.");
    }

    // search doctor
    public static void searchDoctor(ArrayList<Doctor> ld) {
        String nameSearch = Common.checkInputString("Enter name: ");
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, nameSearch);

        //check empty list
        if (listFoundByName.isEmpty()) {
            System.out.println("List empty");
        } else {
            System.out.println("--------- Result ------------");
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }

    }

    //get doctor by code
    public static Doctor getDocByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    //get list found by name
    public static ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
