package Monostate;

import java.util.HashMap;
import java.util.Map;

class Monostate {
    private static Map<String, Integer> hm = new HashMap<>();

    void addEntry(String s, Integer n) {
        hm.put(s, n);
    }

    void getEntries() {
        for (Map.Entry<String, Integer> me : hm.entrySet()) {

            // Printing keys
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }
    }

}

public class MonostatePattern {

    public static void main(String[] args) {
        Monostate monostate = new Monostate();
        monostate.addEntry("grimm", 123);
        Monostate monostate2 = new Monostate();

        monostate2.addEntry("huber", 456);
        monostate.getEntries();
    }
}
