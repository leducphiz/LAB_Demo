
import java.util.ArrayList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Worker> wList = new ArrayList<>();
        ArrayList<SalaryHistory> shList = new ArrayList<>();
        while (true) {
            int option = Manager.Menu();
            switch (option) {
                case 1:
                    System.out.println("--------- Add Worker ----------");
                    Manager.addWorker(wList);
                    break;
                case 2:
                    System.out.println("--------- Up -------");
                    Manager.updateWorker(wList, shList, 1);
                    break;
                case 3:
                    System.out.println("--------- Down -------");
                    Manager.updateWorker(wList, shList, 2);
                    break;
                case 4:
                    System.out.println("---------- Display --------");
                    Manager.display(shList);
                    break;
                case 5:
                    return;
            }
        }
    }

}
