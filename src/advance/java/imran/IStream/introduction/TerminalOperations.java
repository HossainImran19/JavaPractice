package advance.java.imran.IStream.introduction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {

        // 1. Use long count() to find out the number of elements in the stream.
        Stream.of(1, 2, 3, 4).count();
        try {
            List<String> lines = Files.readAllLines(Paths.get("/home/peripatetic/Practice/OOP/Text.txt"));

            long wordCount
                    = lines.stream()
                    .map(line -> line.split("(?<=[,.])|(?=[,.])|\\s+"))
                    .flatMap(Stream::of)
                    .count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //================================
        // 2. Use void forEach(Consumer<? super T> action) to perform an action on each value in the stream.
        // If Stream is parallel then it is no guarantee that forEach() will work in the order in which
        // the elements of the stream is present.

        //================================
        // 3. void forEachOrdered(Consumer<? super T> action) works like forEach() but it is guarantee that
        // it will work in the order in which the elements of the stream is present.
        String[] numbers = {"one", "two", "three", "four", "five"};
        Stream.of(numbers).parallel()
                .forEachOrdered(val -> System.out.println(val + " : " + Thread.currentThread()));

        //================================
        // 4. Use Object[] toArray() to transform a stream to an array.

        //================================
        // 5. Use Optional<T> min(Comparator<? super T> comparator) to return minimum value based on the Comparator.

        //================================
        // 6. Use Optional<T> max(Comparator<? super T> comparator) to return maximum value based on the Comparator.

        //================================
        // 7. Use boolean anyMatch(Predicate<? super T> predicate) to determine if any value in
        // the stream satisfies the specified predicate.

        //================================
        // 8. Use boolean allMatch(Predicate<? super T> predicate) to determine if all value in
        // the stream satisfy the specified predicate.

        //================================
        // 9. Use boolean noneMatch(Predicate<? super T> predicate) to check if none of the values in
        // the stream satisfy the specified predicate.

        //================================
        // 10. Use Optional<T> findFirst() to retrieve the first element in the stream, wrapped in Optional.

        //================================
        // 11. Use Optional<T> findAny() to retrieve any elements in the stream,
        // if none element is found then it will return a empty Optional.

        //================================
        // 12. Use T reduce(T identity, BinaryOperator<T> accumulator) to aggregate all value of the stream.
        // Like, performing summation on all values of the stream and returns the result.

        //================================
        // 13. Use <R, A> R collect(Collector<? super T, A, R> collector) to store the elements of the stream in the container
        // like Collection (List, Set etc.)

    }
}
