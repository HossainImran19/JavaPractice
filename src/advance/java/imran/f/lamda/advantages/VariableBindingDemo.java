package advance.java.imran.f.lamda.advantages;

import java.util.function.Function;

class Calculator {
    double calculate(double degree, Function<Double, Double> function) {
        return function.apply(degree);
    }
}

public class VariableBindingDemo {

    public static void main(String[] args) {
        double PI = 3.141592;
        Calculator calculator = new Calculator();

        // In this case variable PI is an effectively final.
        //
        double degree = 90.0;

        // Using Anonymous Inner Class demo.
        double radius1 = calculator.calculate(degree, new Function<Double, Double>() {
            @Override
            public Double apply(Double aDouble) {
                return aDouble * PI / 180;
            }
        });


        // Using Lamda expression
        double radius2 = calculator.calculate(degree, a -> a * PI / 180);
    }
}
