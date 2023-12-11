package advance.java.imran.HAdvanceGenerics.AGenericsInheritanceSubTyping;

import java.math.BigDecimal;
import java.util.List;

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


    }

}
