
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random r = new Random();

        int length = inputLength("Enter number of array: ");

        int s = inputInRange(-length, length, "Enter search value: ");

        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = r.nextInt(length);
        }

        System.out.println(Arrays.toString(arr));

        List<Integer> index = linearSearch(arr, s);
        System.out.println("Found " + s + " at index: " + (index.isEmpty() ? "Not found! " : index));

    }

    public static List<Integer> linearSearch(int[] arr, int s) {
        List<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == s) {
                index.add(i);
            }
        }
        return index;
    }

    public static int inputInRange(int min, int max, String m) {
        //loop until user input correct
        while (true) {
            try {
                System.out.print(m);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
            }
        }
    }

    private static int inputLength(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine());
                if (result > 0) {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input number integer greater than zero: ");
            }
        }
    }

}
