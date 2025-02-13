
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

// yes we used all the above in the solution. You
// may not use them all, that is fine.


/**
 * a few java syntax items to help you out. Depending on how you do it, you may not need them
 * 
 * /
 * 
 * /* String[] parts = line.split("\\s+"); // split by whitespace String student = parts[0]; String
 * course = parts[1];
 */

/**
 * Set.of() creates an immutable set!, So if you want it mutable.
 * 
 * You will need to use a HashSet
 * 
 * Set<String> courses = new HashSet<>();
 * 
 * courses.add(course);
 * 
 * students.put(student, courses);
 */

/*
 * Using a stream to take a list and make it a string of "value value value"
 * 
 * 
 * students.get(student).stream().collect(Collectors.joining(" ")) - This one may be easier to do as
 * a separate loop, but feel free to play with this one.
 *
 */

public class StudentLoader {
    private static Map<String, Set<String>> students = new HashMap<>();

    // todo: write a program that reads
    // the courses.txt file, and links
    // all classes with the String (name) of the student
    // outputs then will be "person has completed class1 class2 etc"
    // for each student
    public static void main(String[] args) {
        Student st1 = new Student("A", 1);
        Student st2 = new Student("B", 2);
        Student st3 = new Student("C", 3);

        students.put(st1.getName(), Set.of("class 1", "class 2"));
        students.put(st2.getName(), Set.of("class 4", "class 5"));
        students.put(st3.getName(), Set.of("class 6"));

        try {
            List<String> lines = new ArrayList<>();
            List<String> sdt_class = students.entrySet().stream().map(x -> {
                String name = x.getKey();
                String cls = "| ";
                for (String s : x.getValue()) {
                    cls += s + " | ";
                }
                return name + " takes:\n" + cls;
            }).toList();
            for (String s : sdt_class) {
                lines.add(s);
            }

            Files.write(Path.of("courses.txt"), lines);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
