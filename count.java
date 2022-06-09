
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class count {

    public static void main(String[] args)
            throws IOException {
        File file = new File("C:\\Users\\Arjun\\Desktop\\Textfile.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Scanner sc = new Scanner(new File("C:\\Users\\Arjun\\Desktop\\Textfile.txt"));
        String str = sc.nextLine();

        String line;
        int wordCount = 0;
        int characterCount = 0;
        int paraCount = 0;
        int whiteSpaceCount = 0;
        int cha, count;
        char ch;

        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                paraCount += 1;
            } else {
                characterCount += line.length();
                String words[] = line.split("\\s+");

                wordCount += words.length;
                whiteSpaceCount += wordCount - 1;

            }
        }
        cha = characterCount - whiteSpaceCount;

        System.out.println("Total number of characters = " + cha);
        TreeMap<Character, Integer> m = new TreeMap<Character, Integer>();
        str = str.replaceAll(" ", "");
        System.out.println("total characters: " + str.length());
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (!String.valueOf(ch).isBlank())
                if (m.containsKey(ch)) {
                    count = m.get(ch);
                    count++;
                    m.replace(ch, count);
                } else {
                    m.put(ch, 1);
                }

        }

        for (Character key : m.keySet()) {

            // System.out.println(key + " =" + m.get(key));
        }
        Set<Entry<Character, Integer>> entrySet = m.entrySet();
        List<Entry<Character, Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
            @Override
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        list.forEach(s -> {
            System.out.println(s.getKey() + "\t" + s.getValue());
        });

        ArrayList<Character> keyList = new ArrayList<Character>(m.keySet());

        // Extract the values from the TreeMap
        // using TreeMap.values() and
        // assign them to valueList of type ArrayList
        ArrayList<Integer> valueList = new ArrayList<Integer>(m.values());

        // printing the keyList
        // System.out.println(
        // "List of keys of the given Map : " + keyList);

        // printing the valueList
        // System.out.println(
        // "List of values of the given Map : "
        // + valueList);

    }

}
