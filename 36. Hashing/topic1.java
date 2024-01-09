// hashmap

import java.util.HashMap;

public class topic1{
    public static void main(String[] args) {
        // creat
        HashMap<String,Integer> hm= new HashMap<>();

        // Insert   O(1)
        hm.put("China", 150);
        hm.put("India", 100);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        // print    O(1)
        System.out.println(hm);

        // contaninsKey()   O(1)
        System.out.println(hm.containsKey("India"));    // true
        System.out.println(hm.containsKey("Bhutan"));   // false
        
        // get  O(1)
        int population = hm.get("India");
        System.out.println(population);

        // remove   O(1)
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));    // null as India is not a key 

        System.out.println(hm);

        // size()
        System.out.println(hm.size());

        System.out.println(hm.isEmpty());

        hm.clear();
        System.out.println(hm.isEmpty());
    }
}