// Linked HashMap

import java.util.LinkedHashMap;

public class topic4 {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);
        lhm.put("Nepal", 5);
        lhm.put("Indonesia", 6);

        for (String key : lhm.keySet()) {
            System.out.println("key : "+key+", value : "+lhm.get(key));
        }

        System.out.println(lhm);
    }
}
