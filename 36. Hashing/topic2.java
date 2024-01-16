// iterator on HashMap

import java.util.HashMap;
import java.util.Set;
public class topic2 {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Nepal", 5);
        hm.put("US", 50);

        System.out.println(hm);

        //iteration
        Set<String> keys=hm.keySet();
        
        for (String k : keys) {
            System.out.println("key = "+k+", value = "+hm.get(k));
        }

        System.out.println(keys);
    }
}
