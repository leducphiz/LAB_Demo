
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static Map<Character, Integer> charCounter = new HashMap<Character, Integer>();
    private static Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the content: ");
        String txt = sc.nextLine();
        Count(txt);
        System.out.println(charCounter);
        System.out.println(wordCounter);
    }

    public static void Count(String txt) {
        for (char c : txt.toCharArray()) {
            // skip space
            if (Character.isSpaceChar(c)) {
                continue;
            }
            // check if map doesn't contain key C --> put c to map with one value
            if (!charCounter.containsKey(c)) {
                charCounter.put(c, 1);
            }else{
                //if map contain key c --> add more value
                charCounter.put(c, charCounter.get(c)+1);
            }
        }
        
        StringTokenizer token = new StringTokenizer(txt);
        while (token.hasMoreTokens()) {
            String word = token.nextToken();
            if (!wordCounter.containsKey(word)){
                wordCounter.put(word, 1);
            }else{
                wordCounter.put(word, wordCounter.get(word)+1);
            }
        }
    }

}
