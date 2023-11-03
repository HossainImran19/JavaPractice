package advance.java.imran.c.method.reference.a.types.references.a.stetic;

import java.util.function.BiFunction;
import java.util.function.Function;

public class StaticRefExample {


    public static void main(String[] args) {

        // 1. This is an example of static method ref.
        // Here parseInt is a static method of Integer class.
        // In this example JavaC can guess
        // the return type and parameter type of this method
        // from the target type Function<String, Integer> .
        Function<String, Integer> mapper = Integer::parseInt;

        // It will give a compiler error...
        // Because the method sum will take two parameters.
        // And target type of Function is not matching with the lamda target type...
        // Function<Integer, Integer> mapper = Integer::sum;

        // This will work...
        BiFunction<Integer, Integer, Integer> mapper1 = IntergerDemo::apply;

        Calculator calculator = new Calculator();

        // The following two lines are same....
        calculator.calculate(8.0, a -> Math.sin(a));
        calculator.calculate(10.0, Math::sin);

    }
}

class Calculator {
    public double calculate(Double d, Function<Double, Double> func) {

        return func.apply(d);
    }


}
