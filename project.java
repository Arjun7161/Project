
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class project {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter  a  Sentence: ");
            String str = sc.nextLine();

            System.out.println("total characters: " + str.length());
            char ch;
            int count;

            TreeMap<Character, Integer> m = new TreeMap<Character, Integer>();

            str = str.replaceAll(" ", "");
            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (m.containsKey(ch)) {
                    count = m.get(ch);
                    count++;
                    m.replace(ch, count);
                } else {
                    m.put(ch, 1);
                }

            }

            for (Character key : m.keySet()) {
                System.out.println(key + " =" + m.get(key));
            }
        }

    }

}
