package advance.java.imran.IStream.introduction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class SomeMethods {
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
}
