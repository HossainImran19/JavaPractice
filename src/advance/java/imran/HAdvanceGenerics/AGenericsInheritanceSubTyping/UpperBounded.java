package advance.java.imran.HAdvanceGenerics.AGenericsInheritanceSubTyping;

import java.util.List;

public class UpperBounded {

    // This method will accept a list with
    // an upper-bounded type of the Number class.
    // That's mean BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, and Short
    // would be accepted by the method.
    public static double sumaAll(List<? extends Number> list) {
        double sum = 0;
        for (var number : list)
            sum += number.doubleValue();
        return sum;
    }
}
