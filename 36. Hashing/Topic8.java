// LinkedHashSet

import java.util.LinkedHashSet;

public class Topic8 {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();

        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Mumbai");
        cities.add("Kolkata");
        cities.add("Bengaloru");

        System.out.println(cities);

        cities.remove("Noida");
        System.out.println(cities);
    }
}
