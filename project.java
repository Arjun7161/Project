import java.util.HashMap;
import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  a  Sentence: ");
        String str = sc.nextLine();
        str = str.replaceAll(" ", "");
        char ch;
        int count;
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
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
        System.out.println("total characters: " + str.length());
        for (Character key : m.keySet()) {
            System.out.println(key + " =" + m.get(key));
        }

    }

}
