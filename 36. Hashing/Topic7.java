// iteration on HashSet

import java.util.*;

public class Topic7 {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Mumbai");
        cities.add("Kolkata");
        cities.add("Bengaloru");

        System.out.println(cities);

        // Iterator
        Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // for-each
        for(String city : cities){
            System.out.println(city);
        }
    }
}
