package advance.java.imran.lamda.expression;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntegerFinderDemoWithImperativeProg {



    private static Map<String , Long> countFrequency(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
    }

    public static void main(String[] args) {
        List<String> words
                = Arrays
                .asList("Hello", "World",
                        "Bangladesh", "Hello",
                        "Imran", "Demo", "World");

        Map<String , Long> map = countFrequency(words);

        System.out.println(map);
    }
}
