package advance.java.imran.IStream.introduction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class SomeMethods {
    public static void main(String[] args) {
        // 1. Collection.stream() it converts a Collection to a stream
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();
        Set<Integer> set = new HashSet<>();
        Stream<Integer> integerStream = set.stream();

        //============================================
        // 2. Stream.of() is used when we need a stream based on an ad hoc basis.
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5);

        String[] names = {"imrann", "mizan", "holly"};
        Stream<String> stringStream1 = Stream.of(names);

        //============================================
        // 3. To prevent null pointer exceptions, we use Stream.empty() for creating a empty stream.
        Stream<String> emptyStream = Stream.empty();

        //============================================
        // 4. Infinite Stream can be created.
        // The following stream method will create a Geometric Progression
        Stream<Integer> sequence = Stream.iterate(1, val -> val * 2);
        // The following line will print the first 10 terms of the sequence.
        // Here limit() is a short-circuit operation which is responsible halt the infinite stream.
        sequence.limit(10).forEach(val -> System.out.println(val + ", "));

        // Printing the first 10 number using do while loop.
        int x = 1;
        do {
            System.out.print(x + " ");
            x++;
        } while (x <= 10);
        System.out.println("\nBy using Stream.iterator() method.......");
        // By using stream
        Stream.iterate(1, val -> ++val)
                .limit(10)
                .forEach(val -> System.out.print(val + " "));
    }

}
