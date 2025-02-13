import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapPractice {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("Apple", 3.5);
        map.put("Banana", 2.0);
        map.put("Cherry", 4.0);
        map.put("Apple", 1.99);

        // let's print the map

        System.out.println(map);

        // what happens if we add a duplicate key?
        // your code here


        // now try it with Person/Student. We will
        // use the person or student as a key and the
        // value will be a set of classes they are taking

        Map<Person, Set<String>> classes = new HashMap<>();
        Set<String> s1 = Set.of("CS5001", "CS5002");
        Student sdt1 = new Student("Test", 123);
        Person pe2 = new Person("Name");

        // you will find Set.of() useful here
        // for example:
        classes.put(sdt1, s1);
        System.out.println(classes);
        classes.put(pe2, s1);
        System.out.println(classes);

        // Streams with Maps
        Map<String, Double> food = new HashMap<>();

        food.put("Apple", 3.5);
        food.put("Banana", 2.0);
        food.put("Cherry", 4.0);

        // .keySet().stream() or .values().stream() to get the stream of keys or values.
        // You can also use .entrySet().stream() to get a stream of key-value pairs.
        food.entrySet().stream().map(x -> x.getKey() + " costs " + x.getValue())
                .forEach(System.out::println);
        System.out.println("Food that costs more than 3.0");
        food.entrySet().stream().filter(x -> x.getValue() > 3.0)
                .map(x -> x.getKey() + " costs " + x.getValue())
                .forEach(System.out::println);

        // for loop in maps
        System.out.println("For each loop example");
        for(Map.Entry<String, Double> entry : food.entrySet()) {
            System.out.println(entry.getKey() + " costs " + entry.getValue());
        }

// or

        System.out.println("For each loop example");
        for(String key : food.keySet()) {
            System.out.println(key + " costs " + food.get(key));
        }

    }

}
