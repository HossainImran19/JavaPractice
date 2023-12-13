package advance.java.imran.HAdvanceGenerics.AGenericsInheritanceSubTyping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowerBound {

    public static void main(String[] args) {
        List<Integer> src = List.of(1, 2, 3, 4);
        List<Integer> dest = new ArrayList<>(Collections.nCopies(src.size(), null));

        // PECS: Producer extends and Consumer super. This is a Mnemonic.
        // This means..
        // Extends will be used when we want to provide a value and
        // Super will be used when we want to read a value.
        // Collections.copy(List<? super T> destination, List<? extends T> source);
        Collections.copy(dest, src);
        printAll(dest);
    }

    public static void printAll(List<Integer> dest) {
        // forEach method accepts a Consumer<? super T> object,
        // where T is Integer in this case.
        dest.forEach(System.out::println);
    }
}
