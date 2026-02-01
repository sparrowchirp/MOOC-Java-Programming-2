
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }

    public static void printKeys(HashMap<String,String> hashmap) {
        for (String temp : hashmap.keySet()) {
            System.out.println(temp);
        }
    }
    public static void printKeysWhere(HashMap<String,String> hashmap, String text) {
        for (String temp : hashmap.keySet()) {
            if (temp.contains(text)) {
                System.out.println(temp);
            }
        }

    }
    public static void printValuesOfKeysWhere(HashMap<String,String> hashmap, String text) {
        for (String temp : hashmap.keySet()) {
            if (temp.contains(text)) {
                System.out.println(hashmap.get(temp));
            }
        }
    }

}
