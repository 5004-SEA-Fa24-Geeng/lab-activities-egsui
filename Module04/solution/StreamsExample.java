package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamsExample {
    public static List<Integer> getEvens(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evens.add(number);
            }
        }
        return evens;
    }

    public static void main(String[] args) {
        // Get even iterating implementation
//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // this function is a quick way to build a list
//        List<Integer> evens = getEvens(numbers);
//        System.out.println(evens);

        // Stream Example
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // this function is a quick way to build a list
        List<Integer> evens2 = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evens2);

        // Stream reduce method
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        // Stream map
        List<Integer> integers2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squared = integers2.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(squared);

        // Stream sorted
        List<Integer> unsorted = Arrays.asList(5, 3, 1, 2, 4);
        List<Integer> sorted = unsorted.stream().sorted().collect(Collectors.toList());
        System.out.println(unsorted);
        System.out.println(sorted);

    }
}