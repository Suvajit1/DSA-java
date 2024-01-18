import java.util.TreeSet;

public class Topic9 {
    public static void main(String[] args) {
        TreeSet<String> cities = new TreeSet<>();

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
