package advance.java.imran.HAdvanceGenerics.AGenericsInheritanceSubTyping;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

public class SubTyping {

    public static void main(String[] args) {
        // Since Object class is super class of all classes in java,
        // so we can put any (Integer) object into the Object class object.
        Object object = new Object();
        Integer integer = 10;
        object = integer;

        // In this case Number is the super class of BigDecimal and Integer class,
        // so we can replace the Number object with these objects.
        Holder<Number> numberHolder = new Holder<>();
        numberHolder.setObject(BigDecimal.ONE);
        numberHolder.setObject(2);


        Holder<Holder<Number>> holderHolder = new Holder<>();
        Holder<Integer> integerHolder = new Holder<>();

        // Here Holder<Integer> is not a subtype of Holder<Number>.
        // So the following line will give a CE.
        // Though Number is the super class of Integer class but
        // Holder<Number> is not the super class of Holder<Integer> class.
        // holderHolder.setObject(integerHolder);

        // For the above reason we can't put strings into objects.
        List<String> strings = List.of("Hell", "world");
        List<Object> objects = List.of(new Object());
        // objects = strings;

        // We can not pass num as argument to processWithNumberList.
        // But using wildcard '?' we can say that to the method
        // the type is 'unknown'.
        // Now we can pass any type of object.
        List<Integer> num = List.of(1, 2,3, 4, 5);
        processWithUnknownList(num);

        List<Double> num1 = List.of(1.3, 2.5,3.3, 4.3, 5.3);
        processWithUnknownList(num);




    }

    public static Number processWithNumberList(List<Number> list) {
        int sum = 0;
        for (Number number : list) {
            sum += number.intValue();
        }
        return sum;
    }

    // Using Unbounded wildcard we can pass
    // any type List of object in this method.
    // But the conundrums remains like
    // we can not write the values of List<?>
    // Because compiler can't determine the exact type in compile time.
    public static void processWithUnknownList(List<?> list) {
        for (var object : list)
            System.out.println(object);
    }
}
